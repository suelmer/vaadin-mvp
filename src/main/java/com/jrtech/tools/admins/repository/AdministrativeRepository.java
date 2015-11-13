package com.jrtech.tools.admins.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.jrtech.tools.admins.domain.Administrative;
import org.springframework.stereotype.Repository;

/**
 * Created by Shawn on 15/11/8.
 */
@Repository
public interface AdministrativeRepository extends PagingAndSortingRepository <Administrative, String> {
    List<Administrative> findAdministrativeByName(String name);
}
