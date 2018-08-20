package com.github.ricardobaumann.loanservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "loan_originators",
        uniqueConstraints = @UniqueConstraint(name = "uk_loan_originator_name", columnNames = "name"))
public class LoanOriginator {

    @Id
    private long id;

    @NotNull
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoanOriginator() {
    }

    public LoanOriginator(long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }
}
