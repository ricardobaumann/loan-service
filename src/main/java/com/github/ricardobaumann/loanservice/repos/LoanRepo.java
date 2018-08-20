package com.github.ricardobaumann.loanservice.repos;

import com.github.ricardobaumann.loanservice.models.Loan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LoanRepo extends CrudRepository<Loan, Long> {
}
