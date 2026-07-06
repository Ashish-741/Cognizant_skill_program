package week2.assignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

// 1. Repository Layer
@Repository
class AccountRepository {
    private final Map<String, Double> accounts = new HashMap<>();

    public AccountRepository() {
        accounts.put("ACC-1001", 50000.00);
        accounts.put("ACC-1002", 75000.00);
    }

    public double getBalance(String accNumber) {
        return accounts.getOrDefault(accNumber, 0.0);
    }

    public void updateBalance(String accNumber, double newBalance) {
        accounts.put(accNumber, newBalance);
    }
}

// 2. Logging Component
@Component
class TransactionLogger {
    public void logTransaction(String type, String accNumber, double amount) {
        System.out.printf("[LOG-AUDIT] %s on Account %s | Amount: ₹%,.2f | Status: SUCCESS\n", type, accNumber, amount);
    }
}

// 3. Service Layer demonstrating Constructor Injection
@Service
class BankService {
    private final AccountRepository repository;
    private final TransactionLogger logger;

    @Autowired
    public BankService(AccountRepository repository, TransactionLogger logger) {
        this.repository = repository;
        this.logger = logger;
    }

    public void deposit(String accNumber, double amount) {
        double current = repository.getBalance(accNumber);
        repository.updateBalance(accNumber, current + amount);
        logger.logTransaction("DEPOSIT", accNumber, amount);
        System.out.printf("New Balance for %s: ₹%,.2f\n", accNumber, repository.getBalance(accNumber));
    }
}

// 4. Configuration
@Configuration
@ComponentScan(basePackages = "week2.assignments")
class BankConfig {}

// 5. Main Assignment Execution
public class BankAccountDI {
    public static void main(String[] args) {
        System.out.println("=== Assignment 2: Banking Service using Spring DI ===");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BankConfig.class);

        BankService bankService = context.getBean(BankService.class);
        bankService.deposit("ACC-1001", 15000.00);
        bankService.deposit("ACC-1002", 25000.00);

        context.close();
    }
}
