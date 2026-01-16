package ControlFlowProblems.Level1;

import java.util.Scanner;
/*
 * This class verifies the sum of the first 'n' natural numbers by comparing
 * the results of a mathematical formula against a manual 'while' loop.
 * It ensures the input is a valid natural number before performing
 * the calculations.
 */
public class CompareNaturalSumsWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the natural number:");
        int n = scanner.nextInt();

        // Guard clause: Checks if the input is negative and exits if it is not a natural number
        if(n < 0){
            System.out.println("Not a natural number");
            return;
        }

        // Calculates the sum using the constant-time formula: (n * (n + 1)) / 2
        int formula = ((n*(n+1))/2);

        int manual = 0;
        int i = 0;

        // Iterates as long as the condition (i <= n) remains true
        while(i<=n){
            // Adds the current value of i to the running total
            manual+=i;
            i++;
        }
        // Compares the manual total with the formula result using an equality check
        if(manual == formula){
            System.out.println("both the results are same "+manual);
        }else{
            System.out.println("both the results are different, manual="+manual+" and formula="+formula);
        }
    }
}
