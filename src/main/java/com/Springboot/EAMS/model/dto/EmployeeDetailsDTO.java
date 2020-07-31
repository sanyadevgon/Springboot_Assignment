package com.Springboot.EAMS.model.dto;

import com.Springboot.EAMS.model.entity.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetailsDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("address")
    private  String address;

    @JsonProperty("gender")
    private char gender;

    @JsonProperty("salary")
    private long salary;

    @JsonProperty("age")
    private  int age;

    @JsonProperty("status")
    private String status;

    private Employee employee;


}
