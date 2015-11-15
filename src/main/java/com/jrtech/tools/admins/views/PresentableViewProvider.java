package com.jrtech.tools.admins.views;

import com.jrtech.tools.admins.presenter.ViewPresenter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.navigator.SpringViewProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shawn on 15/11/15.
 */

@SpringComponent("myViewProvider")
public class PresentableViewProvider implements ViewProvider {
    @Autowired
    private SpringViewProvider provider;

    @Autowired
    private ApplicationContext ctx;

    private Map<String, ViewPresenter> map = new HashMap<>();

    @Autowired
    public PresentableViewProvider(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @PostConstruct
    public void init() {
        Map<String, Object> presenters = ctx.getBeansWithAnnotation(Presenter.class);

        for (String key : presenters.keySet()) {
            Presenter annotation = ctx.findAnnotationOnBean(key, Presenter.class);
            String viewName = annotation.viewName();
            Object object = ctx.getBean(key);

            try {
                ViewPresenter presenter = (ViewPresenter) object;
                map.put(viewName, presenter);
            } catch (ClassCastException e) {

            }

        }

    }

    @Override
    public String getViewName(String s) {
        return provider.getViewName(s);
    }

    @Override
    public View getView(String s) {
        View view = provider.getView(s);

        try {
            PresentableView presentableView = (PresentableView)view;

            ViewPresenter presenter = map.get(s);
            if (null == presenter) {
                throw new IllegalStateException(String.format("There is no presenter for View: %s", s));
            }

            presenter.setView(presentableView);

            return  presentableView;
        } catch (ClassCastException e) {
            return view;
        }
    }

}
