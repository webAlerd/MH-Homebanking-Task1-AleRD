package com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String name;
    private double maxAmount;
    @ElementCollection
    @Column(name="Payments")
    private List<String> paymants = new ArrayList<>();
    @OneToMany(mappedBy = "loanId", fetch = FetchType.EAGER)
    Set<ClientLoan> loans;

    public Loan(){
    }

    public Loan(String name, double maxAmount, List<String> paymants){
        this.name = name;
        this.maxAmount = maxAmount;
        this.paymants = paymants;
    }

    public void addLoan(ClientLoan loan){
        loan.setLoanId(this);
        loans.add(loan);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public List<String> getPaymants() {
        return paymants;
    }

    public void setPaymants(List<String> paymants) {
        this.paymants = paymants;
    }
    @JsonIgnore
    public List<Client> getClients(){
        return loans.stream().map(loan -> loan.getClientId()).collect(Collectors.toList());
    }
}
