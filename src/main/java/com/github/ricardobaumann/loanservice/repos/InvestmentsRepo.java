package com.github.ricardobaumann.loanservice.repos;

import com.github.ricardobaumann.loanservice.models.Investment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InvestmentsRepo extends CrudRepository<Investment, Long> {
}
