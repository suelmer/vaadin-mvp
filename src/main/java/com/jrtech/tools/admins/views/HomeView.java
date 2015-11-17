package com.jrtech.tools.admins.views;

/**
 * Created by Shawn on 15/11/17.
 */

public interface HomeView extends PresentableView<HomeView.HomeViewListener> {
    interface HomeViewListener extends ViewListener {
        void logout();
    }
}
