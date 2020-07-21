package com.Springboot.EAMS.service;

import com.Springboot.EAMS.dto.DepartmentDTO;
import com.Springboot.EAMS.dto.EmployeeDTO;
import com.Springboot.EAMS.entity.Department;
import com.Springboot.EAMS.entity.Employee;
import com.Springboot.EAMS.repo.DepartmentRepo;
import com.Springboot.EAMS.repo.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class employeeServiceTest {

    @Autowired
    EmployeeDTO employee;
    @Autowired
    DepartmentDTO department;
    @Autowired
    EmployeeService ems;
    /*@Test
    void save() {
        employee.setId(11L);
        employee.setFirstname("sam");
        department.setId(1L);
        employee.setDepartment(department);
        ems.save(employee);
    }

    @Test
    void get() {
        ems.get(11L);

    }*/

    @Autowired
    EmployeeRepo repo;

    @Autowired
    DepartmentRepo depr;

    @Test
    void contextLoads() {
        Optional<Employee> emp=repo.findById(2L);
        Optional<Department> dep= depr.findById(1L);
    }
}