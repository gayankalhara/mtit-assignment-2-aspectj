package com.mtit.aspects;

public aspect AOPLogging {
	
	before() : execution(* createDatabaseConnection()) {
		System.out.println("Trying to establish a Database Connection..");
	}
	
	after() throwing(RuntimeException ex) : execution(* createDatabaseConnection(..)) {
		System.out.println("Error occured while trying to establish a Database Connection!");
		ex.printStackTrace();
	}
}
