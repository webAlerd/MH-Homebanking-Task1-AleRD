package com.mindhubhomebankingAlejandroRuizDiaz.homebanking;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Account;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Client;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.Transaction;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.TransactionType;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.repositories.AccountRepository;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.repositories.ClientRepository;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.repositories.TransactionRepository;
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
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository){
		return args -> {
			Client client1 = new Client("Melba1", "Morel1", "melbaMorel1@gmail.com");
			Client client2 = new Client("Melba2", "Morel2", "melbaMorel2@gmail.com");
			clientRepository.save(client1);
			clientRepository.save(client2);
			LocalDate today =  LocalDate.now();
			LocalDate tomorrow = today.plusDays(1);
			Account account1 = new Account("VIN001",today, 5000, client1);
			Account account2 = new Account("VIN002",tomorrow, 1500, client1);
			Account account3 = new Account("VIN003",tomorrow, 15500, client2);
			Account account4 = new Account("VIN004",today, 788500, client2);
			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);
			accountRepository.save(account4);
			Transaction transaction1 = new Transaction(TransactionType.CREDIT, 20000, "xd", today, account1);
			Transaction transaction2 = new Transaction(TransactionType.DEBIT, -2000, "xd2", today, account2);
			Transaction transaction3 = new Transaction(TransactionType.CREDIT, 7665000, "xd3", today, account2);
			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);
		};
	}

}
