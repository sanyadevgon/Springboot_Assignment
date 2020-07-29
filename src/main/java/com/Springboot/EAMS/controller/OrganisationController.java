package com.Springboot.EAMS.controller;

import com.Springboot.EAMS.exception.NullBodyException;
import com.Springboot.EAMS.model.entity.Organisation;
import com.Springboot.EAMS.model.dto.OrganisationDTO;
import com.Springboot.EAMS.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value="/organisation")
public class OrganisationController {
    @Autowired
    OrganisationService service;

    @Autowired
    OrganisationDTO dto;

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public Organisation postOrganisationDetails(
            @RequestBody OrganisationDTO dto) {
        if(dto==null)
            throw new NullBodyException("No body provided for post method");
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
    public Object updateOrganisation(@RequestBody OrganisationDTO dto, @PathVariable long id) {
        return service.update(dto, id);

    }

}

