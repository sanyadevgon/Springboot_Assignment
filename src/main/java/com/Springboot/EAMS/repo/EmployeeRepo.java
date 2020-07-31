package com.Springboot.EAMS.repo;

//import com.example.jpa.Employee;
import com.Springboot.EAMS.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    //Optional<Employee> findByUserName(String username);
}