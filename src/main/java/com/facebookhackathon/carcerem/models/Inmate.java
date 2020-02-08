package com.facebookhackathon.carcerem.models;

import com.facebookhackathon.carcerem.util.Crime;
import com.facebookhackathon.carcerem.util.InmateStatus;
import com.facebookhackathon.carcerem.util.Judgement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
@Entity
@Table(name = "inmate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"user"})
public class Inmate {
    String name;
    String crimeDescription;
    Crime allegedCrime;
    InmateStatus inmateStatus;
    Judgement judgement;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountuser_id")
    AccountUser user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lawyer_id")
    Lawyer lawyer;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;

    public Inmate getInmateModelFromInmateCreationModel(InmateCreationModel model) {
        Inmate inmate = new Inmate();
        return inmate;
    }
}
