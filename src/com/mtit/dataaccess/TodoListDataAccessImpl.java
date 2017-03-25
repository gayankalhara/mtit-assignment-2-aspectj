package com.mtit.dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import com.mtit.todolist.DatabaseConnection;

public class TodoListDataAccessImpl implements TodoListDataAccess {

	@Override
	public TodoListItem getTodoListItem(int itemId) throws SQLException {
		Connection connection = DatabaseConnection.openDatabaseConnection();
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM todolist WHERE item_id = " + itemId);
		
		while(resultSet.next()) {
			TodoListItem todolistItem = getTodoListItemsFromResultSet(resultSet);
			resultSet.close();
			statement.close();
			DatabaseConnection.closeDatabaseConnection();
			return todolistItem;
		}
		
		return null;
	}
	
	private TodoListItem getTodoListItemsFromResultSet(final ResultSet resultSet) throws SQLException {
		
		int itemId = resultSet.getInt("item_id");
		int userId = resultSet.getInt("user_id");
		String taskName = resultSet.getString("task_name");
		int priority = resultSet.getInt("priority");
		String dueDate = resultSet.getString("due_date");
		String status = resultSet.getString("status");
		
		return new TodoListItem(itemId, userId, taskName, priority, dueDate, status);
	}

	@Override
	public List<TodoListItem> getAllTodoListItems() throws SQLException {
		Connection connection = DatabaseConnection.openDatabaseConnection();
		
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM todolist");
		
		List<TodoListItem> list = new Vector<TodoListItem>();
		
		while(rs.next()) {
			TodoListItem todolistItem = getTodoListItemsFromResultSet(rs);
			list.add(todolistItem);
		}
		
		rs.close();
		statement.close();
		DatabaseConnection.closeDatabaseConnection();

		return list;

	}

}
