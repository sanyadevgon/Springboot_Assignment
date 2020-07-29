package com.Springboot.EAMS.controller;

import com.Springboot.EAMS.dto.DepartmentDTO;
import com.Springboot.EAMS.exception.NullBodyException;
import com.Springboot.EAMS.model.entity.Department;
import com.Springboot.EAMS.service.Departmentservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department postEmployeeDetails(
            @RequestBody DepartmentDTO dto) {
        if(dto==null)
            throw new NullBodyException("No body provided for post method");
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

    @GetMapping("/managerdetails/{id}")
    public Object managerdetails(@PathVariable long id){
        return service.managerDetails(id);
    }

}
