package com.jrtech.tools.admins.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Shawn on 15/11/8.
 */

@Entity
@Table(name = "administratives")
public class Administrative extends Area<Administrative> {

    public Administrative() {
        super();
	}

	public Administrative(String code, String name) {
		super(code, name);
	}
}
