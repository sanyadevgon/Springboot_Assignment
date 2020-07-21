package com.Springboot.EAMS.dto;
import com.Springboot.EAMS.entity.Department;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class OrganisationDTO {

    @JsonProperty("office_id")
    Long id;

    @JsonProperty("office_name")
    String name;

    @JsonProperty("manager_id")
    Long manager_id;

    @JsonProperty("location")
    String location;



    private List<Department> departments;

}
