package com.mtit.dataaccess;

import java.sql.SQLException;

public interface UserDataAccess {
	public User loginUser(String userName, String password) throws SQLException;
}
