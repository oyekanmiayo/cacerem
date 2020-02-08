package com.facebookhackathon.carcerem.controllers;

import com.facebookhackathon.carcerem.models.Lawyer;
import com.facebookhackathon.carcerem.models.ResponseModel;
import com.facebookhackathon.carcerem.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
@Controller
@RequestMapping("/lawyer")
public class LawyerController {

    @Autowired
    LawyerService lawyerService;

    @ResponseBody
    @RequestMapping("/create")
    public ResponseModel createLawyer(@RequestBody Lawyer lawyer) {
        return lawyerService.createLawyer(lawyer);
    }

}
