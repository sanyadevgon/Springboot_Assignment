package com.Springboot.EAMS.service;

import com.Springboot.EAMS.dto.DepartmentDTO;
import com.Springboot.EAMS.entity.Department;
import com.Springboot.EAMS.repo.DepartmentRepo;
import com.Springboot.EAMS.exception.EamsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Department save(DepartmentDTO dto){

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
    public Department update(DepartmentDTO dto, long id){
        Optional<Department> employee = repo.findById(id);

        if (!employee.isPresent())
            throw new EamsException("NOT FOUND id-" + id);


        return repo.save(modelMapper.map(dto,Department.class));

    }



}
