package ControlFlowProblems.Level2;
import java.util.Scanner;
import java.lang.Math;
/*
 * This class finds the greatest factor of a number 'n' excluding the number itself.
 * It iterates from 1 up to n-1 and uses the Math.max() function to update
 * the greatest divisor found so far.
 */
public class GreatestFactorUsingFor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number whose greatest factor needs to be found");
        int n = scanner.nextInt();
        //Prevents processing of non-positive integers
        if(n<=0){
            System.out.println("Invalid Input");
            return;
        }
        int greatestFactor = 1;
        // Loop from 1 up to n-1 to find all proper factors
        for(int i = 1; i<n;++i){
            // Check if 'i' is a factor of 'n'
            if(n%i == 0){
                // Logic: Compare the current greatest factor with the new factor found
                greatestFactor = Math.max(greatestFactor,i);
            }
        }
        System.out.println("The greatest factor of "+n+" is "+greatestFactor);
    }
}
