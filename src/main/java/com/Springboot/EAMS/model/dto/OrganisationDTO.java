package com.Springboot.EAMS.model.dto;

import com.Springboot.EAMS.model.entity.Department;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class OrganisationDTO {

    @JsonProperty("officeId")
    Long id;

    @JsonProperty("officeName")
    String name;

    @JsonProperty("headId")
    Long manager_id;

    @JsonProperty("location")
    String location;



    private List<Department> departments;

}

