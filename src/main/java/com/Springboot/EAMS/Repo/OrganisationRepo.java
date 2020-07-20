package com.Springboot.EAMS.Repo;

import com.Springboot.EAMS.Entity.Department;
import com.Springboot.EAMS.Entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepo extends JpaRepository<Organisation, Long> {

}
