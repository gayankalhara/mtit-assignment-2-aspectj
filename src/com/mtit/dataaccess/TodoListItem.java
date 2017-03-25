package com.mtit.dataaccess;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TodoListItem {
	private int todoListItemId;
	private int todoListItemUserId;
	private String todoListItemName;
	private int todoListItemPriority;
	private String todoListItemDueDate;
	private String todoListItemStatus;
	
	public TodoListItem(int id, int userId, String itemName, int itemPriority, String itemDueDate, String itemStatus){
		this.todoListItemId = id;
		this.todoListItemUserId = userId;
		this.todoListItemName = itemName;
		this.todoListItemPriority = itemPriority;
		this.todoListItemDueDate = itemDueDate;
		this.todoListItemStatus = itemStatus;
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
	
	//Getter for Priority
	public int getPriority() {
		return this.todoListItemPriority;
	}
	
	//Setter for Priority
		public void setPriority(int priority) {
			this.todoListItemPriority = priority;
		}
	
	//Getter for Due Date
	public String getDueDate() {	
		return this.todoListItemDueDate;
	}
	
	//Setter for Due Date
		public void setDueDate(String dueDate) {
			this.todoListItemDueDate = dueDate;
		}
	
	//Getter for Status
	public String getStatus() {
		return this.todoListItemStatus;
	}
	
	//Setter for Status
	public void setStatus(String status) {
		this.todoListItemStatus = status;
	}
	
	
	
}
