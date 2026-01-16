package controlflows.Level2;

import java.util.Scanner;
/*
 * This class identifies and prints all the proper factors of a given number.
 * It uses a for loop to test every integer from 1 up to (but not including) n,
 * using the modulo operator to check for divisibility.
 */
public class FactorUsingFor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to find factors of:");
        int n = scanner.nextInt();

        //Ensures the input is a positive integer
        if(n<=0){
            System.out.println("Invalid Input");
            return;
        }
        // Iterates through all numbers from 1 to n-1
        for(int i = 1; i<n;++i){
            // Logic: If n divided by i has a remainder of 0, then i is a factor
            if(n%i == 0){
                System.out.println(i);
            }
        }
    }
}
