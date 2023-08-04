package com.mindhubhomebankingAlejandroRuizDiaz.homebanking;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Client;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository){
		return args -> {
			Client client = new Client("44884979", "Alejandro", "Ruiz Diaz", "pepito@pepito.com");
			clientRepository.save(client);
		};
	}

}
