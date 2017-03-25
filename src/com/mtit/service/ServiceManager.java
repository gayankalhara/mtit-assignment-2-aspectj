package com.mtit.service;

public class ServiceManager {
	private static TodoListService mTodoListService = null;
	private static UserService  mUserService = null;
	
	public static TodoListService getMovieService() {
		if(mTodoListService == null) {
			mTodoListService = new TodoListServiceImpl();
		}
		
		return mTodoListService;
	}
	
	public static UserService getUserService() {
		if(mUserService == null) {
			mUserService = new UserServiceImpl();
		}
		
		return mUserService;
	}
}
