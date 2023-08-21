package com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy="client", fetch=FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();
    @OneToMany(mappedBy = "clientId", fetch = FetchType.EAGER)
    private Set<ClientLoan> loans = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Card> cards = new HashSet<>();

    public Client(){

    }

    public Client(String name, String lastName, String email) {
        this.firstName = name;
        this.lastName = lastName;
        this.email = email;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void addCard(Card card){
        card.setClient(this);
        cards.add(card);
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void addLoan(ClientLoan loan){
        loan.setClientId(this);
        loans.add(loan);
    }
    public void addAccount(Account account) {
        account.setClient(this);
        accounts.add(account);
    }

    public Long getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setLoans(Set<ClientLoan> loans) {
        this.loans = loans;
    }

    public Set<Loan> getLoans(){
        return loans.stream().map(loan -> loan.getLoanId()).collect(Collectors.toSet());
    }

    public Set<ClientLoan> getClientLoans(){
        return this.loans;
    }

}
