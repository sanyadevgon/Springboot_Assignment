package com.Springboot.EAMS.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Department implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="departmentId")
    private long id;

    @Column(name="department_name")
    private String department_name;

    @Column(name="reportsto_id")
    private long reportsto_id;

    @Column(name="manager_id")
    private long manager_id;

    @Column(name="location")
    private String location;

    /*@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mange_mploy_id", nullable = false)
    private Employee manger;*/

    //department enum ka use

    @OneToMany(mappedBy = "departmentId", cascade=CascadeType.ALL)
    private List<Employee> employees=new ArrayList<>();

    public Department(String department_name, long reportingto_department_id, long manager_id, String location){
        this.department_name=department_name;
        this.reportsto_id=reportingto_department_id;
        this.manager_id=manager_id;
        this.location=location;


    }

}
