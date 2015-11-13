package com.jrtech.tools.admins.presenter;

import com.jrtech.tools.admins.ApplicationConfiguration;
import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.domain.Country;
import com.jrtech.tools.admins.service.AdministrativeService;
import com.jrtech.tools.admins.views.AdministrativeView;
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
public class AdministrativeViewPresenterTest {

    static final String COUNTRY_CODE = "156";
    static final String COUNTRY_NAME = "中国";
    static final String ADMIN_CODE = "110000000000";
    static final String ADMIN_NAME = "北京市";

    AdministrativeViewPresenter presenter;
    AdministrativeView view;

    Country country = new Country(COUNTRY_CODE, COUNTRY_NAME);
    Administrative admin = new Administrative(ADMIN_CODE, ADMIN_NAME);

    @Before
    public void setUp() {
        AdministrativeService service = mock(AdministrativeService.class);
        presenter = new AdministrativeViewPresenter(service);

        view = mock(AdministrativeView.class);
        presenter.setView(view);

        when(service.getCountry(COUNTRY_CODE)).thenReturn(country);
        when(service.getAdministrative(ADMIN_CODE)).thenReturn(admin);
    }

    @Test
    public void testSetView() throws Exception {
        verify(view, times(1)).addListener(presenter);
    }

    @Test
    public void testEnterView() throws Exception {
        presenter.enterView();
        verify(view, times(1)).initView(country);
    }

    @Test
    public void testNodeExpand() throws Exception {
        presenter.nodeExpand(ADMIN_CODE);
        verify(view, times(1)).expandNode(admin);
    }
}