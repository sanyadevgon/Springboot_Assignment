package com.Springboot.EAMS.controller;

import com.Springboot.EAMS.dto.Department_dto;
import com.Springboot.EAMS.dto.Organisation_dto;
import com.Springboot.EAMS.entity.Organisation;
import com.Springboot.EAMS.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value="/organisation")
public class Organisation_controller {
    @Autowired
    OrganisationService service;

    @Autowired
    Department_dto dto;

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public Organisation postOrganisationDetails(
            @RequestBody Organisation_dto dto) {
        return service.save(dto);
    }

    @GetMapping(value = "/{id}")
    public Organisation retrieveOrganisation(@PathVariable Long id) {
        return service.get(id);

    }
    @DeleteMapping("/{id}")
    public void deletedorganisation(@PathVariable long id) {
        service.delete(id);
    }
    @PutMapping("/{id}")
    public Object updateOrganisation(@RequestBody Organisation_dto dto, @PathVariable long id) {
        return service.update(dto, id);

    }

}

