package com.mycompany.vaadin.app.ui;

import com.vaadin.addon.touchkit.ui.EmailField;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class FormView extends NavigationView {

    public FormView() {
        setCaption("Please Login");
        final VerticalComponentGroup content = new VerticalComponentGroup();

        final TextField nameField = new TextField("Username");
        nameField.setInputPrompt("Enter your Username...");
        nameField.setComponentError(new UserError("Username is required"));
        content.addComponent(nameField);
 

        final EmailField passwordField = new EmailField("Password");
        passwordField.setInputPrompt("Enter your Password...");
        passwordField.setComponentError(new UserError("Password is required"));
        content.addComponent(passwordField);

        final Button submitButton = new Button("Login");
        submitButton.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                Notification.show("Thanks!");
            }
        });

        setContent(new CssLayout(content, submitButton));
    }

}
