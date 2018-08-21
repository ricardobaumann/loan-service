package com.github.ricardobaumann.loanservice.repos;

import com.github.ricardobaumann.loanservice.models.Loan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource
@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface LoanRepo extends CrudRepository<Loan, Long> {
}
