package com.github.ricardobaumann.loanservice.repos;

import com.github.ricardobaumann.loanservice.models.LoanOriginator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LoanOriginatorRepo extends CrudRepository<LoanOriginator, Long> {
    LoanOriginator findByName(String name);
}
