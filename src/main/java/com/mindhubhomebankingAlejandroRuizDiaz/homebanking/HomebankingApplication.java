package com.mindhubhomebankingAlejandroRuizDiaz.homebanking;

import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.models.*;
import com.mindhubhomebankingAlejandroRuizDiaz.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(CardRepository cardRepository, ClientRepository clientRepository, ClientLoanRepository clientLoanRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository){
		return args -> {
			Client client1 = new Client("Melba", "Morel", "melbaMorel@gmail.com");
			Client client2 = new Client("Ale", "Ruidia", "aleruidia@gmail.com");
			clientRepository.save(client1);
			clientRepository.save(client2);
			LocalDate today =  LocalDate.now();
			LocalDate tomorrow = today.plusDays(1);
			Account account1 = new Account("VIN001",today, 5000);
			Account account2 = new Account("VIN002",tomorrow, 1500);
			Account account3 = new Account("VIN003",tomorrow, 15500);
			Account account4 = new Account("VIN004",today, 788500);
			client1.addAccount(account1);
			client1.addAccount(account2);
			client2.addAccount(account3);
			client2.addAccount(account4);
			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);
			accountRepository.save(account4);
			Transaction transaction1 = new Transaction(TransactionType.CREDIT, 20000, "xd", today, account1);
			Transaction transaction2 = new Transaction(TransactionType.DEBIT, -2000, "xd2", today, account2);
			Transaction transaction3 = new Transaction(TransactionType.CREDIT, 7665000, "xd3", today, account2);
			account1.addTransaction(transaction1);
			account2.addTransaction(transaction2);
			account1.addTransaction(transaction3);
			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);
			Loan loan1 = new Loan("Personal", 100000, List.of("6","12","24"));
			Loan loan2 = new Loan("Hipotecario", 500000, List.of("12","24","36","48","60"));
			Loan loan3 = new Loan("Automotriz", 300000, List.of("6","12","24","36"));
			loanRepository.save(loan1);
			loanRepository.save(loan2);
			loanRepository.save(loan3);
			ClientLoan clientLoan1 = new ClientLoan(400000,"60",client1,loan2);
			ClientLoan clientLoan2 = new ClientLoan(50000,"12",client1,loan1);
			ClientLoan clientLoan3 = new ClientLoan(100000,"24",client2,loan1);
			ClientLoan clientLoan4 = new ClientLoan(200000,"36",client2,loan3);
			clientLoanRepository.save(clientLoan1);
			clientLoanRepository.save(clientLoan2);
			clientLoanRepository.save(clientLoan3);
			clientLoanRepository.save(clientLoan4);
			LocalDate fiveYears = today.plusYears(5);
			Card card1 = new Card(CardType.DEBIT, 1234567890, 123, today, fiveYears, (client1.getFirstName()+" "+client1.getLastName()), CardColor.GOLD);
			Card card2 = new Card(CardType.CREDIT, 1234342140, 433, today, fiveYears, (client1.getFirstName()+" "+client1.getLastName()), CardColor.TITANIUM);
			Card card3 = new Card(CardType.DEBIT, 987654321, 487, today, fiveYears, (client2.getFirstName()+" "+client2.getLastName()), CardColor.SILVER);
			client1.addCard(card1);
			client1.addCard(card2);
			client2.addCard(card3);
			cardRepository.save(card1);
			cardRepository.save(card2);
			cardRepository.save(card3);

		};
	}

}
