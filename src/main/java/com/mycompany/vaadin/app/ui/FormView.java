package com.mycompany.vaadin.app.ui;

import java.util.ArrayList;

import com.mycompany.vaadin.app.Employee;
import com.mycompany.vaadin.app.IEmployee;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class FormView extends NavigationView {

	public FormView() {
		setCaption("Please Login");
		final VerticalComponentGroup content = new VerticalComponentGroup();

		final ArrayList<IEmployee> employeis = new ArrayList<IEmployee>();
		final TextField nameField = new TextField("Username");
		nameField.setInputPrompt("Enter your Username...");
		nameField.setRequired(true);
		nameField.setComponentError(new UserError("Username is required"));
		content.addComponent(nameField);

		final PasswordField passwordField = new PasswordField("Password");
		// passwordField.setInputPrompt("Enter your Password...");
		passwordField.setComponentError(new UserError("Password is required"));
		passwordField.focus();
		content.addComponent(passwordField);

		passwordField.setRequired(true);

		final Label label = new Label();
		label.setStyleName("center");
		content.addComponent(label);

		final Table table = new Table();
		// Define two columns for the built-in container
		table.addContainerProperty("Username", String.class, null);
		table.addContainerProperty("Password", String.class, null);

		final Button submitButton = new Button("Login");
		submitButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					passwordField.validate();

					IEmployee employee = new Employee();
					employee.setPassword(passwordField.getValue());
					employee.setUsername(nameField.getValue());
					employeis.add(employee);
					label.setValue("You Clicked " + String.valueOf(employeis.size()) + " time(s) on login button");
					int i = 1;
					for (IEmployee emp : employeis) {
						table.addItem(new Object[] { emp.getUsername(), emp.getPassword() }, i);
						i++;
					}
					// Show exactly the currently contained rows (items)
					table.setPageLength(table.size());
					// Notification.show(String.valueOf(employeis.size()));
				} catch (InvalidValueException e) {
					// Notification.show("Password is required");
					label.setValue("Password is required");
				}
			}
		});
		content.addComponent(new CssLayout(submitButton));
		content.addComponent(table);
		setContent(new CssLayout(content));
	}

}