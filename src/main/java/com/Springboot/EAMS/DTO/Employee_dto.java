package com.Springboot.EAMS.DTO;

import com.Springboot.EAMS.Entity.Department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Employee_dto {

        @JsonProperty("id")
        Long id;

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




    }
