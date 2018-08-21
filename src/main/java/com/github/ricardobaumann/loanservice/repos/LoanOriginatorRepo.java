package com.github.ricardobaumann.loanservice.repos;

import com.github.ricardobaumann.loanservice.models.LoanOriginator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource
@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface LoanOriginatorRepo extends CrudRepository<LoanOriginator, Long> {
    LoanOriginator findByName(String name);
}
