package com.Springboot.EAMS.service;

import com.Springboot.EAMS.dto.Department_dto;
import com.Springboot.EAMS.dto.Employee_dto;
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
    Employee_dto employee;
    @Autowired
    Department_dto department;
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