package com.mtit.aspects;

import com.mtit.dataaccess.User;

public aspect APOLoggingServiceLayer {
	before() : execution(* com.mtit.service.*.*(..)){
		System.out.println("Accessing Service Layer!");
	}
	
	after() returning(User user) : execution(* loginUser(..)) {
		if(user == null) {
			System.out.println("User login failed!");
		} else {
			System.out.println("User login successful! Loggedin User: " + user.getUserName());
		}
	}
}
