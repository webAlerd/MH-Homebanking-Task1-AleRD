package com.mindhubhomebankingAlejandroRuizDiaz.homebanking.repositories;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long>{

}
