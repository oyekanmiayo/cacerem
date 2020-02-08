package com.facebookhackathon.carcerem.repositories;

import com.facebookhackathon.carcerem.models.Lawyer;
import com.facebookhackathon.carcerem.util.Crime;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-08
 */
public interface LawyerRepository extends CrudRepository<Lawyer, Long> {
    Lawyer findFirstByCrimeInterest(Crime crimeInterest);
}
