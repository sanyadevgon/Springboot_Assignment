package com.Springboot.EAMS.model.dto;


import com.Springboot.EAMS.model.entity.EmployeeDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class EmployeeDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("phone")
    private long phone;

    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("role")
    private String role;

    /*@JsonProperty("department")
    private Department department;
*/
    @JsonProperty("departmentId")
    private  long departmentId;


    private EmployeeDetails employeeDetails;







}
