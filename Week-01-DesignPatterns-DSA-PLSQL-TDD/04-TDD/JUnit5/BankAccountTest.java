package tdd.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("ACC-1001", 5000.00);
    }

    @Test
    @DisplayName("Test successful deposit")
    void testDepositSuccess() {
        account.deposit(1500.00);
        assertEquals(6500.00, account.getBalance(), "Balance should increase after deposit");
    }

    @Test
    @DisplayName("Test successful withdrawal")
    void testWithdrawSuccess() {
        account.withdraw(2000.00);
        assertEquals(3000.00, account.getBalance(), "Balance should decrease after withdrawal");
    }

    @Test
    @DisplayName("Test withdrawal exceeding balance throws exception")
    void testWithdrawInsufficientFunds() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            account.withdraw(6000.00);
        });
        assertEquals("Insufficient balance in account", exception.getMessage());
    }

    @Test
    @DisplayName("Test negative deposit throws exception")
    void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-500.00);
        });
    }
}
