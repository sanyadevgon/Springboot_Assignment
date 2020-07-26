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
    OrganisationRepo repo ;


    @Autowired
    OrganisationDTO dto;

    private ModelMapper modelMapper= new ModelMapper();


    /*private PostDto convertToDto(Post post) {
       PostDto postDto = modelMapper.map(post, PostDto.class);
       postDto.setSubmissionDate(post.getSubmissionDate(),
               userService.getCurrentUser().getPreference().getTimezone());
       return postDto;
   }*/

    //create
    public Organisation save(OrganisationDTO dto){
        return  repo.save(modelMapper.map(dto,Organisation.class));
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
    public Organisation update(OrganisationDTO dto, long id){
        Optional<Organisation> organisation = repo.findById(id);
        if (!organisation.isPresent())
            throw new GlobalEamsException("NOT FOUND id organisation-" + id);
        return repo.save(modelMapper.map(dto,Organisation.class));

    }



}
