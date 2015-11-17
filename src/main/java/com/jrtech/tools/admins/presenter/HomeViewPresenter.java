package com.jrtech.tools.admins.presenter;

import com.jrtech.tools.admins.service.AuthenticationService;
import com.jrtech.tools.admins.views.HomeView;
import com.jrtech.tools.admins.views.HomeViewImpl;
import com.jrtech.tools.admins.views.Presenter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Shawn on 15/11/17.
 */
@Presenter(viewName = HomeViewImpl.NAME)
public class HomeViewPresenter implements ViewPresenter<HomeView>, HomeView.HomeViewListener {

    @Autowired
    private AuthenticationService service;

    @Override
    public void logout() {
        service.logout();
    }

    private HomeView view;
    @Override
    public void setView(HomeView view) {
        this.view = view;
        this.view.addListener(this);
    }
}
