package com.Springboot.EAMS.service;


import com.Springboot.EAMS.exception.GlobalEamsException;
import com.Springboot.EAMS.exception.NullBodyException;
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
    OrganisationRepo repo ;


    private ModelMapper modelMapper= new ModelMapper();


    /*private PostDto convertToDto(Post post) {
       PostDto postDto = modelMapper.map(post, PostDto.class);
       postDto.setSubmissionDate(post.getSubmissionDate(),
               userService.getCurrentUser().getPreference().getTimezone());
       return postDto;
   }*/

    //create
    public void save(OrganisationDTO organisationDTO){
        if(organisationDTO.getName()==null || organisationDTO.getLocation()==null)
            throw new NullBodyException("Name and location cannot be empty fields");
         repo.save(modelMapper.map(organisationDTO,Organisation.class));

    }

    //retrieve
    public Organisation get(long id){
        Optional<Organisation> organisation= repo.findById(id);
        if (!organisation.isPresent())
            throw new GlobalEamsException("NOT FOUND organisation id-" + id);

        return organisation.get();
    }

    //delete
    public void delete(long id){
        Optional<Organisation> organisation = repo.findById(id);
        if (!organisation.isPresent())
            throw new GlobalEamsException("NOT FOUND organisation id-" + id);
        repo.deleteById(id);
    }

    //update
    public Organisation update(OrganisationDTO organisationDTO, long id){
        Optional<Organisation> organisation = repo.findById(id);
        if (!organisation.isPresent())
            throw new GlobalEamsException("NOT FOUND id organisation-" + id);
        repo.deleteById(id);
        return repo.save(modelMapper.map(organisationDTO,Organisation.class));

    }



}
