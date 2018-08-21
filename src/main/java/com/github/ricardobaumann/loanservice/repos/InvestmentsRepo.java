package com.github.ricardobaumann.loanservice.repos;

import com.github.ricardobaumann.loanservice.models.Investment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
public interface InvestmentsRepo extends CrudRepository<Investment, Long> {
}
