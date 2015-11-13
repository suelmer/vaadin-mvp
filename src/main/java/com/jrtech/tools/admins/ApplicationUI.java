package com.jrtech.tools.admins;

import com.jrtech.tools.admins.views.AdministrativeView;
import com.jrtech.tools.admins.views.AdministrativeViewImpl;
import com.jrtech.tools.admins.views.HomeView;
import com.jrtech.tools.admins.views.IpView;
import com.jrtech.tools.admins.views.IpViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.UI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.annotation.WebServlet;

@SpringUI
@Theme("valo")
public class ApplicationUI extends UI {
	private static final long serialVersionUID = -5409989130902765611L;

	private Log log = LogFactory.getLog(ApplicationUI.class);

    @Autowired
    private AdministrativeView adminView;
    @Autowired
    private IpView ipView;

	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("行政区划查询工具-Administrative tools");
		Navigator nav = new Navigator(this, this);

        nav.addView("", HomeView.class);
        nav.addView(IpViewImpl.NAME, ipView);
		nav.addView(AdministrativeViewImpl.NAME, adminView);

        this.setNavigator(nav);

		log.info("Application UI 已载入");
	}

	@WebServlet(value={"/*", "/VAADIN/*"}, name="ApplicationServlet", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ApplicationUI.class)
	public static class ApplicationServlet extends SpringVaadinServlet {
		private static final long serialVersionUID = -5841541333636041305L;
		
	}
}
