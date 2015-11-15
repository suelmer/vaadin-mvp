package com.jrtech.tools.admins;


import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


@SpringUI(path = "/views")
@Theme("valo")
public class ApplicationUI extends UI {
	private static final long serialVersionUID = -5409989130902765611L;

	private Log log = LogFactory.getLog(ApplicationUI.class);

    @Autowired
    @Qualifier("myViewProvider")
    private ViewProvider provider;


	@Override
	protected void init(VaadinRequest request) {
        this.setSizeFull();
		getPage().setTitle("行政区划查询工具-Administrative tools");

		Navigator nav = new Navigator(this, this);
        nav.addProvider(provider);

		log.info("Application UI 已载入");
	}
}
