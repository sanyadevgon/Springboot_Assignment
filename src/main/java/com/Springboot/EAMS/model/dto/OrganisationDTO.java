package com.Springboot.EAMS.model.dto;

import com.Springboot.EAMS.model.entity.Department;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationDTO {

    @JsonProperty("officeId")
    private Long id;

    @JsonProperty("officeName")
    private String name;


    @JsonProperty("headId")
    private Long headid;

    @JsonProperty("location")
    private String location;


    private List<Department> departments;

}

