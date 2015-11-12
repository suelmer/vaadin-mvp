package com.jrtech.tools.admins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.jrtech.tools.admins.presenter.AdministrativePresenter;
import com.jrtech.tools.admins.repository.AdministrativeRepository;
import com.jrtech.tools.admins.repository.CountryRepository;
import com.jrtech.tools.admins.views.AdministrativeView;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	public AdministrativePresenter getAdministrativePresenter() {
		return new AdministrativePresenter();
	}
}
