package EncapsulationAndInterface;

import java.util.ArrayList;

/*
the Loanable interface defines the contract for credit services.
this allows specific accounts to support loan processing without
affecting the base BankAccount structure.
*/
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

/*
the BankAccount class is abstract, serving as a secure template.
it uses encapsulation to protect the account balance and holder details.
*/
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // getters for encapsulated fields
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    // concrete method: shared logic for all accounts
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " into " + accountNumber);
        }
    }

    // concrete method: standard withdrawal with basic validation
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " from " + accountNumber);
        } else {
            System.out.println("Insufficient funds or invalid amount for " + accountNumber);
        }
    }
//abstract method
    public abstract void calculateInterest();

    public void displayBasicInfo() {
        System.out.println("Account: " + accountNumber + " | Holder: " + holderName);
        System.out.println("Current Balance: $" + balance);
    }
}

/*
SavingsAccount specializes in interest accumulation and supports loans.
*/
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; // 4% interest

    public SavingsAccount(String accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * interestRate;
        System.out.println("Interest earned (Savings): $" + interest);
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of $" + amount + " approved for " + getHolderName());
        } else {
            System.out.println("Loan denied: Insufficient balance for eligibility.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        // eligibility rule: balance must be greater than $5,000
        return getBalance() >= 5000.0;
    }
}

/*
CurrentAccount typically has lower interest but higher transaction limits.
*/
class CurrentAccount extends BankAccount {
    public CurrentAccount(String accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    public void calculateInterest() {
        // current accounts often have zero or minimal interest
        double interest = getBalance() * 0.01;
        System.out.println("Interest earned (Current): $" + interest);
    }
}

/*
the driver class demonstrates dynamic polymorphism
and secure object interactions.
*/
public class BankManagementSystem {
    public static void main(String[] args) {
        ArrayList<BankAccount> bankDirectory = new ArrayList<>();

        SavingsAccount sa = new SavingsAccount("SAV-101", "Aayush", 6000.0);
        CurrentAccount ca = new CurrentAccount("CUR-202", "Sita", 3000.0);

        bankDirectory.add(sa);
        bankDirectory.add(ca);

        System.out.println("--- Monthly Banking Report ---");
        System.out.println("------------------------------");

        for (BankAccount account : bankDirectory) {
            account.displayBasicInfo();

            //dynamic polymorphism:
            // calls the specific subclass version of calculateInterest().
            account.calculateInterest();

            // checking for interface implementation to
            //   trigger loan logic selectively.

            if (account instanceof Loanable) {
                Loanable loanAccount = (Loanable) account;
                System.out.println("Loan Eligibility: " +
                        (loanAccount.calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
            }

            System.out.println("------------------------------");
        }
    }
}