package com.jrtech.tools.admins.views;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.spring.annotation.UIScope;

@Component
@UIScope
public class AdminsViewProvider implements ViewProvider {
	
	private ViewProvider provider;
	
	@Autowired
	private HomeViewImpl homeViewImpl;
	@Autowired
	private AdministrativeView adminView;
	@Autowired
	private IpView ipView;
	
	private Map<String, Class> maps = new HashMap<String, Class>();
	
	
	public AdminsViewProvider() {
		this.provider = new Navigator.ClassBasedViewProvider("", HomeViewImpl.class);
		
		maps.put(HomeViewImpl.NAME, HomeViewImpl.class);
		maps.put(AdministrativeViewImpl.NAME, AdministrativeViewImpl.class);
		maps.put(IpViewImpl.NAME, IpView.class);
	}

	@Override
	public String getViewName(String viewAndParameters) {
		return provider.getViewName(viewAndParameters);
	}

	@Override
	public View getView(String viewName) {
		if (maps.containsKey(viewName)) {
			try {
				@SuppressWarnings("unchecked")
				Class<View> clazz = maps.get(viewName);
				View viewObject = clazz.newInstance();
				return viewObject;
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
