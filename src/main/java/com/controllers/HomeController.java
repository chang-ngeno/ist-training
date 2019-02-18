package com.controllers;

import com.dao.UserDao;
import com.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private UserDao userDao;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView viewHome(ModelAndView model) throws IOException {

		List<User> listUsers = userDao.userList();

		model.addObject("listUsers", listUsers);

		model.setViewName("home");

		return model;
	}

//	@RequestMapping(value="/delete.html", method = RequestMethod.POST)
//	public ModelAndView checkOut(ModelAndView model, @RequestParam(value = "username", required = false) String id) throws SQLException {
//
//		 call service to delete the user
//
//
//		list back the users
//
//		List<User> userList = clinicService.getAllpatients();
//
//		model.addObject("userList", userList);
//
//		ModelAndView model = new ModelAndView("home");
//
//		return model;
//
//	}
}
