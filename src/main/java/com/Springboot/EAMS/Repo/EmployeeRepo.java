package com.Springboot.EAMS.Repo;

//import com.example.jpa.Employee;
import com.Springboot.EAMS.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}