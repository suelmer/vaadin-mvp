package com.jrtech.tools.admins.service;


/**
 * Created by Shawn on 15/11/17.
 */
public interface AuthenticationService {
    void login(String username, String password);
    void logout();
}
