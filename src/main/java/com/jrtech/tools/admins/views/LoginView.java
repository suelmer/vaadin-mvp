package com.jrtech.tools.admins.views;

import javax.annotation.PostConstruct;

import com.jrtech.tools.admins.domain.UserAuthenticationToken;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

@SpringView(name = LoginView.NAME)
public class LoginView extends FormLayout implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String NAME="loginView";
	
	private TextField tfName;
	private PasswordField pfPassword;
	private Button btnLogin;
	
	@PostConstruct
	public void init() {
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		tfName = new TextField("User Name");
		pfPassword = new PasswordField("Password");
		btnLogin = new Button("Login");
		
		btnLogin.addClickListener(new ClickListener(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				String userName = tfName.getValue().trim().toLowerCase();
				String password = pfPassword.getValue().trim().toLowerCase();
				UserAuthenticationToken token = new UserAuthenticationToken(userName);
				
				if ("admin".equals(userName) && "password".equals(password)) {
					token.setAuthenticated(true);
				}
				
				getSession().setAttribute("USER", token);
				UI.getCurrent().getNavigator().navigateTo(HomeView.NAME);
				
			}});
		
		addComponent(tfName);
		addComponent(pfPassword);
		addComponent(btnLogin);
		
		
	}

}
