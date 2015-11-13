package com.jrtech.tools.admins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.domain.Country;
import com.jrtech.tools.admins.repository.AdministrativeRepository;
import com.jrtech.tools.admins.repository.CountryRepository;

@Service
public class AdministrativeServiceImpl implements AdministrativeService {

	private CountryRepository countryRepo;
	private AdministrativeRepository adminRepo;

    @Autowired
    public AdministrativeServiceImpl(CountryRepository countryRepo, AdministrativeRepository adminRepo) {
        this.countryRepo = countryRepo;
        this.adminRepo = adminRepo;
    }
	
	@Override
	@Transactional
	public Country getCountry(String code) {
		Country china = countryRepo.findOne(code);
        for (Administrative admin : china.getChildren()) {
        	admin.getChildren().isEmpty();
        }
		return china;
	}

	@Override
	@Transactional
	public Administrative getAdministrative(String code) {
		Administrative admin = adminRepo.findOne(code);
		for (Administrative child : admin.getChildren()) {
        	child.getChildren().isEmpty();
        }
		return admin;
	}

}
