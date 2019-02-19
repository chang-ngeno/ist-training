package com.controllers;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.editors.RoleEditor;
import com.models.Role;
import com.models.User;
import com.service.UserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/users")
@SessionAttributes("user")
public class RegistrationController
{
    @Autowired
    UserServiceDao manager;

    private Validator validator;

    public RegistrationController()
    {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Role.class, new RoleEditor());
    }

    @ModelAttribute("allRoles")
    public List<Role> populateDepartments()
    {
        List<Role> roles = manager.getAllRoles();

        System.out.println("we are here");
        return roles;
    }

    @ModelAttribute("allUsers")
    public List<User> populateUsers()
    {
        List<User> users = manager.getAllUsers();

        return users;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model)
    {
        User userVO = new User();
        model.addAttribute("user", userVO);

        System.out.println("loading page");
        return "listUserView";
    }

    @RequestMapping(method = RequestMethod.POST)

    public String submitForm(
            @ModelAttribute("user") User userVO,
            BindingResult result,
            SessionStatus status
    )
    {

        Set<ConstraintViolation<User>> violations = validator.validate(userVO);

        for (ConstraintViolation<User> violation : violations)
        {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();

            result.addError(new FieldError(
                    "user",
                    propertyPath,
                    "Invalid "+ propertyPath + "(" + message + ")")
            );
        }

        if (result.hasErrors()) {
            return "listUserView";
        }

        manager.register(userVO);

        status.setComplete();

        return "redirect:users";
    }

}
