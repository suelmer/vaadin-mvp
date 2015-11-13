package com.jrtech.tools.admins.repository;

import com.jrtech.tools.admins.ApplicationConfiguration;
import com.jrtech.tools.admins.domain.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ApplicationConfiguration.class)
public class CountryRepositoryTest {
	
	static final String EXP_CODE = "156";
	static final String EXP_NAME = "CHINA";

	@Autowired
	CountryRepository repo;
	
	@Test
	public void testFindOne() {
		Country country = repo.findOne(EXP_CODE);
		
		assertNotNull(country);
		assertEquals(EXP_CODE, country.getCode());
		assertEquals(EXP_NAME, country.getName());
	}
}
