package com.Springboot.EAMS.service;

import com.Springboot.EAMS.dto.DepartmentDTO;
import com.Springboot.EAMS.model.entity.Employee;
import com.Springboot.EAMS.repo.DepartmentRepo;
import com.Springboot.EAMS.repo.EmployeeDetailsRepo;
import com.Springboot.EAMS.repo.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@DataJpaTest
class employeeServiceTest {

    @Autowired
    Employee employee;
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

    @Autowired
    EmployeeDetailsRepo employeeDetailsRepo;


    @Test
    void contextLoads() throws InterruptedException {
        //Optional<Employee> emp=repo.findById(2L);
        //Optional<Department> dep= depr.findById(1L);

       // List i =depr.findManagerBydepartment(2L);
        /*employee.setFirstname("sam");
        employee.setDepartmentId(2);
        employee.setPhone(9899899);
        employee.setEmailId("sameer@gmail.com");
        EmployeeDetails empdetails = new EmployeeDetails();
        empdetails.setAddress("17b");
        empdetails.setStatus(true);
        empdetails.setAge(24);
        employee.setEmployeeDetails(empdetails);
        empdetails.setEmployee(employee);
        *///employeeDetailsRepo.updatebyemployeedepatment(20,2);
       // repo.save(employee);
        String start = String.valueOf(System.currentTimeMillis());
        Thread.sleep(10000);
        String end = String.valueOf(System.currentTimeMillis());
        System.out.println(end+" "+start);



    }
}