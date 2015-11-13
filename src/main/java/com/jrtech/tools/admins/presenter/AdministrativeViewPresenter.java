package com.jrtech.tools.admins.presenter;

import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.domain.Country;
import com.jrtech.tools.admins.service.AdministrativeService;
import com.jrtech.tools.admins.views.AdministrativeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdministrativeViewPresenter implements ViewPresenter<AdministrativeView>, AdministrativeView.AdministrativeViewListener {

    private AdministrativeView view;
    @Autowired
    private AdministrativeService service;

    @Autowired
    @Override
    public void setView(AdministrativeView view) {
        this.view = view;
        this.view.addListener(this);
    }

    @Override
    public void enterView() {
    	Country china = service.getCountry("156");
        view.initView(china);
    }

    @Override
    public void nodeExpand(String itemId) {
    	Administrative admin = service.getAdministrative(itemId);
		view.expandNode(admin);
    }
}
