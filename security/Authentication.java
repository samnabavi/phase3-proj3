package com.security;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import com.model.User;

public class Authentication {
	public static Set<User> userList = new HashSet<>();

	private User currentUser = null;

	public Boolean login(String userName, String password) {
		AtomicBoolean userExists = new AtomicBoolean(false);

		userList.stream().filter(x -> x.getUserName().equals(userName) && x.getPassword().equals(password)).findFirst()
				.ifPresent(x -> {
					userExists.set(true);
					currentUser = x;
				});

		return userExists.get();
	}

	public String getRole() {
		// TODO Auto-generated method stub
		if (currentUser != null) {
			return currentUser.getRole();
		}
		return null;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		if (currentUser != null) {
			return currentUser.getUserName();
		}
		return null;
	}


	public void logout() {
		currentUser = null;
	}

}
