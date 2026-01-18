package ObjectModelling;

import java.util.ArrayList;

/*
this class represents the Customer entity.
it maintains its own list of balances to simulate multiple accounts.
in this direct association, the Customer communicates with the Bank
to view balances and receive funds.
*/
class Customer {
    private String name;
    private ArrayList<Double> accounts; // stores balances directly

    // constructor initializes the customer name and an empty account list
    Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // method used by the bank to push a new account balance to the customer
    public void addAccountBalance(double balance) {
        accounts.add(balance);
    }

    public String getName() {
        return name;
    }

    /* this method demonstrates the 'viewBalance' task.
    it iterates through the local balances associated with this customer.
    */
    public void viewBalance() {
        System.out.println("Customer: " + name);
        if (accounts.isEmpty()) {
            System.out.println("No active accounts found.");
        } else {
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println("Account #" + (i + 1) + " Balance: $" + accounts.get(i));
            }
        }
        System.out.println("---------------------------");
    }
}

/*
this class represents the Bank entity.
it holds a list of associated Customer objects.
the 'openAccount' method establishes the link by directly 
communicating with the Customer object.
*/
class Bank {
    private String bankName;
    private ArrayList<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    // associates an existing customer with this bank
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(customer.getName() + " is now a registered customer of " + bankName);
    }

    /* task implementation: openAccount()
    this method performs the association logic by updating the 
    Customer's data directly from the Bank class.
    */
    public void openAccount(Customer customer, double initialDeposit) {
        customer.addAccountBalance(initialDeposit);
        System.out.println("Successfully opened a new account at " + bankName + 
                           " for " + customer.getName() + " with $" + initialDeposit);
    }

    public String getBankName() {
        return bankName;
    }
}

/*
the main class demonstrates the direct association between 
Bank and Customer without a third-party Account class.
*/
public class BankAccountManagement{
    public static void main(String[] args) {
        // creating the independent entities
        Bank myBank = new Bank("National Savings Bank");
        Customer c1 = new Customer("Aayush");

        // establishing the association
        myBank.addCustomer(c1);
        System.out.println();

        // communication: bank triggers the opening of accounts for the customer
        myBank.openAccount(c1, 1200.50);
        myBank.openAccount(c1, 3000.00);

        System.out.println();

        // communication: customer views their balances
        c1.viewBalance();
    }
}
