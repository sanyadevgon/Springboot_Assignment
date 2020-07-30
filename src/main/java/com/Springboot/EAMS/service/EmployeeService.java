package com.Springboot.EAMS.service;

import com.Springboot.EAMS.exception.GlobalEamsException;
import com.Springboot.EAMS.model.dto.EmployeeDTO;
import com.Springboot.EAMS.model.entity.Employee;
import com.Springboot.EAMS.model.entity.EmployeeDetails;
import com.Springboot.EAMS.repo.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class EmployeeService {


    private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepo employeeRepo ;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    };

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EmployeeDetails employeeDetails;


    public void saveemployee(EmployeeDTO employeeDTO){
        employeeDetails=employeeDTO.getEmployeeDetails();
        Employee employee = modelMapper.map(employeeDTO,Employee.class);
        employee.setEmployeeDetails(employeeDetails);
        employeeDetails.setEmployee(employee);
        LOG.info("Saving employee ID to db:"+employee.getId());
        employeeRepo.save(employee);
    }


    public Employee getemployee(long id){
        Optional<Employee> employee = employeeRepo.findById(id);
        if (!employee.isPresent())
            throw new GlobalEamsException("NOT FOUND employee ID: " + id);
        LOG.info("Retrieving employee ID: from db "+id);
        return employee.get();
    }


    public void deleteemployee(long id){
        Optional<Employee> employee = employeeRepo.findById(id);
        if (!employee.isPresent())
            throw new GlobalEamsException("NOT FOUND employee id-" + id +" Delete not possible");
        employeeRepo.deleteById(id);
    }


    public void updateemployee(EmployeeDTO employeeDto, long id){
        Optional<Employee> employee = employeeRepo.findById(id);
        if (!employee.isPresent())
            throw new GlobalEamsException("NOT FOUND id-" + id);
        if(employeeDto.getFirstname()==null || employeeDto.getPhone()==0)
            throw new NullPointerException("Firstname and Employee name cannot be empty fields");
        Employee employee1= new Employee();
        employee1.setId(employeeDto.getId());
        employee1.setFirstname(employeeDto.getFirstname());
        employee1.setLastname(employeeDto.getLastname());
        employee1.setDepartmentId(employeeDto.getDepartmentId());
        employee1.setPhone(employeeDto.getPhone());
        employee1.setEmailId(employee1.getEmailId());
        employee1.setRole(employee1.getRole());
        employee1.setEmployeeDetails(employee1.getEmployeeDetails());
        LOG.info("Deleting employee ID: from db "+id);
        employeeDetails=employeeDto.getEmployeeDetails();
        employeeDetails.setEmployee(employee1);
        employeeRepo.save(employee1);
    }

    public void updateemployeethroughKafka(EmployeeDTO employeeDto,long id){
        Optional<Employee> employee = employeeRepo.findById(id);
        if (!employee.isPresent()) {
            Employee employee1=new Employee();
            employee1.setFirstname(employeeDto.getFirstname());
            employee1.setLastname(employeeDto.getLastname());
            employee1.setPhone(employeeDto.getPhone());
            employee1.setDepartmentId(employeeDto.getDepartmentId());
            employee1.setEmployeeDetails(employeeDto.getEmployeeDetails());
            employeeDetails=employeeDto.getEmployeeDetails();
            employeeDetails.setEmployee(employee1);
            employeeRepo.save(employee1);
        }
        else{
            employeeRepo.deleteById(id);
            Employee employee1=new Employee();
            employee1.setFirstname(employeeDto.getFirstname());
            employee1.setLastname(employeeDto.getLastname());
            employee1.setPhone(employeeDto.getPhone());
            employee1.setDepartmentId(employeeDto.getDepartmentId());
            employee1.setEmployeeDetails(employeeDto.getEmployeeDetails());
            employeeDetails=employeeDto.getEmployeeDetails();
            employeeDetails.setEmployee(employee1);
            employeeRepo.save(employee1);
        }
    }





}
