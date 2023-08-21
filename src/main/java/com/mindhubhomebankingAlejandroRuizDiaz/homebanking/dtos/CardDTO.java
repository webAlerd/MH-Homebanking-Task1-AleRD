package com.mindhubhomebankingAlejandroRuizDiaz.homebanking.dtos;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Card;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.CardColor;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.CardType;

import java.time.LocalDate;

public class CardDTO {
    private Long id;
    private CardType type;
    private int number;
    private int cvv;
    private LocalDate fromDate;
    private LocalDate thruDate;
    private String cardholder;
    private CardColor color;

    public CardDTO(Card card){
        this.id = card.getId();
        this.number = card.getNumber();
        this.type = card.getType();
        this.cvv = card.getCvv();
        this.fromDate = card.getFromDate();
        this.thruDate = card.getThruDate();
        this.cardholder = card.getCardholder();
        this.color = card.getColor();
    }

    public Long getId() {
        return id;
    }

    public CardType getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public String getCardholder() {
        return cardholder;
    }

    public CardColor getColor() {
        return color;
    }
}
