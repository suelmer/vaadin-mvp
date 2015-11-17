package com.jrtech.tools.admins.views;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.SystemError;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

@SpringView(name = HomeViewImpl.NAME)
public class HomeViewImpl extends VerticalLayout implements HomeView {

	private static final long serialVersionUID = -8425054171100248242L;
	public static final String NAME = "";
	
	@PostConstruct
	public void init() {
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
		addComponent(new Label("<h1>行政区划查询工具</h1>", ContentMode.HTML));

		Layout navLayout = new HorizontalLayout();
		navLayout.addComponent(new Button("行政区划查询", (e) -> {
            System.err.println("Navigate to administrative.");
            UI.getCurrent().getNavigator().navigateTo(AdministrativeViewImpl.NAME);
        }));
		navLayout.addComponent(new Label("&nbsp;", ContentMode.HTML));
		navLayout.addComponent(new Button("IP地址查询", (e) -> UI.getCurrent().getNavigator().navigateTo(IpViewImpl.NAME)));

		addComponent(navLayout);

        addComponent(new Button("注销", (e) -> {
            for (HomeViewListener listener : listeners) {
                listener.logout();
            }

            UI.getCurrent().getNavigator().navigateTo(LoginViewImpl.NAME);
        }));
	}

    private List<HomeViewListener> listeners = new ArrayList<>();
    @Override
    public void addListener(HomeViewListener listener) {
        listeners.add(listener);
    }

}
