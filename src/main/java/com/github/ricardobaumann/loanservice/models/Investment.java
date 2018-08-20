package com.github.ricardobaumann.loanservice.models;

import org.springframework.data.rest.core.annotation.RestResource;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

@Entity
@Table(name = "investments")
public class Investment {

    @Id
    private Long id;

    private String owner;

    //@NotNull
    @ManyToOne
    @RestResource
    private LoanOriginator loanOriginator;

    //@NotNull
    @DecimalMin("0.1")
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LoanOriginator getLoanOriginator() {
        return loanOriginator;
    }

    public void setLoanOriginator(LoanOriginator loanOriginator) {
        this.loanOriginator = loanOriginator;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
