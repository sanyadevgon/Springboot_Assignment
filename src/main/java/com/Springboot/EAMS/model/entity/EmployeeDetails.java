package com.Springboot.EAMS.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEEDETAILS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name="address")
    private String address;

    @Column(name = "gender")
    private char gender;

    @NotNull
    @Column(name = "salary")
    private long salary;

    @Column(name="age")
    private  int age;

    //whether employ is currently in service 1 if employed, 0 if terminated
    @Column(name="active")
    private String active;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", unique=true)
    @JsonBackReference
    private Employee employee;

}
