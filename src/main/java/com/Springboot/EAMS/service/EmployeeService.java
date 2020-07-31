package com.Springboot.EAMS.service;

import com.Springboot.EAMS.exception.GlobalEamsException;
import com.Springboot.EAMS.exception.NullBodyException;
import com.Springboot.EAMS.model.dto.EmployeeDTO;
import com.Springboot.EAMS.model.entity.Employee;
import com.Springboot.EAMS.model.entity.EmployeeDetails;
import com.Springboot.EAMS.repo.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    ;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        if(StringUtils.isEmpty(employeeDTO.getFirstname()) || StringUtils.isEmpty(employeeDTO.getPhone()))
            throw  new NullBodyException("First name and phone cannot be empty fields");
        EmployeeDetails employeeDetails = employeeDTO.getEmployeeDetails();
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setEmployeeDetails(employeeDetails);
        employeeDetails.setEmployee(employee);
        LOG.info("Saving employee ID to db:" + employeeDTO.getId());
        employeeRepo.save(employee);
        return employee;

    }

    @Cacheable(value = "employers", key = "#id", unless = "#result.id < 4")
    public Employee getEmployee(long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (!employee.isPresent())
            throw new GlobalEamsException("NOT FOUND employee ID: " + id);
        LOG.info("Retrieving employee ID: from db " + id);
        return employee.get();
    }

    @CacheEvict(value = "employers", allEntries = true)
    public void deleteEmployee(long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (!employee.isPresent())
            throw new GlobalEamsException("NOT FOUND employee id-" + id + " Delete not possible");
        employeeRepo.deleteById(id);
    }

    @CachePut(value = "employers", key = "#id")
    public void updateemployee(EmployeeDTO employeeDto, long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (!employee.isPresent())
            throw new GlobalEamsException("NOT FOUND id-" + id);
        if (employeeDto.getFirstname() == null || employeeDto.getPhone() == 0)
            throw new NullPointerException("Firstname and Employee name cannot be empty fields");
        Employee employee1 = new Employee();
        employee1.setId(employeeDto.getId());
        employee1.setFirstname(employeeDto.getFirstname());
        employee1.setLastname(employeeDto.getLastname());
        employee1.setDepartmentId(employeeDto.getDepartmentId());
        employee1.setPhone(employeeDto.getPhone());
        employee1.setEmailId(employee1.getEmailId());
        employee1.setRole(employee1.getRole());
        employee1.setEmployeeDetails(employee1.getEmployeeDetails());
        LOG.info("Deleting employee ID: from db " + id);
        EmployeeDetails employeeDetails = employeeDto.getEmployeeDetails();
        employeeDetails.setEmployee(employee1);
        employeeRepo.save(employee1);
    }

    public void updateemployeethroughKafka(EmployeeDTO employeeDto, long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (!employee.isPresent()) {
            Employee employee1 = new Employee();
            employee1.setFirstname(employeeDto.getFirstname());
            employee1.setLastname(employeeDto.getLastname());
            employee1.setPhone(employeeDto.getPhone());
            employee1.setDepartmentId(employeeDto.getDepartmentId());
            employee1.setEmployeeDetails(employeeDto.getEmployeeDetails());
            EmployeeDetails employeeDetails = employeeDto.getEmployeeDetails();
            employeeDetails.setEmployee(employee1);
            employeeRepo.save(employee1);
        } else {
            employeeRepo.deleteById(id);
            Employee employee1 = new Employee();
            employee1.setFirstname(employeeDto.getFirstname());
            employee1.setLastname(employeeDto.getLastname());
            employee1.setPhone(employeeDto.getPhone());
            employee1.setDepartmentId(employeeDto.getDepartmentId());
            employee1.setEmployeeDetails(employeeDto.getEmployeeDetails());
            EmployeeDetails employeeDetails = employeeDto.getEmployeeDetails();
            employeeDetails.setEmployee(employee1);
            employeeRepo.save(employee1);
        }
    }

}
