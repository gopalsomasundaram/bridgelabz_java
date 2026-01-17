package ClassAndObject.Level2;
/*
 * This class models a Bank Account with basic transactional logic.
 * It demonstrates state modification and conditional checks (validation).
 */
public class BankAccount {
    //attributes
    String accountHolder = "John Doe";
    int accountNumber = 12345;
    int balance = 10000;
    //Modify balance by adding
    void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Deposited Amount : " + amount);
    }
    //Modify balance by removing
    void withdraw(int amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn Amount : " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
    //get/show balance
    void displayBalance() {
        System.out.println("Current Balance : " + balance);
    }

    public static void main(String[] args) {
        //Instantiation
        BankAccount obj = new BankAccount();

        obj.displayBalance();
        obj.deposit(2000);
        obj.withdraw(3000);
        obj.displayBalance();
    }
}
