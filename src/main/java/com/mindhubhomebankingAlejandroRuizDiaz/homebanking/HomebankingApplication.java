package com.mindhubhomebankingAlejandroRuizDiaz.homebanking;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Account;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Client;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.repositories.AccountRepository;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository,AccountRepository accountRepository){
		return args -> {
			Client client = new Client("Melba", "Morel", "melbaMorel@gmail.com");
			clientRepository.save(client);
			LocalDate today =  LocalDate.now();
			LocalDate tomorrow = today.plusDays(1);
			Account account1 = new Account("VIN001",today, 5000, client);
			Account account2 = new Account("VIN002",tomorrow, 1500, client);
			accountRepository.save(account1);
			accountRepository.save(account2);

		};
	}

}
