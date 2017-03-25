package com.mtit.service;

import java.util.List;

import com.mtit.dataaccess.TodoListItem;

public interface TodoListService {
	public TodoListItem getTodoListItem(int id);
	public List<TodoListItem> getTodoListItems();
}
