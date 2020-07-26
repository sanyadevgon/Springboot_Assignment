package com.Springboot.EAMS.service;

import com.Springboot.EAMS.dto.DepartmentDTO;
import com.Springboot.EAMS.exception.GlobalEamsException;
import com.Springboot.EAMS.model.entity.Department;
import com.Springboot.EAMS.model.entity.Employee;
import com.Springboot.EAMS.repo.DepartmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
        Optional<Department> department = repo.findById(id);
        if (!department.isPresent())
            throw new GlobalEamsException("NOT FOUND department id-" + id);
        return department.get();
    }

    //delete
    public void delete(long id){
        Optional<Department> department = repo.findById(id);
        if (!department.isPresent())
            throw new GlobalEamsException("NOT FOUND department id-" + id);
        repo.deleteById(id);
    }

    //update
    public Department update(DepartmentDTO dto, long id){
        Optional<Department> department = repo.findById(id);
        if (!department.isPresent())
            throw new GlobalEamsException("NOT FOUND department id-" + id);
        return repo.save(modelMapper.map(dto,Department.class));

    }

    //getmanagerdetails
    public List<Employee> managerDetails (long id){
        Optional<Department> department = repo.findById(id);
        if (!department.isPresent())
            throw new GlobalEamsException("NOT FOUND department id-" + id);
        return repo.findManagerBydepartment(id);
    }



}
