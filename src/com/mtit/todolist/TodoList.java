package com.mtit.todolist;

import com.mtit.service.UserService;
import com.mtit.service.UserServiceImpl;
import com.mtit.service.TodoListService;
import com.mtit.service.TodoListServiceImpl;

public class TodoList {
	
	private static UserService userService = null;
	private static TodoListService todoListService = null;
	
	public static void main(String[] args) {
		initializeDatabase();
		initializeServices();
	}
	
	private static void initializeDatabase(){
		DatabaseConnection.createDatabaseConnection();
	}
	
	private static void initializeServices(){
		userService = new UserServiceImpl();
		todoListService = new TodoListServiceImpl();
	}
}
