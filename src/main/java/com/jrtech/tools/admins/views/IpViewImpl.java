package com.jrtech.tools.admins.views;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class IpViewImpl extends CustomComponent implements IpView, Button.ClickListener {
	
	private static final long serialVersionUID = -6554545251483682858L;
	public static final String NAME = "ipView";
	private Log log = LogFactory.getLog(IpViewImpl.class);

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

		layout.addComponent(new Button("查找Shawn", this));
	}

	private List<IpViewListener> listeners = new ArrayList<IpViewListener>();
	@Override
	public void addListener(IpViewListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		for (IpView.IpViewListener listener : listeners) {
			listener.queryButtonClicked();
		}
	}

	@Override
	public void updateQueryResult(String ipRange) {
		log.info(String.format("Query result: %s", ipRange));
	}

}
