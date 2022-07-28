package cvut.fel;

import cvut.fel.entity.Account;
import cvut.fel.entity.Customer;
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
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        Customer customer1 = new Customer("Pedro");
        customer1.setPhonenumber(06123);
        Account account = new Account(1234);
        account.setAmount(1000);
        customer1.setAccount(account);

        Customer customer2 = new Customer("Manuel");
        customer2.setPhonenumber(0723);

        customerRepository.save(customer1)
        customerRepository.save(customer2);

        System.out.println("\nfindAll()");
        customerRepository.findAll().forEach(System.out::println);
        System.out.println("\nfindByName('Pedro')");
        customerRepository.findByName("Pedro").forEach(System.out::println);
        accountRepository.save(account);



        Account account1 = new Account(1);
        account1.setAmount(99);
        Account account2 = new Account(2);
        account2.setAmount(100);

        accountRepository.save(account1);
        accountRepository.save(account2);

        System.out.println("\nfindAll()");
        accountRepository.findAll().forEach(System.out::println);
        System.out.println("\nfindById(55L)");
        accountRepository.findById(2L).ifPresent(System.out::println);

    }

}