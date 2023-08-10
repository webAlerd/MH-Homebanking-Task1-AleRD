package com.mindhubhomebankingAlejandroRuizDiaz.homebanking.controllers;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.dtos.ClientDTO;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Client;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @GetMapping("/clients")
    public List<ClientDTO> getClients(){
        List<Client> allClients = clientRepository.findAll();
        return allClients.stream().map(currentClient -> new ClientDTO(currentClient)).collect(Collectors.toList());
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClientById(@PathVariable Long idClient){
        Optional<Client> client = clientRepository.findById(idClient);
        return new ClientDTO(client.get());
    }
}
