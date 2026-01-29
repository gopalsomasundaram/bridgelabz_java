/**
 * This program implements a Banking System using various data structures.
 * A HashMap provides constant-time access to account balances, a TreeMap
 * maintains a leaderboard of customers by balance, and a Queue ensures
 * withdrawal requests are processed in the order they were received.
 *
 * @author gopal
 */
package collections.mapinterface;


import java.util.*;

public class BankingSystem {

    // HashMap for O(1) balance lookups using Account Number
    private Map<String, Double> accounts = new HashMap<>();

    // Queue to handle withdrawal requests in FIFO (First-In-First-Out) order
    private Queue<WithdrawalRequest> requestQueue = new LinkedList<>();

    /**
     * Inner class to represent a withdrawal transaction.
     */
    static class WithdrawalRequest {
        String accountNumber;
        double amount;

        public WithdrawalRequest(String accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    /**
     * Adds a new account or updates an existing balance.
     *
     * @param accountNumber The unique ID for the account.
     * @param initialBalance The starting amount.
     */
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    /**
     * Adds a withdrawal request to the processing queue.
     *
     * @param accountNumber The account to withdraw from.
     * @param amount The amount to be removed.
     */
    public void submitWithdrawal(String accountNumber, double amount) {
        requestQueue.add(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Request queued: Account " + accountNumber + " for $" + amount);
    }

    /**
     * Processes all pending withdrawals in the queue.
     */
    public void processWithdrawals() {
        System.out.println("\n--- Processing Withdrawal Queue ---");
        while (!requestQueue.isEmpty()) {
            WithdrawalRequest request = requestQueue.poll();
            double currentBalance = accounts.getOrDefault(request.accountNumber, 0.0);

            if (currentBalance >= request.amount) {
                accounts.put(request.accountNumber, currentBalance - request.amount);
                System.out.println("Success: Account " + request.accountNumber + " new balance: $" + accounts.get(request.accountNumber));
            } else {
                System.out.println("Failed: Insufficient funds for Account " + request.accountNumber);
            }
        }
    }

    /**
     * Uses a TreeMap to display accounts sorted by their balance amounts.
     */
    public void displayAccountsByBalance() {
        System.out.println("\n--- Customers Sorted by Balance (High to Low) ---");

        // Since TreeMap sorts by Key, we use the balance as the key.
        // We use a reverse order comparator for a "High to Low" view.
        // Note: To handle duplicate balances, we include the account number in the key.
        TreeMap<String, String> sortedMap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            // Formatting key as "Balance : AccountNumber" to ensure uniqueness in TreeMap
            String sortKey = String.format("%015.2f : %s", entry.getValue(), entry.getKey());
            sortedMap.put(sortKey, entry.getKey());
        }

        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            String accNum = entry.getValue();
            System.out.println("Account: " + accNum + " | Balance: $" + accounts.get(accNum));
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // 1. Initialize accounts
        bank.createAccount("ACC001", 5000.00);
        bank.createAccount("ACC002", 1500.00);
        bank.createAccount("ACC003", 12000.00);

        // 2. Queue some withdrawals
        bank.submitWithdrawal("ACC001", 1000.00);
        bank.submitWithdrawal("ACC002", 2000.00); // Should fail (insufficient funds)
        bank.submitWithdrawal("ACC003", 5000.00);

        // 3. Process the queue (Queue logic)
        bank.processWithdrawals();

        // 4. Show sorted leaderboard (TreeMap logic)
        bank.displayAccountsByBalance();
    }
}