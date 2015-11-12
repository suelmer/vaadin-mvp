package com.jrtech.tools.admins.views;

import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.repository.AdministrativeRepository;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@SpringView(name = IPView.NAME)
public class IPView extends CustomComponent implements View {
	
	private static final long serialVersionUID = -6554545251483682858L;
	public static final String NAME = "ipView";
	private Log log = LogFactory.getLog(IPView.class);

	@Autowired
	private AdministrativeRepository repository;

	@Override
	public void enter(ViewChangeEvent event) {
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
		
		HorizontalLayout queryLayout = new HorizontalLayout();
		layout.addComponent(queryLayout);
		
		queryLayout.addComponent(new TextField());
		queryLayout.addComponent(new Button("查询", e -> Notification.show("查询IP所在的地理位置")));
		
		Panel map = new Panel();
		layout.addComponent(map);

		layout.addComponent(new Button("查找Shawn", new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(Button.ClickEvent clickEvent) {
				for (Administrative admin : repository.findAll(new PageRequest(5,500))) {
					log.info(admin.toString());
				}
			}
		}));
	}

}
