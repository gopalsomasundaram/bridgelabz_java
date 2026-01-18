package Inheritance;

/*
this class represents the superclass (parent).
it contains the fundamental data that every single bank account
must have, regardless of its specific type.
*/
class BankAccount {
    String accountNumber;
    double balance;

    // constructor to initialize common account data
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // common method to display basic account info
    void displayBaseInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
}

/*
this subclass represents a Savings Account.
it inherits the base info and adds a specific 'interestRate'.
*/
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    /* method to specify the account type and
       display subclass-specific data.
    */
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        displayBaseInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("------------------------------------------");
    }
}

/*
this subclass represents a Checking Account.
it adds a 'withdrawalLimit' to handle transaction restrictions.
*/
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayBaseInfo();
        System.out.println("Daily Withdrawal Limit: $" + withdrawalLimit);
        System.out.println("------------------------------------------");
    }
}

/*
this subclass represents a Fixed Deposit Account.
it adds 'maturityPeriod' to track the investment duration.
*/
class FixedDepositAccount extends BankAccount {
    int maturityMonths;

    FixedDepositAccount(String accountNumber, double balance, int maturityMonths) {
        super(accountNumber, balance);
        this.maturityMonths = maturityMonths;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        displayBaseInfo();
        System.out.println("Maturity Period: " + maturityMonths + " months");
        System.out.println("------------------------------------------");
    }
}

/*
the driver class demonstrates the one-to-many relationship
between the superclass and its various subclasses.
*/
public class BankingHierarchy{
    public static void main(String[] args) {
        // creating different types of accounts
        SavingsAccount sa = new SavingsAccount("SA-1001", 5000.0, 4.5);
        CheckingAccount ca = new CheckingAccount("CA-2002", 2500.0, 1000.0);
        FixedDepositAccount fd = new FixedDepositAccount("FD-3003", 10000.0, 12);

        System.out.println("--- Bank Account Management System ---");

        // each object calls its own version of displayAccountType()
        sa.displayAccountType();
        ca.displayAccountType();
        fd.displayAccountType();
    }
}