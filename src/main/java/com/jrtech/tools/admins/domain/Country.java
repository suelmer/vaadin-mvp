package com.jrtech.tools.admins.domain;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "countries")
public class Country extends Area<Administrative> {

	public Country() {
        super();
	}
	
	public Country(String code, String name) {
		super(code, name);
	}

}
