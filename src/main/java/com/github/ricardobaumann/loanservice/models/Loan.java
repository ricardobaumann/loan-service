package com.github.ricardobaumann.loanservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "loans")
public class Loan extends Auditable {

    public enum Status {
        CREATED, FINISHED
    }

    @Id
    private Long id;

    @NotNull
    private BigDecimal totalAmount;

    @NotNull
    private BigDecimal usedAmount = BigDecimal.ZERO;

    @NotNull
    private Status status = Status.CREATED;

    @ManyToOne
    @JsonIgnore
    private LoanOriginator loanOriginator;

    @NotNull
    private BigDecimal interest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(BigDecimal usedAmount) {
        this.usedAmount = usedAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LoanOriginator getLoanOriginator() {
        return loanOriginator;
    }

    public void setLoanOriginator(LoanOriginator loanOriginator) {
        this.loanOriginator = loanOriginator;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public Loan() {
    }

    public Loan(Long id, @NotNull BigDecimal totalAmount, LoanOriginator loanOriginator, @NotNull BigDecimal interest) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.loanOriginator = loanOriginator;
        this.interest = interest;
    }
}
