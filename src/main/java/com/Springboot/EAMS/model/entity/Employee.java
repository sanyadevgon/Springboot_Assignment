package com.Springboot.EAMS.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
//import javax.validation.constraints.Size;

@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private long id;

    @NotNull
    @Column(name = "firstName")
    private  String firstname;

    @Column(name = "lastName")
    private String lastname;

    @NotNull
    @Column(name = "phone")
    //@Size(max=10)
    private long phone;

    @Column(name="emailId")
    private String emailId;

    @Column(name="role")
    private String role;

    @Column(name ="departmentId")
    private long departmentId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee", orphanRemoval = true)
    @JsonManagedReference
    private EmployeeDetails employeeDetails;



    //@JsonIgnore

    //emailid
    // bool isterminated
    //reporting manager
    //roles enum



    /*@ManyToOne
    @JoinColumn(name="department_id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    //@JsonBackReference
    @JsonIgnoreProperties
    private Department department;*/



/*
    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dateOfBirth;
*/

    //Date of joining auto generate

    @Override
    public  String toString(){
        final StringBuffer sb=new StringBuffer("Employee{");
        sb.append("first name = ").append(firstname).append(": ");
        sb.append("last name = ").append(lastname).append(": ");
        //sb.append("age = ").append(age).append(": ");
        //sb.append("phone = ").append(phone).append(": ");
        sb.append("");
        sb.append("}");
        return  sb.toString();
    }

}

