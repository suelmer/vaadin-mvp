package com.jrtech.tools.admins.views;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import org.springframework.security.authentication.BadCredentialsException;

import java.util.ArrayList;
import java.util.List;

@SpringView(name = LoginViewImpl.NAME)
public class LoginViewImpl extends FormLayout implements LoginView, ClickListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final String NAME = "loginView";

    private TextField tfName;
    private PasswordField pfPassword;
    private Button btnLogin;


    @PostConstruct
    public void init() {
        tfName = new TextField("User Name");
        pfPassword = new PasswordField("Password");
        btnLogin = new Button("Login", this);

        addComponent(tfName);
        addComponent(pfPassword);
        addComponent(btnLogin);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    @Override
    public void buttonClick(ClickEvent clickEvent) {
        try {
            for (LoginViewListener listener : listeners) {
                listener.loginAction(tfName.getValue().trim().toLowerCase(), pfPassword.getValue().trim().toLowerCase());
            }

            UI.getCurrent().getNavigator().navigateTo(HomeViewImpl.NAME);
        } catch (BadCredentialsException e) {
            Notification.show("用户名或密码错误!", Notification.Type.ERROR_MESSAGE);
        }

    }

    private List<LoginViewListener> listeners = new ArrayList<>();

    @Override
    public void addListener(LoginViewListener listener) {
        listeners.add(listener);
    }
}
