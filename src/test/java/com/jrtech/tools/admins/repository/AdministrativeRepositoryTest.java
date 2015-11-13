package com.jrtech.tools.admins.repository;

import com.jrtech.tools.admins.ApplicationConfiguration;
import com.jrtech.tools.admins.domain.Administrative;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ApplicationConfiguration.class)
public class AdministrativeRepositoryTest {
	
	static final String EXP_CODE = "110000000000";
	static final String EXP_NAME = "北京市";
	
	@Autowired
	AdministrativeRepository repo;

	@Test
	public void testFindAdministrativeByName() {
		List<Administrative> admins = repo.findAdministrativeByName(EXP_NAME);
		
		assertNotNull(admins);
		assertEquals(1, admins.size());
		
		Administrative admin = admins.get(0);
		assertNotNull(admin);
		assertEquals(EXP_CODE, admin.getCode());
		assertEquals(EXP_NAME, admin.getName());
	}

	@Test
	public void testFindOne() {
		Administrative admin = repo.findOne(EXP_CODE);
		assertNotNull(admin);
		assertEquals(EXP_CODE, admin.getCode());
		assertEquals(EXP_NAME, admin.getName());
	}
	
}
