package com.Springboot.EAMS.service;

import com.Springboot.EAMS.exception.GlobalEamsException;
import com.Springboot.EAMS.model.dto.OrganisationDTO;
import com.Springboot.EAMS.model.entity.Organisation;
import com.Springboot.EAMS.repo.OrganisationRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrganisationService {

    @Autowired
    OrganisationRepo repo;

    private ModelMapper modelMapper = new ModelMapper();

    public void saveOrganisation(OrganisationDTO organisationDTO) {

        repo.save(modelMapper.map(organisationDTO, Organisation.class));

    }

    public Organisation getOrganisation(long id) {
        Optional<Organisation> organisation = repo.findById(id);
        if (!organisation.isPresent())
            throw new GlobalEamsException("NOT FOUND organisation id-" + id);

        return organisation.get();
    }


    public void deleteOrganisation(long id) {
        Optional<Organisation> organisation = repo.findById(id);
        if (!organisation.isPresent())
            throw new GlobalEamsException("NOT FOUND organisation id-" + id);
        repo.deleteById(id);
    }


    public Organisation updateOrganisation(OrganisationDTO organisationDTO, long id) {
        Optional<Organisation> organisation = repo.findById(id);
        if (!organisation.isPresent())
            throw new GlobalEamsException("NOT FOUND id organisation-" + id);
        repo.deleteById(id);
        return repo.save(modelMapper.map(organisationDTO, Organisation.class));

    }

}
