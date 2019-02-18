package com.controllers;

import com.dao.RoleDao;
import com.models.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class RolesController {

    @Autowired
    private RoleDao roleDao;

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ModelAndView viewRoles(ModelAndView model)
    {
        List<Role> listRoles = roleDao.roleList();

        model.addObject("listRoles", listRoles);

        model.addObject("role", new Role());

        model.setViewName("roles");

        return model;
    }

    @RequestMapping(value = "/addroles", method = RequestMethod.POST)
    public ModelAndView addRole(
        HttpServletRequest request,
        HttpServletResponse response,
        @ModelAttribute("user") Role role
    ) {

        roleDao.addRole(role);

        ModelAndView model = new ModelAndView();

        return viewRoles(model);
    }
}
