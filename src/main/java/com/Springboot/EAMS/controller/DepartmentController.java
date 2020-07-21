package com.Springboot.EAMS.controller;

import com.Springboot.EAMS.dto.DepartmentDTO;
import com.Springboot.EAMS.entity.Department;
import com.Springboot.EAMS.service.Departmentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value="/department")
public class DepartmentController {
    @Autowired
    Departmentservice service;

    @Autowired
    DepartmentDTO dto;

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department postEmployeeDetails(
            @RequestBody DepartmentDTO dto) {
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
    public Object updateDepartment(@RequestBody DepartmentDTO dto, @PathVariable long id) {
        return service.update(dto, id);

    }

}
