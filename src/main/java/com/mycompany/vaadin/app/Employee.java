package com.mycompany.vaadin.app;

public class Employee implements IEmployee {
	
	private int numberOfLogin=0;
	
	private String username;
	
	private String password;

	@Override
	public void setUsername(String username) {
		this.username=username;
	}

	@Override
	public void setPassword(String password) {
		this.password=password;
	}

	@Override
	public int numberOfLoginClick() {
		return numberOfLogin;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setNumberOfLoginClick(int s) {
		this.numberOfLogin=s;
	}

}
