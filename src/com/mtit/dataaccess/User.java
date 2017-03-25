package com.mtit.dataaccess;

public class User{
	private int uId;
	private String uUserName;
	private String uPassword;
	private String uEmail;
	private String uFirstName;
	private String uLastName;
	
	public User(int id, String userName, String password, String email, String firstName, String lastName){
		this.uId = id;
		this.uUserName = userName;
		this.uPassword = password;
		this.uEmail = email;
		this.uFirstName = firstName;
		this.uLastName = lastName;
	}

	//Getter for User ID
	public int getId(){
		return this.uId;
	}
	
	//Setter for User ID
	public void setId(int id){
		this.uId = id;
	}
	
	//Getter for User Name
	public String getUserName(){
		return uUserName;
	}
	
	//Setter for User Name
	public void setUserName(String userName) {
		this.uUserName = userName;
	}
	
	//Getter for Password
	public String getPassword(){
		return uPassword;
	}
	
	//Setter for Password
	public void setPassword(String password){
		this.uPassword = password;
	}
	
	//Getter get Email
	public String getEmail(){
		return uEmail;
	}
	
	//Setter for Email
	public void setEmail(String email){
		this.uEmail = email;
	}

	//Getter for First Name
	public String getFirstName(){
		return this.uFirstName;
	}
	
	//Setter for First Name
	public void setFirstName(String firstName){
		this.uFirstName = firstName;
	}

	//Getter for Last Name
	public String getLastName(){
		return this.uLastName;
	}
	
	//Setter for Last Name
	public void setLastName(String lastName){
		this.uLastName = lastName;
	}
}
