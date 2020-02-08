package com.facebookhackathon.carcerem.controllers;

import com.facebookhackathon.carcerem.models.Inmate;
import com.facebookhackathon.carcerem.models.InmateCreationModel;
import com.facebookhackathon.carcerem.models.ResponseModel;
import com.facebookhackathon.carcerem.service.InmateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
@Controller
@RequestMapping("/inmate")
public class InmateController {

    final
    InmateService inmateService;

    public InmateController(InmateService inmateService) {
        this.inmateService = inmateService;
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseModel createInmate(@RequestBody InmateCreationModel model) {
        return inmateService.createInmate(model);
    }

    @ResponseBody
    @RequestMapping(value = "/assign_lawyer", method = RequestMethod.POST)
    public ResponseModel assignLawyerToInmate(@RequestBody InmateCreationModel model) {
        return  inmateService.assignLawyerToInmate(model);
    }

    @ResponseBody
    @RequestMapping(value = "/get_inmate")
    public Inmate getInmate(@RequestParam("inmateId") String inmateId){
        return inmateService.getInmate(inmateId);
    }
}
