package com.jrtech.tools.admins.repository;

import static org.junit.Assert.*;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.jrtech.tools.admins.ApplicationConfiguration;
import com.jrtech.tools.admins.domain.Administrative;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ApplicationConfiguration.class)
public class AdministrativesRepositoryTest {
	
	static final String EXP_CODE = "110000000000";
	static final String EXP_NAME = "北京市";
	static final int CHILD_COUNT = 2;
	
	@Autowired
	AdministrativeRepository repo;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAdministrativesByName() {
		List<Administrative> admins = repo.findAdministrativesByName(EXP_NAME);
		
		assertNotNull(admins);
		assertEquals(1, admins.size());
		
		Administrative admin = admins.get(0);
		assertNotNull(admin);
		assertEquals(EXP_CODE, admin.getCode());
		assertEquals(EXP_NAME, admin.getName());
	}

	@Test
	@Transactional
	public void testFindOne() {
		Administrative admin = repo.findOne(EXP_CODE);
		
		assertNotNull(admin);
		assertEquals(EXP_CODE, admin.getCode());
		assertEquals(EXP_NAME, admin.getName());
		assertEquals(CHILD_COUNT, admin.getChildren().size());
	}
	
}
