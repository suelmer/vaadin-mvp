package com.jrtech.tools.admins.presenter;

import com.jrtech.tools.admins.service.AuthenticationService;
import com.jrtech.tools.admins.views.LoginView;
import com.jrtech.tools.admins.views.LoginViewImpl;
import com.jrtech.tools.admins.views.Presenter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Shawn on 15/11/17.
 */
@Presenter(viewName = LoginViewImpl.NAME)
public class LoginViewPresenter implements ViewPresenter<LoginView>, LoginView.LoginViewListener {

    @Autowired
    private AuthenticationService service;
    private LoginView view;


    @Override
    public void loginAction(String username, String password) {
        service.login(username, password);
    }

    @Override
    public void setView(LoginView view) {
        this.view = view;
        this.view.addListener(this);
    }
}
