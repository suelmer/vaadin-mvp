package com.jrtech.tools.admins.views;

import com.vaadin.spring.annotation.SpringComponent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Created by Shawn on 15/11/15.
 */

@Target({ ElementType.TYPE })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@SpringComponent
public @interface Presenter {

    /***
     * Presenter希望连接到的视图名称
     * @return
     */
    String viewName() default "";
}
