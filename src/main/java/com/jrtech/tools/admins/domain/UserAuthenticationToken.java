package com.jrtech.tools.admins.domain;

public class UserAuthenticationToken {

	private String userName;
	private boolean isAuthenticated;
	
	public UserAuthenticationToken(String userName) {
		this(userName, false);
	}
	
	public UserAuthenticationToken(String userName, boolean isAuthenticated) {
		this.userName = userName;
		this.isAuthenticated = isAuthenticated;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
}
