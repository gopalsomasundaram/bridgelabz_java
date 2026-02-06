/**
 * This Program implements a Bank Account management system and its corresponding
 * unit tests using the JUnit 5 framework. It demonstrates core banking logic
 * such as deposits and withdrawals alongside automated validation of
 * business rules and exception handling.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents a simple bank account with balance management.
 * It includes logic to handle deposits, withdrawals, and balance inquiries
 * while enforcing constraints on transaction amounts.
 */
class BankAccount {
    // Current balance of the account
    private double balance;

    // Constructor to initialize the account with a starting balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Handles depositing funds into the account
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    // Handles withdrawing funds with check for sufficient balance
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new RuntimeException("Insufficient funds");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        balance -= amount;
    }

    // Getter for the current balance
    public double getBalance() {
        return balance;
    }
}

/**
 * This class provides unit tests for the BankAccount class.
 * It utilizes JUnit 5 annotations to setup test environments and verify
 * that both successful transactions and error conditions behave as expected.
 */
public class BankAccountTest {
    // Instance of BankAccount to be used across tests
    private BankAccount account;

    /**
     * Set up method to initialize the test environment.
     * Runs before each individual test case to ensure a fresh state.
     */
    @BeforeEach
    void setUp() {
        // Start each test with $1000
        account = new BankAccount(1000.0);
    }

    /**
     * Tests the deposit functionality to ensure balance increases correctly.
     */
    @Test
    void testDeposit() {
        account.deposit(500.0);
        // Assertions.assertEquals(expected, actual, delta)
        // We use 0.001 delta for double comparisons to account for precision
        Assertions.assertEquals(1500.0, account.getBalance(), 0.001);
    }

    /**
     * Tests a successful withdrawal and verifies the remaining balance.
     */
    @Test
    void testWithdrawSuccess() {
        account.withdraw(400.0);
        Assertions.assertEquals(600.0, account.getBalance(), 0.001);
    }

    /**
     * Tests the scenario where a withdrawal exceeds the available balance.
     * Verifies that the correct exception is thrown and state remains unchanged.
     */
    @Test
    void testWithdrawInsufficientFunds() {
        // Assert that the specific exception is thrown
        Assertions.assertThrows(RuntimeException.class, () -> {
            account.withdraw(1500.0);
        }, "Should throw RuntimeException when withdrawing more than balance");

        // Ensure balance didn't change after failed withdrawal
        Assertions.assertEquals(1000.0, account.getBalance());
    }
}