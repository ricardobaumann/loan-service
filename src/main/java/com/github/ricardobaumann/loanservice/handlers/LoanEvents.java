package com.github.ricardobaumann.loanservice.handlers;

import com.github.ricardobaumann.loanservice.models.Loan;
import com.github.ricardobaumann.loanservice.models.LoanOriginator;
import com.github.ricardobaumann.loanservice.repos.LoanOriginatorRepo;
import com.github.ricardobaumann.loanservice.services.AuthenticationService;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.util.Optional;
import java.util.UUID;

@RepositoryEventHandler(Loan.class)
public class LoanEvents {

    private final LoanOriginatorRepo loanOriginatorRepo;
    private final AuthenticationService authenticationService;

    public LoanEvents(LoanOriginatorRepo loanOriginatorRepo,
                      AuthenticationService authenticationService) {
        this.loanOriginatorRepo = loanOriginatorRepo;
        this.authenticationService = authenticationService;
    }

    @HandleBeforeCreate(Loan.class)
    void handleBeforeSave(Loan loan) {
        Optional.ofNullable(authenticationService.getCurrentUser()).ifPresent(user -> {
            LoanOriginator loanOriginator = Optional.ofNullable(loanOriginatorRepo.findByName(user.getName()))
                    .orElseGet(() -> loanOriginatorRepo.save(new LoanOriginator(UUID.randomUUID().hashCode(), user.getName())));
            loan.setLoanOriginator(loanOriginator);
        });

    }

}
