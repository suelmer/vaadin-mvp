package com.jrtech.tools.admins.views;

import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.domain.Country;
import com.vaadin.navigator.View;

public interface AdministrativeView extends View {
	interface ItemExpandListener {
		void nodeExpand(String itemId);
	}
	interface EnterViewListener {
		void enterView();
	}
	
	void addInitListener(EnterViewListener evListener);
	void addExpandListener(ItemExpandListener ieListener);
	void initView(Country root);
	void expandView(Administrative parent);
}
