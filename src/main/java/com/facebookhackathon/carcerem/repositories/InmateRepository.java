package com.facebookhackathon.carcerem.repositories;

import com.facebookhackathon.carcerem.models.Inmate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
public interface InmateRepository extends CrudRepository<Inmate, Long> {
    List<Inmate> findAllByAccountUser_Id(Long accountUserId);
}
