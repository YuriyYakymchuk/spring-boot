package com.yuriy.service.impl;

import org.springframework.stereotype.Service;

import com.yuriy.model.User;
import com.yuriy.service.UserService;

/**
 * Created by yyakymchuk on 5/7/2017.
 */
@Service
public class UserServiceImpl implements UserService{

	@Override
	public User getUser(final Long id) {
		final boolean isValid = validateUserID(id);
		if(!isValid) {
			throw new IllegalArgumentException(String.format("Specified User ID %s is invalid", id));
		}
		return new User(id, "Yuriy", "Yakymchuk");
	}

	private boolean validateUserID(final Long id) {
		return id != null && id > 0;
	}
}
