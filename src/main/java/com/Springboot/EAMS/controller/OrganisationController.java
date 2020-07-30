package com.Springboot.EAMS.controller;

import com.Springboot.EAMS.constants.Constants;
import com.Springboot.EAMS.exception.NullBodyException;
import com.Springboot.EAMS.model.dto.OrganisationDTO;
import com.Springboot.EAMS.model.entity.Organisation;
import com.Springboot.EAMS.service.OrganisationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value="/organisation")
public class OrganisationController {
    @Autowired
    OrganisationService service;

    @Autowired
    Organisation organisation;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final String REDIS_INDEX_KEY = "organisation";

    @Autowired
    OrganisationDTO dto;

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public String  postOrganisationDetails(
            @RequestBody OrganisationDTO organisationDTO) {
        if(dto==null)
            throw new NullBodyException("No body provided for post method");
        Organisation organisation= new Organisation();
        organisation.setName(organisationDTO.getName());
        organisation.setId(organisationDTO.getId());
        organisation.setLocation(organisationDTO.getLocation());
        redisTemplate.opsForHash().put(REDIS_INDEX_KEY, organisation.getId(),organisation.toString());
        service.save(organisationDTO);
        return Constants.UPDATE_SUCCESSFUL;

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

