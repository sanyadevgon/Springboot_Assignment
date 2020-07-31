package com.Springboot.EAMS.dto;

import com.Springboot.EAMS.model.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class DepartmentDTO {

    @JsonProperty("id")
    private Long department_id;

    @JsonProperty("name")
    private String department_name;

    @JsonProperty("to_id")
    private Long reportsto_department_id;

    @JsonProperty("manager_id")
    private Long manager_id;

    @JsonProperty("location")
    private String location;

    private List<Employee> employees;

}



