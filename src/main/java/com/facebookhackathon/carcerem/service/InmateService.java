package com.facebookhackathon.carcerem.service;

import com.facebookhackathon.carcerem.models.*;
import com.facebookhackathon.carcerem.repositories.InmateRepository;
import com.facebookhackathon.carcerem.util.Status;
import org.springframework.stereotype.Service;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
@Service
public class InmateService {

    private final
    InmateRepository inmateRepository;
    private final
    AccountUserService accountUserService;
    private final
    LawyerService lawyerService;

    public InmateService(InmateRepository inmateRepository, AccountUserService accountUserService, LawyerService lawyerService) {
        this.inmateRepository = inmateRepository;
        this.accountUserService = accountUserService;
        this.lawyerService = lawyerService;
    }

    public ResponseModel createInmate(InmateCreationModel model) {
        if (model == null || model.getDetails() == null || model.getCreatorUsername() == null || model.getCreatorUsername().isEmpty()) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus(Status.FAILED);
            responseModel.setDescription("Failed");
            return responseModel;
        }

        AccountUser accountUser = accountUserService.getUser(model.getCreatorUsername());

        Inmate inmate = model.getDetails();
        inmate.setUser(accountUser);
        inmateRepository.save(inmate);

        ResponseModel responseModel = new ResponseModel();
        responseModel.setAccountUser(accountUser);
        responseModel.setStatus(Status.SUCCESSFUL);
        responseModel.setDescription("Successful");

        return responseModel;
    }

    public ResponseModel assignLawyerToInmate(InmateCreationModel model) {
        if (model == null || model.getDetails() == null) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus(Status.FAILED);
            responseModel.setDescription("Failed");
            return responseModel;
        }

        Inmate inmate = inmateRepository.findById(model.getDetails().getId()).orElse(null);
        if (inmate == null) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus(Status.FAILED);
            responseModel.setDescription("Inmate is null");
            return responseModel;
        }

        Lawyer lawyer = lawyerService.getAvailableLawyerByCrime(inmate.getAllegedCrime());
        if (lawyer == null) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus(Status.FAILED);
            responseModel.setDescription("Lawyer not found");
            return responseModel;
        }
        inmate.setLawyer(lawyer);

        ResponseModel responseModel = new ResponseModel();
        responseModel.setLawyer(lawyer);
        return responseModel;
    }
}
