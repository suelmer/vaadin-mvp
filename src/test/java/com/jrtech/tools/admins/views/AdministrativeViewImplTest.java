package com.jrtech.tools.admins.views;

import com.jrtech.tools.admins.ApplicationConfiguration;
import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.presenter.AdministrativeViewPresenter;
import com.vaadin.ui.Tree;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * Created by Shawn on 2015/11/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
public class AdministrativeViewImplTest {

    AdministrativeViewImpl view;
    AdministrativeViewPresenter presenter;
    Tree.ExpandEvent event;

    static final String ADMIN_CODE = "110000000000";

    @Before
    public void setUp() throws Exception {
        view = new AdministrativeViewImpl();
        presenter = mock(AdministrativeViewPresenter.class);
        view.addListener(presenter);
        view.enter(null);

        event = mock(Tree.ExpandEvent.class);
        when(event.getItemId()).thenReturn(ADMIN_CODE);
    }

    @Test
    public void testEnter() throws Exception {
        verify(presenter, times(1)).enterView();
    }

    @Test
    public void testNodeExpand() throws Exception {
        view.nodeExpand(event);
        verify(presenter, times(1)).nodeExpand(ADMIN_CODE);
    }

}