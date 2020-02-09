package com.facebookhackathon.carcerem.models;

import com.facebookhackathon.carcerem.util.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
@Getter
@Setter
public class ResponseModel {
    AccountUser accountUser;
    Lawyer lawyer;
    String description;
    Status status;
    List<Inmate> inmateList;
}
