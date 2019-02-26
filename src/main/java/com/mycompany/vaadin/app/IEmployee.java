package com.mycompany.vaadin.app;

public interface IEmployee {
	void setUsername(String username);

	void setPassword(String password);

	String getPassword();
	
	String getUsername();

	int numberOfLoginClick();
}