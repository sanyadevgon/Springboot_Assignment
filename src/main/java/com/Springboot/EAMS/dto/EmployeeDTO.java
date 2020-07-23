package com.Springboot.EAMS.dto;

import com.Springboot.EAMS.entity.Department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class EmployeeDTO {

        @JsonProperty("id")
        long id;

        @JsonProperty("firstname")
        private String firstname;

        @JsonProperty("lastname")
        private String lastname;

        @JsonProperty("phone")
        private long phone;

        @JsonProperty("sex")
        private char sex;

        @JsonProperty("salary")
        private long salary;

        @JsonProperty("age")
        private  int age;

        @JsonProperty("department")
        private Department department;

        @JsonProperty("department_id")
        private  int department_id;

        public String message;




    }
