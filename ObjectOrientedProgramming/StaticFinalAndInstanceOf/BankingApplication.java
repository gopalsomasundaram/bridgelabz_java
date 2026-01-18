package StaticFinalAndInstanceOf;
/*
this class is used to depict the use of keywords such as
static - to make sure the member / method belongs to the object and none else
final = to make sure value of member doesn't change after it has been assigned
we use the example of bank account system where bankname is static and constructor
is used to count the total number of accounts, also returned by a static method
*/
class BankAccount{
    //static members
    static String bankName = "people's national bank";
    static int countAccounts = 0;

    //instance members
    String accountHolderName;
    final int accountNumber;

    //default constructor
    BankAccount(){
        countAccounts++;
        accountNumber = 12345;
        accountHolderName = "John Doe";
    }

    //parameterized constructor
    BankAccount(String accountHolderName, int accountNumber){
        countAccounts++;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    //method to get number of accounts
    static int getTotalAccount(){
        return countAccounts;
    }

    //method to display the details of account
    void displayData(){
        System.out.println("account Holder's name: "+accountHolderName);
        System.out.println("account number: "+accountNumber);
    }

}
/*
in this class we write the main function to control the creation and
use of class objects to invoke methods, we also use instanceOf operator
to make sure that created object is made from inteded class
*/
public class BankingApplication {
    public static void main(String[] args){
        //obj creation
        BankAccount test1 = new BankAccount();

        //using instanceof operator to check if object uses certain class
        if(test1 instanceof BankAccount){
            System.out.println("created object is an instance of BankAccount");
        }

        //creating a second object
        BankAccount test2 = new BankAccount();

        System.out.println("Total number of accounts:"+BankAccount.getTotalAccount());

        test2.displayData();
    }
}
