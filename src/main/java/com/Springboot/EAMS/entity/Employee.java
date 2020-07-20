package com.Springboot.EAMS.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
//import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "firstname")
    private  String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "phone")
    //@Size(max=10)
    private long phone;

    @Column(name = "sex")
    private char sex;

    @Column(name = "salary")
    private long salary;

    @Column(name="age")
    private  int age;

    //@JsonIgnore

    @ManyToOne
    @JoinColumn(name="department_id")
    //@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    //@JsonBackReference
    private Department department;



/*
    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dateOfBirth;
*/

    //Date of joining auto generate


}

