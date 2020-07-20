package com.Springboot.EAMS.Controller;


import com.Springboot.EAMS.Entity.Employee;
import com.Springboot.EAMS.Service.EmployeeService;
import com.Springboot.EAMS.DTO.Employee_dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
        @RequestMapping(value = "/employee")
        public class Employee_controller {

            @Autowired
            EmployeeService service;

            @Autowired
            Employee_dto employee_dto;

            @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
            public Employee postEmployeeDetails(
                    @RequestBody Employee_dto employee_dto) {
                return service.save(employee_dto);
            }

            @GetMapping(value = "/{id}")
            public Employee retrieveEmployee(@PathVariable Long id) {
                return service.get(id);

            }
            @DeleteMapping("/{id}")
            public void deleteEmployee(@PathVariable long id) {
                service.delete(id);
            }
            @PutMapping("/{id}")
            public Employee updateEmployee(@RequestBody Employee_dto employee_dto, @PathVariable long id) {
               return service.update(employee_dto, id);

            }

            //@PostMapping(value="/update",)
        }



