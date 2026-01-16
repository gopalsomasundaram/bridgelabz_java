package methods.level1;

import java.util.Scanner;
/*
 * This class uses a method to determine the sign of a number.
 * It maps input values to a specific "status code":
 * -1 for Negative, 0 for Zero, 1 for Positive.
 */
public class CheckNumberSymbol {
    //numChecker analyzes the integer 'n'
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

        // Decoding the result back into human-readable text
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
