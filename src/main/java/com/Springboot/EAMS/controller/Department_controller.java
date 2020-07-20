package com.Springboot.EAMS.controller;

import com.Springboot.EAMS.dto.Department_dto;
import com.Springboot.EAMS.entity.Department;
import com.Springboot.EAMS.service.Departmentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value="/department")
public class Department_controller {
    @Autowired
    Departmentservice service;

    @Autowired
    Department_dto dto;

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department postEmployeeDetails(
            @RequestBody Department_dto dto) {
        return service.save(dto);
    }

    @GetMapping(value = "/{id}")
    public Department retrieveDepartment(@PathVariable Long id) {
        return service.get(id);

    }
    @DeleteMapping("/{id}")
    public void deletedepartment(@PathVariable long id) {
        service.delete(id);
    }
    @PutMapping("/{id}")
    public Object updateDepartment(@RequestBody Department_dto dto, @PathVariable long id) {
        return service.update(dto, id);

    }

}
