package Methods.Level1;

import java.util.Scanner;
public class CheckNumberSymbol {
    int numChecker(int n){
        if(n<0) return -1;
        if(n>0) return 1;
        else return 0;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to be checked: ");
        int n = scanner.nextInt();
        CheckNumberSymbol myObj = new CheckNumberSymbol();
        int result = myObj.numChecker(n);
        if(result == 0){
            System.out.println("Number is zero");
        }else if(result == 1){
            System.out.println("Number is positive");
        }else{
            System.out.println("Number is negative");
        }
        scanner.close();
    }
}
