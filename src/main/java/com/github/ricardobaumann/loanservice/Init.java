package com.github.ricardobaumann.loanservice;

import com.github.ricardobaumann.loanservice.models.Loan;
import com.github.ricardobaumann.loanservice.models.LoanOriginator;
import com.github.ricardobaumann.loanservice.repos.LoanOriginatorRepo;
import com.github.ricardobaumann.loanservice.repos.LoanRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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
        LoanOriginator firstLoanOriginator = new LoanOriginator(1, "first");
        LoanOriginator secondLoanOriginator = new LoanOriginator(2, "second");
        loanOriginatorRepo.save(firstLoanOriginator);
        loanOriginatorRepo.save(secondLoanOriginator);

        loanRepo.save(new Loan(1L, new BigDecimal(100.0), firstLoanOriginator));
        loanRepo.save(new Loan(2L, new BigDecimal(200.0), secondLoanOriginator));
    }
}
