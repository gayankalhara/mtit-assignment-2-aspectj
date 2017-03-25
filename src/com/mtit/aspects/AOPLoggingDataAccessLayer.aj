package com.mtit.aspects;

public aspect AOPLoggingDataAccessLayer {
	before() : execution(* com.mtit.dataaccess.*.*(..)){
		System.out.println("Accessing Data Access Layer!");
	}

}
