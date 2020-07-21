package com.Springboot.EAMS;

import com.Springboot.EAMS.entity.Department;
import com.Springboot.EAMS.entity.Employee;
import com.Springboot.EAMS.repo.DepartmentRepo;
import com.Springboot.EAMS.repo.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest

public class EamsApplicationTests {

	@Autowired
	EmployeeRepo repo;

	@Autowired
	DepartmentRepo depr;

	@Test
	void contextLoads() {
		//Optional<Employee> emp=repo.findById(1L);
		//Optional<Department> dep= depr.findById(1L);
		repo.updatesalary(100L);
	}

}
