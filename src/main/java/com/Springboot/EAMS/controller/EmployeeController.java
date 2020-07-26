package com.Springboot.EAMS.controller;


import com.Springboot.EAMS.model.entity.Employee;
import com.Springboot.EAMS.model.dto.EmployeeDTO;
import com.Springboot.EAMS.repo.EmployeeDetailsRepo;
import com.Springboot.EAMS.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @Autowired
    EmployeeDTO employee_dto;

    @Autowired
    EmployeeDetailsRepo employeeDetailsRepo;

    @Autowired
    private KafkaTemplate<String, EmployeeDTO> kafkaTemplate;

    private static  final String TOPIC="test_";

    private final Logger LOG = LoggerFactory.getLogger(getClass());


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee postEmployeeDetails(
            @RequestBody EmployeeDTO employee_dto) {
        try {
            //employee_dto.builder().message(employee_dto.getMessage()).build();
            return service.save(employee_dto);
        }
        catch (NullPointerException E){
            LOG.info("Not a valid parameter or not connected to database");
            return null;
        }
    }

    @Cacheable(value = "employers", key = "#id", unless = "#result.id < 4")
    @GetMapping(value = "/{id}")
    public Employee retrieveEmployee(@PathVariable Long id) {
        LOG.info("Getting user with ID{}.",id);
        Employee employee=service.get(id);
        employee_dto.setFirstname(employee.getFirstname());
        employee_dto.setLastname(employee.getLastname());
        kafkaTemplate.send(TOPIC,employee_dto);
        return service.get(id);
    }

    @CacheEvict(value = "employers", allEntries=true)
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {
        service.delete(id);
    }


   @CachePut(value = "employers", key = "#id")
    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody EmployeeDTO employee_dto, @PathVariable long id) {
        return service.update(employee_dto, id);

    }

   /*@GetMapping("/department/{id}/increment/{value}")
    public void updateallEmployeesalary( @PathVariable long value,@PathVariable long id) {
       employeeDetailsRepo.updatebyemployeedepatment(value,id);
    }*/

    @KafkaListener(topics= "test_", groupId = "group_id", containerFactory = "employeeKafkaListenerFactory")
    public  void consumeJson(EmployeeDTO employee) {
        System.out.println("Consumed meassage: " + employee.getFirstname());
    }



    //@PostMapping(value="/update",)
}



