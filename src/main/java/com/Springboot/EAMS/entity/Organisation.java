package com.Springboot.EAMS.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Organisation {
    @Id
    @GeneratedValue
    @Column(name = "headoffice_id")
    private long id;

    @Column(name = "headoffice_name")
    private String name;

    @Column(name = "manager_id")
    private long manager_id;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "reportsto_id",fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    List<Department>departments;

}