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
	
	before() : execution(* addTodoListItem(..)) {
		System.out.println("Trying to Add New Todo Item!");
	}
	
	after() returning(boolean status) : execution(* addTodoListItem(..)) {
		if(status == true) {
			System.out.println("Succcessfully Added New Todo Item!");
		} else {
			System.out.println("Failed to add New Todo Item!");
		}
	}
}
