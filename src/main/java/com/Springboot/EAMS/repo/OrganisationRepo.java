package com.Springboot.EAMS.repo;

import com.Springboot.EAMS.model.entity.Organisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepo extends CrudRepository<Organisation, Long> {

}
