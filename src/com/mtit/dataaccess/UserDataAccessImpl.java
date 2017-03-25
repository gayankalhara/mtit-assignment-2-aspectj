package com.mtit.dataaccess;

import com.mtit.todolist.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataAccessImpl implements UserDataAccess {

	@Override
	public User loginUser(String userName, String password) throws SQLException {
		Connection connection = DatabaseConnection.openDatabaseConnection();
		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
		
		statement.setString(1, userName);
		statement.setString(2, password);
		
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {
			User user = getUserFromResultSet(resultSet);
			resultSet.close();
			statement.close();
			DatabaseConnection.closeDatabaseConnection();
			return user;
		}
		
		return null;
	}
	
	private User getUserFromResultSet(final ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String userName = resultSet.getString("username");
		String password = resultSet.getString("password");
		String email = resultSet.getString("email");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");
		
		return new User(id, userName, password, email, firstName, lastName);
	}

}
