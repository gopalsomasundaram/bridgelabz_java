package ClassAndObject.Level2;

public class BankAccount {
    String accountHolder = "John Doe";
    int accountNumber = 12345;
    int balance = 10000;

    void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Deposited Amount : " + amount);
    }

    void withdraw(int amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn Amount : " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance : " + balance);
    }

    public static void main(String[] args) {
        BankAccount obj = new BankAccount();

        obj.displayBalance();
        obj.deposit(2000);
        obj.withdraw(3000);
        obj.displayBalance();
    }
}
