package com.Springboot.EAMS.service;

import com.Springboot.EAMS.dto.Department_dto;
import com.Springboot.EAMS.dto.Employee_dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}