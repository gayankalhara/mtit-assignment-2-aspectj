package com.mtit.service;

import java.sql.SQLException;
import java.util.List;

import com.mtit.dataaccess.TodoListDataAccess;
import com.mtit.dataaccess.TodoListDataAccessImpl;
import com.mtit.dataaccess.TodoListItem;

public class TodoListServiceImpl implements TodoListService{
	
	private TodoListDataAccess mTodoListDataAccess = null;
	
	public TodoListServiceImpl() {
		mTodoListDataAccess = new TodoListDataAccessImpl();
	}

	@Override
	public TodoListItem getTodoListItem(int id) {

		try {
			return mTodoListDataAccess.getTodoListItem(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<TodoListItem> getTodoListItems() {
		try {
			return mTodoListDataAccess.getAllTodoListItems();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
