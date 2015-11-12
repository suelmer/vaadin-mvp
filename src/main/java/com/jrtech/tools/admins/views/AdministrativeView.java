package com.jrtech.tools.admins.views;

import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.domain.Country;

public interface AdministrativeView extends PresentableView<AdministrativeView.AdministrativeViewListener> {
	interface AdministrativeViewListener extends ViewListener {
		void nodeExpand(String itemId);
        void enterView();
	}

	void initView(Country root);
	void expandNode(Administrative parent);
}
