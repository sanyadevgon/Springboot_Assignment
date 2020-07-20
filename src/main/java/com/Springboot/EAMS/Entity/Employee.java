package com.Springboot.EAMS.Entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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
    //@JoinColumn(name="department_id")
    //@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    //@JsonBackReference
    private Department department;

    @Column(name="department_id")
    private  int department_id;

/*
    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dateOfBirth;
*/

    //Date of joining auto generate


}

