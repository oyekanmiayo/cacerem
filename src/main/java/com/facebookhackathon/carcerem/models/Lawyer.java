package com.facebookhackathon.carcerem.models;

import com.facebookhackathon.carcerem.util.Crime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = {"inmates"})
public class Lawyer {
    String name;
    String email;
    String mobileNumber;
    Crime crimeInterest;
    @OneToMany(mappedBy = "lawyer", cascade = CascadeType.ALL)
    List<Inmate> inmates;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;
}
