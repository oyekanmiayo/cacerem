package com.facebookhackathon.carcerem.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
@Entity
@Table(name = "account_user")
@Getter
@Setter
@NoArgsConstructor
public class AccountUser {
    String name;
    String email;
    @Column(unique = true)
    String username;
    String password;
    String mobileNumber;
    String address;
    @OneToMany(mappedBy = "accountUser", cascade = CascadeType.ALL)
    List<Inmate> inmates;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;

}
