package com.facebookhackathon.carcerem.repositories;

import com.facebookhackathon.carcerem.models.AccountUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
public interface AccountUserRepository extends CrudRepository<AccountUser, Long> {
    AccountUser findAccountUserByUsername(String username);
}
