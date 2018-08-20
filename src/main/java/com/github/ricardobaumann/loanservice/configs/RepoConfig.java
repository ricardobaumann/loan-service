package com.github.ricardobaumann.loanservice.configs;

import com.github.ricardobaumann.loanservice.handlers.InvestmentsEvents;
import com.github.ricardobaumann.loanservice.handlers.LoanEvents;
import com.github.ricardobaumann.loanservice.repos.LoanOriginatorRepo;
import com.github.ricardobaumann.loanservice.services.AuthenticationService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.security.Principal;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
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

    @Bean
    AuditorAware auditorAware(AuthenticationService authenticationService) {
        return () -> Optional.ofNullable(authenticationService.getCurrentUser())
                .map(Principal::getName);
    }

}
