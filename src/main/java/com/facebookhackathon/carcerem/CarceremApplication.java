package com.facebookhackathon.carcerem;

import com.facebookhackathon.carcerem.models.AccountUser;
import com.facebookhackathon.carcerem.models.Inmate;
import com.facebookhackathon.carcerem.repositories.AccountUserRepository;
import com.facebookhackathon.carcerem.repositories.InmateRepository;
import com.facebookhackathon.carcerem.util.InmateStatus;
import com.facebookhackathon.carcerem.util.Judgement;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarceremApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarceremApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner mappingDemo(AccountUserRepository accountUserRepository, InmateRepository inmateRepository) {
//        return args -> {
//
//            AccountUser accountUser = new AccountUser();
//            accountUser.setName("John Doe");
//            accountUser.setPassword("password");
//            accountUser.setEmail("john@doe.com");
//
//            accountUserRepository.save(accountUser);
//            inmateRepository.save(new Inmate(10, "janet", "", InmateStatus.ARRESTED, Judgement.NOT_AVAILABLE, accountUser));
//            inmateRepository.save(new Inmate(11, "johnson", "", InmateStatus.ARRESTED, Judgement.NOT_AVAILABLE, accountUser));
//        };
//    }

}
