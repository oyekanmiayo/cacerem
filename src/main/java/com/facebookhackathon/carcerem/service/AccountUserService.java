package com.facebookhackathon.carcerem.service;

import com.facebookhackathon.carcerem.models.AccountUser;
import com.facebookhackathon.carcerem.models.AccountUserLoginModel;
import com.facebookhackathon.carcerem.models.ResponseModel;
import com.facebookhackathon.carcerem.repositories.AccountUserRepository;
import com.facebookhackathon.carcerem.repositories.InmateRepository;
import com.facebookhackathon.carcerem.util.Status;
import org.springframework.stereotype.Service;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
@Service
public class AccountUserService {

    private final AccountUserRepository accountUserRepository;
    private final InmateRepository inmateRepository;

    public AccountUserService(AccountUserRepository accountUserRepository, InmateRepository inmateRepository) {
        this.accountUserRepository = accountUserRepository;
        this.inmateRepository = inmateRepository;
    }

    public AccountUser registerUser(AccountUser user) {
        return accountUserRepository.save(user);
    }

    public ResponseModel getAccountUserLoginResponse(AccountUserLoginModel model) {
        if (model.getUsername() == null || model.getUsername().isEmpty() || model.getPassword() == null) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus(Status.FAILED);
            return responseModel;
        }

        AccountUser accountUser = accountUserRepository.findAccountUserByUsername(model.getUsername());
        if (!model.getPassword().equals(accountUser.getPassword())) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus(Status.FAILED);
            responseModel.setDescription("Password is incorrect");
            return responseModel;
        }

        ResponseModel responseModel = new ResponseModel();
        responseModel.setAccountUser(accountUser);
        responseModel.setStatus(Status.SUCCESSFUL);
        responseModel.setDescription("Successful");
        return responseModel;
    }

    public AccountUser getUser(String username) {
        return accountUserRepository.findAccountUserByUsername(username);
    }
}
