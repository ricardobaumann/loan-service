package com.github.ricardobaumann.loanservice.repos;

import com.github.ricardobaumann.loanservice.models.Loan;
import com.github.ricardobaumann.loanservice.models.LoanOriginator;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

@RepositoryEventHandler(Loan.class)
public class LoanEvents {

    private final LoanOriginatorRepo loanOriginatorRepo;

    public LoanEvents(LoanOriginatorRepo loanOriginatorRepo) {
        this.loanOriginatorRepo = loanOriginatorRepo;
    }

    @HandleBeforeCreate(Loan.class)
    @HandleBeforeSave(Loan.class)
    void handleBeforeSave(Loan loan) {
        Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication()).ifPresent(user -> {
            LoanOriginator loanOriginator = Optional.ofNullable(loanOriginatorRepo.findByName(user.getName()))
                    .orElseGet(() -> loanOriginatorRepo.save(new LoanOriginator(UUID.randomUUID().hashCode(), user.getName())));
            loan.setLoanOriginator(loanOriginator);
        });

    }

}
