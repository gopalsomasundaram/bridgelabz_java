package ControlFlowProblems.Level3;

import java.util.Scanner;
/*
 * This class determines if a number is a Harshad Number.
 * It extracts each digit, calculates their sum, and then checks
 * if the original number is divisible by that sum.
 */
public class HarshadNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number to be checked if Harshad Number:");
        int n = scanner.nextInt();
        int sum = 0;
        int copy = n;

        //Sum the digits
        while(copy!=0){
            // Extract the last digit
            int digit = copy%10;
            // Add digit to running total
            sum+=digit;
            // Remove the last digit
            copy/=10;
        }
        // A number n is Harshad if n % (sum of digits) == 0
        if(n%sum==0){
            System.out.println(n+" is a Harshad number");
        }else{
            System.out.println(n+" is not a Harshad number");
        }
    }
}
