package controlflows.level2;

import java.util.Scanner;
/*
 * This class identifies the greatest proper factor of an integer 'n'
 * (the largest divisor excluding the number itself) using a while loop.
 * It utilizes Math.max to track the highest factor found during the scan.
 */
public class GreatestFactorUsingWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number whose greatest factor needs to be found");
        int n = scanner.nextInt();
        //Rejects non-positive integers
        if(n<=0){
            System.out.println("Invalid Input");
            return;
        }
        int greatestFactor = 1;
        int i = 1;
        //iterates through all numbers starting from 1 up to n-1
        while(i<n) {
            // Check if 'i' divides 'n' with no remainder
            if (n % i == 0) {
                // Updates greatestFactor if the current 'i' is larger
                greatestFactor = Math.max(greatestFactor, i);
            }
            i++;
        }
        System.out.println("The greatest factor of "+n+" is "+greatestFactor);
    }
}
