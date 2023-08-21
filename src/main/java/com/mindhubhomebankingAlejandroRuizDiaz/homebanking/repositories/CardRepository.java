package com.mindhubhomebankingAlejandroRuizDiaz.homebanking.repositories;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CardRepository extends JpaRepository<Card, Long> {
}
