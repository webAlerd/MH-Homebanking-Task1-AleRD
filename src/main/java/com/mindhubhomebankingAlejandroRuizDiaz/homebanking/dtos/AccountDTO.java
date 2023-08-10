package com.mindhubhomebankingAlejandroRuizDiaz.homebanking.dtos;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Account;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Transaction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO {
    private Long id;
    private String number;
    private LocalDate creationDate;
    private int balance;
    private Set<TransactionDTO> transactions = new HashSet<>();

    public AccountDTO(Account account){
        this.id = account.getId();
        this.number = account.getNumber();;
        this.creationDate = account.getCreationDate();
        this.balance = account.getBalance();
        this.transactions = account.getTransactions().stream().map(transaction -> new TransactionDTO((transaction))).collect(Collectors.toSet());
    }

    public Set<TransactionDTO> getTransactions() {
        return transactions;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return creationDate;
    }

    public int getBalance() {
        return balance;
    }
}
