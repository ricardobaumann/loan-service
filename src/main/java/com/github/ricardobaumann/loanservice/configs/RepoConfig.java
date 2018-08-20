package com.github.ricardobaumann.loanservice.configs;

import com.github.ricardobaumann.loanservice.repos.LoanEvents;
import com.github.ricardobaumann.loanservice.repos.LoanOriginatorRepo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {

    @Bean
    LoanEvents loanEvents(LoanOriginatorRepo loanOriginatorRepo) {
        return new LoanEvents(loanOriginatorRepo);
    }

}
