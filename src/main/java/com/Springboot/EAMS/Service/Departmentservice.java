package com.Springboot.EAMS.Service;

import com.Springboot.EAMS.DTO.Department_dto;
import com.Springboot.EAMS.Entity.Department;
import com.Springboot.EAMS.Repo.DepartmentRepo;
import com.Springboot.EAMS.exception.EamsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Departmentservice {

    @Autowired
    DepartmentRepo repo ;

    private ModelMapper modelMapper= new ModelMapper();


    /*private PostDto convertToDto(Post post) {
       PostDto postDto = modelMapper.map(post, PostDto.class);
       postDto.setSubmissionDate(post.getSubmissionDate(),
               userService.getCurrentUser().getPreference().getTimezone());
       return postDto;
   }*/

    //create
    public Department save(Department_dto dto){

        return  repo.save(modelMapper.map(dto,Department.class));
    }
    //retrieve
    public Department get(long id){
        Optional<Department> dep = repo.findById(id);
        if (!dep.isPresent())
            throw new EamsException("NOT FOUND id-" + id);

        return dep.get();
    }
    //delete
    public void delete(long id){
        repo.deleteById(id);
    }
    //update
    public Department update(Department_dto dto, long id){
        Optional<Department> employee = repo.findById(id);

        if (!employee.isPresent())
            throw new EamsException("NOT FOUND id-" + id);


        return repo.save(modelMapper.map(dto,Department.class));

    }



}
