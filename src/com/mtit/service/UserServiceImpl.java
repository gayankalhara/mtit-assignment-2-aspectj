package com.mtit.service;

import java.sql.SQLException;

import com.mtit.dataaccess.User;
import com.mtit.dataaccess.UserDataAccess;
import com.mtit.dataaccess.UserDataAccessImpl;

public class UserServiceImpl implements UserService{
	
	private User mLoggedInUser = null;
	private UserDataAccess mDataAccess = null; 
	
	public UserServiceImpl() {
		mDataAccess = new UserDataAccessImpl();
	}

	@Override
	public boolean loginUser(String userName, String password) {
		try {
			mLoggedInUser = mDataAccess.loginUser(userName, password);
			
			if(mLoggedInUser != null)
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
