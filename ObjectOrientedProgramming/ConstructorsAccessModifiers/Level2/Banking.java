package ConstructorsAccessModifiers.Level2;
/*
this class is the base class for this program and contains private,
protected and public variables to be used to apply access
modifier concepts
 */
class BankAccount{
    //three types of attributes
    public int accountNumber;
    protected String accountHolder;
    private int balance;

    //default constructor
    BankAccount(){
        this.accountNumber = 123123;
        this.accountHolder = "John Doe";
        this.balance = 6700;
    }

    //parameterized constructor
    BankAccount(int accountNumber, String accountHolder, int balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    int getBalance(){
        return balance;
    }

    void setBalance(int balance){
        this.balance = balance;
        System.out.println("Balance of "+accountHolder+"'s account has been set to "+this.balance);
    }
}
/*
this is the subclass for this program,
here we
*/
class SavingsAccount extends BankAccount{
    //method to display data
    void displayData(){
        System.out.println("account holder: "+accountHolder);
        System.out.println("account number: "+accountNumber);
        System.out.println("balace :"+this.getBalance());
    }
    //method to change accessible attributes from super class
    void demonstrateAccess(){
        this.accountNumber = 456456;
        System.out.println("The account number has been changed to: "+accountNumber);
        this.accountHolder="Adam williams";
        System.out.println("The account holder has been changed to: "+accountHolder);
    }
}

public class Banking {
    public static void main(String[] args){
        //obj creation (subclass)
        SavingsAccount obj = new SavingsAccount();

        //display data before invoking access approved changes
        obj.displayData();

        //applying data changes to obj instance
        obj.demonstrateAccess();
        obj.setBalance(8000);

        //verifying application of changes
        obj.displayData();
    }
}
