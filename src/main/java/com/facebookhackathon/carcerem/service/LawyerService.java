package com.facebookhackathon.carcerem.service;

import com.facebookhackathon.carcerem.models.Lawyer;
import com.facebookhackathon.carcerem.models.ResponseModel;
import com.facebookhackathon.carcerem.repositories.LawyerRepository;
import com.facebookhackathon.carcerem.util.Crime;
import com.facebookhackathon.carcerem.util.Status;
import org.springframework.stereotype.Service;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
@Service
public class LawyerService {

    private final
    LawyerRepository lawyerRepository;

    public LawyerService(LawyerRepository lawyerRepository) {
        this.lawyerRepository = lawyerRepository;
    }

    public ResponseModel createLawyer(Lawyer lawyer) {
        if (lawyer == null) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus(Status.FAILED);
            responseModel.setDescription("Failed");
        }

        lawyer = lawyerRepository.save(lawyer);

        ResponseModel responseModel = new ResponseModel();
        responseModel.setLawyer(lawyer);
        responseModel.setStatus(Status.SUCCESSFUL);
        responseModel.setDescription("Successful");
        return responseModel;
    }

    public Lawyer getAvailableLawyerByCrime(Crime allegedCrime) {
        return lawyerRepository.findFirstByCrimeInterest(allegedCrime);
    }
}
