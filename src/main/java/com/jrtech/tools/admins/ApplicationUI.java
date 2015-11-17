package com.jrtech.tools.admins;


import com.jrtech.tools.admins.views.LoginView;
import com.jrtech.tools.admins.views.LoginViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;


@SpringUI(path = "/views")
@Theme("valo")
public class ApplicationUI extends UI implements ViewChangeListener {
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
        nav.addViewChangeListener(this);
        nav.navigateTo(LoginViewImpl.NAME);

		log.info("Application UI 已载入");
	}

    @Override
    public boolean beforeViewChange(ViewChangeEvent viewChangeEvent) {
        if (viewChangeEvent.getNewView() instanceof LoginView) {
            return true;
        }

        Object securityObject = VaadinSession.getCurrent().getAttribute("securityContext");
        if (null == securityObject) {
            return false;
        }

        SecurityContext ctx = (SecurityContext)securityObject;
        Authentication authentication = ctx.getAuthentication();

        if (null != authentication) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                System.err.println(authority.toString());
            }
        }

        return null != authentication?authentication.isAuthenticated():false;
    }

    @Override
    public void afterViewChange(ViewChangeEvent viewChangeEvent) {

    }
}
