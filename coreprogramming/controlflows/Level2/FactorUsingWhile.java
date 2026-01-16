package controlflows.Level2;

import java.util.Scanner;
/*
 * This class identifies all proper factors of a positive integer using a while loop.
 * It manually increments a counter 'i' and checks for divisibility using the
 * modulo operator (%) until the counter reaches the input number 'n'.
 */
public class FactorUsingWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to find factors of:");
        int n = scanner.nextInt();
        //Ensures the program only processes positive integers
        if(n<=0){
            System.out.println("Invalid Input");
            return;
        }
        int i = 1;
        // Loop runs as long as the counter 'i' has not reached the input 'n'
        while(i!=n){
            if(n%i==0){
                // Check if 'i' divides 'n' perfectly with no remainder
                System.out.println(i);
            }
            i++;
        }
    }
}
