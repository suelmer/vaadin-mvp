package com.jrtech.tools.admins.presenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jrtech.tools.admins.views.IpView;

@Component
public class IpViewPresenter implements ViewPresenter<IpView>, IpView.IpViewListener {

	private IpView view;
	
	@Autowired
	@Override
	public void setView(IpView view) {
		this.view = view;
		view.addListener(this);
	}

	@Override
	public void queryButtonClicked() {
		view.updateQueryResult("192.168.1.1~192.168.1.10");
	}

}
