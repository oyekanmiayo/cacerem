package com.facebookhackathon.carcerem.controllers;

import com.facebookhackathon.carcerem.models.AccountUser;
import com.facebookhackathon.carcerem.models.AccountUserLoginModel;
import com.facebookhackathon.carcerem.models.ResponseModel;
import com.facebookhackathon.carcerem.service.AccountUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
@Controller
@RequestMapping("/user")
public class AccountUserController {

    private final
    AccountUserService accountUserService;

    public AccountUserController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public AccountUser registerUser(@RequestBody AccountUser accountUser) {
        return accountUserService.registerUser(accountUser);
    }

    @ResponseBody
    @RequestMapping(value = "/login_user", method = RequestMethod.POST)
    public ResponseModel login(@RequestBody AccountUserLoginModel model) {
        return accountUserService.getAccountUserLoginResponse(model);
    }

}
