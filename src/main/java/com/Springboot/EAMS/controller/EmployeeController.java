package com.Springboot.EAMS.controller;


import com.Springboot.EAMS.entity.Employee;
import com.Springboot.EAMS.service.EmployeeService;
import com.Springboot.EAMS.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @Autowired
    EmployeeDTO employee_dto; //Employeedto

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee postEmployeeDetails(
            @RequestBody EmployeeDTO employee_dto) {
        employee_dto.builder().message(employee_dto.getMessage()).build();
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
    public Employee updateEmployee(@RequestBody EmployeeDTO employee_dto, @PathVariable long id) {
        return service.update(employee_dto, id);

    }

    @PutMapping("/increment/{value}")
    public void updateallEmployeesalary( @PathVariable long value) {
         service.updateallsalary(value);
    }


    //@PostMapping(value="/update",)
}



