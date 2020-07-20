package com.Springboot.EAMS.Service;

import com.Springboot.EAMS.DTO.Employee_dto;
import com.Springboot.EAMS.EamsApplication;
import com.Springboot.EAMS.Entity.Employee;
import com.Springboot.EAMS.Repo.EmployeeRepo;
import com.Springboot.EAMS.exception.EamsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class EmployeeService {


    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepo repo ;


    @Autowired
    Employee_dto employee_dto;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    };

    @Autowired
    private ModelMapper modelMapper;


    /*private PostDto convertToDto(Post post) {
       PostDto postDto = modelMapper.map(post, PostDto.class);
       postDto.setSubmissionDate(post.getSubmissionDate(),
               userService.getCurrentUser().getPreference().getTimezone());
       return postDto;
   }*/

    //create
    public Employee save(Employee_dto employee_dto){

        //logger.info("The Request Object is : %s",employee_dto.toString());
       return  repo.save(modelMapper.map(employee_dto,Employee.class));
    }
    //retrieve
    public Employee get(long id){
        Optional<Employee> employee = repo.findById(id);
        if (!employee.isPresent())
            throw new EamsException("NOT FOUND id-" + id);
        // Initiating Logging for Get Request
        return employee.get();
    }
    //delete
    public void delete(long id){
        repo.deleteById(id);
    }
    //update
    public Employee update(Employee_dto employee_dto, long id){
        Optional<Employee> employee = repo.findById(id);

       if (!employee.isPresent())
           throw new EamsException("NOT FOUND id-" + id);


        return repo.save(modelMapper.map(employee_dto,Employee.class));

    }



}
