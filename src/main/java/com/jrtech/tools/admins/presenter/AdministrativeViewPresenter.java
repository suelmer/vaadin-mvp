package com.jrtech.tools.admins.presenter;

import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.domain.Country;
import com.jrtech.tools.admins.service.AdministrativeService;
import com.jrtech.tools.admins.views.AdministrativeView;
import com.jrtech.tools.admins.views.AdministrativeViewImpl;
import com.jrtech.tools.admins.views.Presenter;
import org.springframework.beans.factory.annotation.Autowired;

@Presenter(viewName = AdministrativeViewImpl.NAME)
public class AdministrativeViewPresenter implements ViewPresenter<AdministrativeView>, AdministrativeView.AdministrativeViewListener {

    private AdministrativeView view;
    private AdministrativeService service;

    @Autowired
    public AdministrativeViewPresenter(AdministrativeService service) {
        this.service = service;
    }

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
