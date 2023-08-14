package com.mindhubhomebankingAlejandroRuizDiaz.homebanking.dtos;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Transaction;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.TransactionType;

import java.time.LocalDate;

public class TransactionDTO {
    private Long id;
    private TransactionType type;
    private double amount;
    private String description;
    private LocalDate date;

    public TransactionDTO(Transaction transaction){
        this.id = transaction.getId();
        this.type = transaction.getType();
        this.amount = transaction.getAmount();
        this.description = transaction.getDescription();
        this.date = transaction.getDate();
    }

    public Long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}
