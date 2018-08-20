package com.github.ricardobaumann.loanservice.configs;

import com.github.ricardobaumann.loanservice.AuthenticationService;
import com.github.ricardobaumann.loanservice.handlers.InvestmentsEvents;
import com.github.ricardobaumann.loanservice.handlers.LoanEvents;
import com.github.ricardobaumann.loanservice.repos.LoanOriginatorRepo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {

    @Bean
    LoanEvents loanEvents(LoanOriginatorRepo loanOriginatorRepo,
                          AuthenticationService authenticationService) {
        return new LoanEvents(loanOriginatorRepo, authenticationService);
    }

    @Bean
    InvestmentsEvents investmentsEvents(AuthenticationService authenticationService) {
        return new InvestmentsEvents(authenticationService);
    }

}
