package com.Springboot.EAMS.service;

import com.Springboot.EAMS.exception.GlobalEamsException;
import com.Springboot.EAMS.model.dto.EmployeeDTO;
import com.Springboot.EAMS.model.entity.Employee;
import com.Springboot.EAMS.model.entity.EmployeeDetails;
import com.Springboot.EAMS.repo.EmployeeRepo;
import com.Springboot.EAMS.repo.testint;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;



@Service
public class EmployeeService {


    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepo repo ;


    @Autowired
    EmployeeDTO employee_dto;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    };

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EmployeeDetails empdetails;


    /*private PostDto convertToDto(Post post) {
       PostDto postDto = modelMapper.map(post, PostDto.class);
       postDto.setSubmissionDate(post.getSubmissionDate(),
               userService.getCurrentUser().getPreference().getTimezone());
       return postDto;
   }*/

    //create
    public Employee save(EmployeeDTO employee_dto){
        empdetails=employee_dto.getEmployeeDetails();
        Employee emp = modelMapper.map(employee_dto,Employee.class);
        emp.setEmployeeDetails(empdetails);
        empdetails.setEmployee(emp);
        //logger.info("The Request Object is : %s",employee_dto.toString());
        repo.save(emp);
         return emp;
    }

    //retrieve
    public Employee get(long id){
        Optional<Employee> employee = repo.findById(id);
        if (!employee.isPresent())
            throw new GlobalEamsException("NOT FOUND employee id-" + id);
        // Initiating Logging for Get Request
        return employee.get();
    }

    //delete
    public void delete(long id){
        Optional<Employee> employee = repo.findById(id);
        if (!employee.isPresent())
            throw new GlobalEamsException("NOT FOUND employee id-" + id +" Delete not possible");
        repo.deleteById(id);
    }

    //update
    public Employee update(EmployeeDTO employee_dto, long id){
        Optional<Employee> employee = repo.findById(id);
        if (!employee.isPresent())
            throw new GlobalEamsException("NOT FOUND id-" + id);
        return repo.save(modelMapper.map(employee_dto,Employee.class));
    }

    /*ublic void updateallsalary(long increment){
        if (increment<=0)
                return ;
        repo.updatesalary(increment);

    }*/

    @Autowired
    testint init;
    @PostConstruct
    public void init(){
        init.findname(1);
    }



}
