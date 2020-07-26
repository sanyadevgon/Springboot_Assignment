package com.Springboot.EAMS.model.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

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
    @Column(name = "officeId")
    private long id;

    @Column(name = "officeName")
    private String name;

    @Column(name = "headId")
    private long headId;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "reportsto_id",fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    List<Department>departments;

}