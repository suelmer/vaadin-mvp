package com.jrtech.tools.admins.service;

import com.jrtech.tools.admins.ApplicationConfiguration;
import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.domain.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Shawn on 2015/11/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
public class AdministrativeServiceImplTest {

    static final String EXP_CODE = "110000000000";
    static final String EXP_NAME = "北京市";
    static final int CHINA_CHILDREN_COUNT = 34;
    static final int BEIJIN_CHILDREN_COUNT = 2;

    @Autowired
    AdministrativeService service;

    @Test
    public void testGetCountry() throws Exception {
        Country china = service.getCountry("156");

        assertNotNull(china);
        assertEquals("china", china.getName().toLowerCase());
        assertFalse(china.getChildren().isEmpty());
        assertEquals(CHINA_CHILDREN_COUNT, china.getChildren().size());
    }

    @Test
    public void testGetAdministrative() throws Exception {
        Administrative admin = service.getAdministrative(EXP_CODE);

        assertNotNull(admin);
        assertEquals(EXP_NAME, admin.getName());
        assertFalse(admin.getChildren().isEmpty());
        assertEquals(BEIJIN_CHILDREN_COUNT, admin.getChildren().size());
    }
}