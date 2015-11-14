package com.jrtech.tools.admins.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Shawn on 2015/11/14.
 */
@MappedSuperclass
public abstract class Area<T> {
    protected String code;
    protected String name;
    private List<T> children;

    public Area() {

    }

    public Area(String code, String name) {
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
    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return String.format("Administrative: code['%s'], name['%s']", code, name);
    }
}
