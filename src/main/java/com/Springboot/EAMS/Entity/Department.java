package com.Springboot.EAMS.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Department implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="department_id")
    private long id;

    @Column(name="department_name")
    private String department_name;

    @Column(name="reportingto_department_id")
    private long reporto_department_id;

    @Column(name="manager_id")
    private long manager_id;

    @Column(name="location")
    private String location;

    /*@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mange_mploy_id", nullable = false)
    private Employee manger;*/

    @OneToMany(mappedBy = "department_id",fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")

    private List<Employee> employees;

    public Department(String department_name, long reportingto_department_id, long manager_id, String location){
        this.department_name=department_name;
        this.reporto_department_id=reportingto_department_id;
        this.manager_id=manager_id;
        this.location=location;


    }

}
