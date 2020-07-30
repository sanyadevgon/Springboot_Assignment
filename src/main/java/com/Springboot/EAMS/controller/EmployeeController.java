package com.Springboot.EAMS.controller;


import com.Springboot.EAMS.exception.NullBodyException;
import com.Springboot.EAMS.model.dto.EmployeeDTO;
import com.Springboot.EAMS.model.entity.Employee;
import com.Springboot.EAMS.model.response.BaseMessageResponse;
import com.Springboot.EAMS.model.response.ServiceResponse;
import com.Springboot.EAMS.service.EmployeeDetailsService;
import com.Springboot.EAMS.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;



@RestController
@Log4j2
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @Autowired
    EmployeeDTO employeeDTO;

    @Autowired
    private KafkaTemplate<String, EmployeeDTO> kafkaTemplate;

    private static  final String TOPIC="produce";


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponse<?> postEmployeeDetails(
            @RequestBody EmployeeDTO employeeDto) {
            if(employeeDto.getFirstname()==null)
                throw new NullBodyException("No body provided for post method");

            log.info("Posting employee with ID "+employeeDto.getId());
        employeeService.saveemployee(employeeDto);
        return  new ServiceResponse<BaseMessageResponse>(
                new BaseMessageResponse("Saved Successfully", HttpStatus.OK, true));
    }

    @Cacheable(value = "employers", key = "#id", unless = "#result.id < 4")
    @GetMapping(value = "/{id}")
    public ServiceResponse<?> retrieveEmployee(@PathVariable Long id) {
        log.info("Getting user with ID ",id);
        Employee employee=employeeService.getemployee(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);
        employeeDTO.setFirstname(employee.getFirstname());
        employeeDTO.setLastname(employee.getLastname());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setEmployeeDetails(employee.getEmployeeDetails());
        kafkaTemplate.send(TOPIC,employeeDTO);
        log.info("Getting the details of employee with ID"+id);
        return new ServiceResponse<>(
                employeeService.getemployee(id), HttpStatus.OK);
        //return employeeService.get(id);
    }

    @CacheEvict(value = "employers", allEntries=true)
    @DeleteMapping("/{id}")
    public ServiceResponse<?> deleteEmployee(@PathVariable long id) {
        log.info("Delete request for employee with ID"+ id);
        employeeService.deleteemployee(id);
        return  new ServiceResponse<BaseMessageResponse>(
                new BaseMessageResponse("Deleted Successfully", HttpStatus.OK, true));
    }


    @CachePut(value = "employers", key = "#id")
    @PutMapping("/{id}")
    public ServiceResponse<?> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable long id) {
       log.info("Put request for employee with ID"+ id);
        employeeService.updateemployee(employeeDTO, id);
        return  new ServiceResponse<BaseMessageResponse>(
                new BaseMessageResponse("Saved Successfully", HttpStatus.OK, true));
    }

   @GetMapping("/department/{id}/increment/{value}")
    public ServiceResponse<?> updateallEmployeesalarybydepartment( @PathVariable long value,@PathVariable long id) {
       employeeDetailsService.updatesalary(value,id);
       return  new ServiceResponse<BaseMessageResponse>(
               new BaseMessageResponse("Salary Saved Successfully", HttpStatus.OK, true));
    }

    @KafkaListener(topics= "produce", groupId = "group_id", containerFactory = "employeeKafkaListenerFactory")
    public  void consumeJson(EmployeeDTO employeeDto) {
        //System.out.println("Consumed meassage: " + employee.getFirstname());
        if(employeeDto.getFirstname()==null)
            throw new NullBodyException("No employee details provided for post method");

        employeeService.updateemployeethroughKafka(employeeDto, employeeDto.getId());
        log.info("Consumed through producer"+ employeeDto.getFirstname()+employeeDto.getLastname());
    }





    //@PostMapping(value="/update",)
}



