package com.github.ricardobaumann.loanservice.handlers;

import com.github.ricardobaumann.loanservice.models.Investment;
import com.github.ricardobaumann.loanservice.services.AuthenticationService;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.util.Optional;

@RepositoryEventHandler(Investment.class)
public class InvestmentsEvents {

    private final AuthenticationService authenticationService;

    public InvestmentsEvents(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /*
    {
	"id" : 1,

	"amount" : 20.0,
	"loanOriginator": "http://localhost:8080/loanOriginators/1"
}
     */
    @HandleBeforeCreate
    void handleBeforeSave(Investment investment) {
        Optional.ofNullable(authenticationService.getCurrentUser())
                .ifPresent(authentication -> investment.setOwner(authentication.getName()));
    }

}
