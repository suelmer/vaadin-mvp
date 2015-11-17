package com.jrtech.tools.admins.views;

/**
 * Created by Shawn on 15/11/17.
 */
public interface LoginView extends PresentableView<LoginView.LoginViewListener> {
    interface LoginViewListener extends ViewListener {
        void loginAction(String username, String password);
    }
}
