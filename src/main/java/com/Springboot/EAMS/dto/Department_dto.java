package com.Springboot.EAMS.dto;

import com.Springboot.EAMS.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Department_dto {
    @JsonProperty("id")
    Long deaprtment_id;

    @JsonProperty("name")
    String department_name;

    @JsonProperty("to_id")
    Long reporto_department_id;

    @JsonProperty("manager_id")
    Long manager_id;

    @JsonProperty("location")
    String location;


    private List<Employee> employees;

}



