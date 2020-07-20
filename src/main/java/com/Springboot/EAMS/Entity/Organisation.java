package com.Springboot.EAMS.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.io.Serializable;
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
}