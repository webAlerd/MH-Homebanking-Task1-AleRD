package com.mindhubhomebankingAlejandroRuizDiaz.homebanking.dtos;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.ClientLoan;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Loan;

public class ClientLoanDTO {
    private Long id;
    private double amount;
    private String payments;
    private Long loanId;
    private String name;

    public ClientLoanDTO(ClientLoan clientLoan){
        this.id = clientLoan.getId();
        this.amount = clientLoan.getAmount();
        this.payments = clientLoan.getPayments();
        this.loanId = clientLoan.getLoanId().getId();
        this.name = clientLoan.getLoanId().getName();
    }

    public Long getLoanId() {
        return loanId;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getPayments() {
        return payments;
    }
}
