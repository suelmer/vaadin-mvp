package com.jrtech.tools.admins.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

	private String code;
	private String name;
	private List<Administrative> children;
	
	public Country() {
	}
	
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	@Id
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_code")
	public List<Administrative> getChildren() {
		return children;
	}
	public void setChildren(List<Administrative> children) {
		this.children = children;
	}
	
}
