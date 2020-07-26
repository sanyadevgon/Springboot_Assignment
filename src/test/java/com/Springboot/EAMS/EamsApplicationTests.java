package com.Springboot.EAMS;

import com.Springboot.EAMS.repo.DepartmentRepo;
import com.Springboot.EAMS.repo.EmployeeRepo;
import com.Springboot.EAMS.repo.testint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class EamsApplicationTests {

	@Autowired
	EmployeeRepo repo;

	@Autowired
	DepartmentRepo depr;

	@Autowired
	testint testrepo;

	@Test
	void contextLoads() {
		//Optional<Employee> emp=repo.findById(1L);
		//Optional<Department> dep= depr.findById(1L);
		//repo.updatesalary(100L);
	//	testrepo.findname(1);
	}

}
