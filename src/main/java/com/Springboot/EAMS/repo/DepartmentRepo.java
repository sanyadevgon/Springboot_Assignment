package com.Springboot.EAMS.repo;

import com.Springboot.EAMS.model.entity.Department;
import com.Springboot.EAMS.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

   @Query(value = "select e FROM Employee e  INNER JOIN Department d on e.id=d.manager_id where d.id=:id")
   public List<Employee> findManagerBydepartment(@Param("id") long id);
}


