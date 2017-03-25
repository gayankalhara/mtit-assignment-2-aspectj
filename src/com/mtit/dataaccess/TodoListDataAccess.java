package com.mtit.dataaccess;

import java.sql.SQLException;
import java.util.List;

public interface TodoListDataAccess {
	public TodoListItem getTodoListItem(int itemId) throws SQLException;
	public List<TodoListItem> getAllTodoListItems() throws SQLException;
	public boolean insertTodoListItem(TodoListItem todoListItem) throws SQLException;
	public boolean updateTodoListItem(TodoListItem todoListItem) throws SQLException;
	public boolean deleteTodoListItem(TodoListItem todoListItem) throws SQLException;
}
