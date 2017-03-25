package com.mtit.todolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DATABASE = "jdbc:sqlite:todolist.sqlite";
	private static Connection dbConnection = null;
	
    public static Connection getDatabaseConnection()
    {
    	return dbConnection;
    }
    
    public static void createDatabaseConnection() {
    	try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Database Connector not found!", e);
			}
			dbConnection = DriverManager.getConnection(DATABASE);
    	} catch (SQLException e) {
             throw new RuntimeException("Unexpected error occured while connecting to the database!", e);
    	} catch (Exception e){
    		throw new RuntimeException("An unexpected error occured!", e);
    	}
    }
    
    public static void closeDatabaseConnection() {
    	if(dbConnection != null) {
    		try {
    			dbConnection.close();
			} catch (SQLException e) {
				throw new RuntimeException("An unexpected error occured while closing the database connection!", e);
			}
    	}
    }
}
