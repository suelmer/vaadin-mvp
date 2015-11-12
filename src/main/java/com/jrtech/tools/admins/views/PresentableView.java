package com.jrtech.tools.admins.views;

import com.vaadin.navigator.View;

/**
 * Created by Shawn on 15/11/12.
 */
public interface PresentableView<T extends ViewListener> extends View {
    void addListener(T listener);
}
