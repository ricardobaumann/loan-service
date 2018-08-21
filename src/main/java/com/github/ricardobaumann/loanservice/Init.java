package com.github.ricardobaumann.loanservice;

import com.github.ricardobaumann.loanservice.repos.LoanOriginatorRepo;
import com.github.ricardobaumann.loanservice.repos.LoanRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

    private final LoanOriginatorRepo loanOriginatorRepo;
    private final LoanRepo loanRepo;

    Init(LoanOriginatorRepo loanOriginatorRepo, LoanRepo loanRepo) {
        this.loanOriginatorRepo = loanOriginatorRepo;
        this.loanRepo = loanRepo;
    }

    @Override
    public void run(String... args) {
       
    }
}
