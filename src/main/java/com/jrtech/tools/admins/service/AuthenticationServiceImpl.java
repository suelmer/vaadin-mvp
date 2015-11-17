package com.jrtech.tools.admins.service;


import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shawn on 15/11/17.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    AuthenticationManager authManager;

    @Override
    public void login(String username, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        HttpServletRequest request = ((VaadinServletRequest)VaadinService.getCurrentRequest()).getHttpServletRequest();
        token.setDetails(new WebAuthenticationDetails(request));

        Authentication authentication = authManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        VaadinSession.getCurrent().setAttribute("securityContext", SecurityContextHolder.getContext());
    }

    @Override
    public void logout() {
        SecurityContext ctx = (SecurityContext)VaadinSession.getCurrent().getAttribute("securityContext");
        ctx.setAuthentication(null);
        System.err.println("logout done");
    }
}
