package com.jrtech.tools.admins.service;

import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.domain.Country;

public interface AdministrativeService {
	Country getCountry(String code);
	Administrative getAdministrative(String code);
}
