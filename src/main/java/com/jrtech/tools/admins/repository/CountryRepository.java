package com.jrtech.tools.admins.repository;

import org.springframework.data.repository.CrudRepository;
import com.jrtech.tools.admins.domain.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

}
