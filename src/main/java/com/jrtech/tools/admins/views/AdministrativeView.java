package com.jrtech.tools.admins.views;

import com.jrtech.tools.admins.domain.Area;

public interface AdministrativeView extends PresentableView<AdministrativeView.AdministrativeViewListener> {
	interface AdministrativeViewListener extends ViewListener {
		void nodeExpand(String itemId);
        void enterView();
	}

	void initView(Area root);
	void expandNode(Area parent);
}
