package com.sumon.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumon.api.entity.User;
import com.sumon.api.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		List<User> users = service.findAll();
		model.addAttribute("userList", users);
		return "user-list";
	}

	@RequestMapping(value = "/greetingEs", method = RequestMethod.GET)
	public String sayHola() {
		return "greeting-spanish";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@ModelAttribute User user, ModelMap model) {
		user = service.create(user);
		model.addAttribute("user", user);
		return "success";
	}
}
