package com.Springboot.EAMS.controller;

import com.Springboot.EAMS.constants.Constants;
import com.Springboot.EAMS.exception.NullBodyException;
import com.Springboot.EAMS.model.dto.OrganisationDTO;
import com.Springboot.EAMS.model.entity.Organisation;
import com.Springboot.EAMS.model.response.BaseMessageResponse;
import com.Springboot.EAMS.model.response.ServiceResponse;
import com.Springboot.EAMS.service.OrganisationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping(value = "/organisation")
public class OrganisationController {
    private static final String REDIS_INDEX_KEY = "organisation";

    @Autowired
    OrganisationService service;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postOrganisationDetails(
            @RequestBody OrganisationDTO organisationDTO) {
        if (organisationDTO.getName() == null || organisationDTO.getLocation() == null)
            throw new NullBodyException("Name and location cannot be empty fields");
        Organisation organisation = new Organisation();
        organisation.setName(organisationDTO.getName());
        organisation.setId(organisationDTO.getId());
        organisation.setHeadId(organisationDTO.getHeadid());
        organisation.setLocation(organisationDTO.getLocation());

        log.info(
                "OrganisationController : saveOrganisationDetails : Received Request to save Organisation" +
                organisationDTO);
                        service.saveOrganisation(organisationDTO);
        return Constants.UPDATE_SUCCESSFUL;

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> retrieveOrganisation(@PathVariable Long id) {
        log.info("Getting details of Organisation with id  :  ", id);
        return new ServiceResponse<>(
                service.getOrganisation(id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletedOrganisation(@PathVariable long id) {
        log.info("Details details of Organisation with id :  ", id);
        service.deleteOrganisation(id);
        return new ServiceResponse<BaseMessageResponse>(
                new BaseMessageResponse("Deleted Successfully", HttpStatus.OK, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrganisation(@RequestBody OrganisationDTO organisationDTO, @PathVariable long id) {
        //return service.updateOrganisation(dto, id);
        log.info("Updating details of Organisation with id :  ", id);
        return new ServiceResponse<>(
                service.updateOrganisation(organisationDTO, id), HttpStatus.OK);

    }

}

