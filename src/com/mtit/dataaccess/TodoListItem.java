package com.mtit.dataaccess;

public class TodoListItem {
	private int todoListItemId;
	private int todoListItemUserId;
	private String todoListItemName;
	
	public TodoListItem(int id, int userId, String itemName){
		this.todoListItemId = id;
		this.todoListItemUserId = userId;
		this.todoListItemName = itemName;
	}
	
	//Getter for ID
	public int getId() {
		return this.todoListItemId;
	}
	
	//Setter for ID
	public void setId(int id){
		this.todoListItemId = id;
	}
	
	//Getter for UserId
	public int getUserId(){
		return this.todoListItemUserId;
	}
	
	//Setter for UserId
	public void setUserId(int userId){
		this.todoListItemUserId = userId;
	}
	
	//Getter for Item Name
	public String getItemName() {
		return this.todoListItemName;
	}
	
	//Setter for Item Name
	public void setItemName(String itemName){
		this.todoListItemName = itemName;
	}
}
