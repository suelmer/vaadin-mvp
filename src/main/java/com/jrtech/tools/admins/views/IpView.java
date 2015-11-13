package com.jrtech.tools.admins.views;

public interface IpView extends PresentableView<IpView.IpViewListener> {
	
	interface IpViewListener extends ViewListener {
		void queryButtonClicked();
	}

	void updateQueryResult(String ipRange);
}
