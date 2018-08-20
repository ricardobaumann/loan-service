package com.github.ricardobaumann.loanservice.handlers;

import com.github.ricardobaumann.loanservice.models.Investment;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@RepositoryEventHandler(Investment.class)
public class InvestmentsEvents {

    /*
    {
	"id" : 1,

	"amount" : 20.0,
	"loanOriginator": "http://localhost:8080/loanOriginators/1"
}
     */
    @HandleBeforeCreate
    void handleBeforeSave(Investment investment) {
        Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .ifPresent(authentication -> investment.setOwner(authentication.getName()));
    }

}
