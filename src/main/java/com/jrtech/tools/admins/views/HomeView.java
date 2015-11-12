package com.jrtech.tools.admins.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = HomeView.NAME)
public class HomeView extends VerticalLayout implements View {

	private static final long serialVersionUID = -8425054171100248242L;
	public static final String NAME = "";

	@Override
	public void enter(ViewChangeEvent event) {
		addComponent(new Label("<h1>行政区划查询工具</h1>", ContentMode.HTML));

		Layout navLayout = new HorizontalLayout();
		navLayout.addComponent(new Button("行政区划查询", (e) -> UI.getCurrent().getNavigator().navigateTo(AdministrativeViewImpl.NAME)));
		navLayout.addComponent(new Label("&nbsp;", ContentMode.HTML));
		navLayout.addComponent(new Button("IP地址查询", (e) -> UI.getCurrent().getNavigator().navigateTo(IPView.NAME)));

		addComponent(navLayout);
	}

}
