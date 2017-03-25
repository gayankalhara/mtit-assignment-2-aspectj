package com.mtit.aspects;

public aspect AOPLogging {
	
	/**
	 * =====================
	 *  Database Connection
	 * =====================
	 * **/

	before() : execution(* openDatabaseConnection()) {
		System.out.println("Trying to establish a Database Connection...");
	}
	
	after() throwing(RuntimeException ex) : execution(* openDatabaseConnection(..)) {
		System.out.println("Error occurred while trying to establish a Database Connection!");
	}

	after() returning(Object returnVal) : execution(* openDatabaseConnection(..)) {
		System.out.println("Database Connection established successfully! Connection Id: " + returnVal.toString());
	}
}
