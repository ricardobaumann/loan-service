package com.github.ricardobaumann.loanservice;

import com.github.ricardobaumann.loanservice.models.LoanOriginator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LoanOriginatorRepo extends CrudRepository<LoanOriginator, Long> {
}
