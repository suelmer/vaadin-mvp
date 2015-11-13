package com.jrtech.tools.admins.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Shawn on 15/11/8.
 */

@Entity
@Table(name = "administratives")
public class Administrative {
	protected String code;
	protected String name;
	private List<Administrative> children;

    public Administrative() {
	}

	public Administrative(String code, String name) {
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

	@Override
	public String toString() {
	    return String.format("Administrative: code['%s'], name['%s']", code, name);
	}
}
