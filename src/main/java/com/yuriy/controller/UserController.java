package com.yuriy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.yuriy.model.User;
import com.yuriy.service.UserService;

/**
 * Created by yyakymchuk on 5/7/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		Preconditions.checkArgument(userService != null);

		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User getByID(@PathVariable final Long id) {
		return userService.getUser(id);
	}
}
