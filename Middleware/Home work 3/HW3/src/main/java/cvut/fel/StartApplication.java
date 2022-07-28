package cvut.fel;

import cvut.fel.entity.Account;
import cvut.fel.entity.Contract;
import cvut.fel.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class  StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        Contract customer1 = new Contract(4321L);
        Contract customer2 = new Contract(7654L);
        customer1.setName("Pedro");
        customer2.setName("Manuel");
        contractRepository.save(customer1);
        contractRepository.save(customer2);

        System.out.println("\nfindAll()");
        contractRepository.findAll().forEach(System.out::println);
        System.out.println("\nfindByName('Pedro')");
        contractRepository.findByName("Pedro").forEach(System.out::println);


        Account account1 = new Account("name1", 500);
        Account account2 = new Account("name2", 55);
        accountRepository.save(account1);
        accountRepository.save(account2);

        System.out.println("\nfindAll()");
        accountRepository.findAll().forEach(System.out::println);
        System.out.println("\nfindById(1L)");
        accountRepository.findById(1L).ifPresent(System.out::println);
    }

}