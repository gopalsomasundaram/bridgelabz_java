package ControlFlowProblems.Level2;

import java.util.Scanner;
/*
 * This class identifies all integers between 1 and 100 that are either
 * multiples of the input 'n' or factors of 'n'. It uses a reverse for-loop
 * and two-way modulo checks to find these relationships.
 */
public class MultiplesBelowHundredUsingFor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to find multiples of");
        int n = scanner.nextInt();

        //Restricts the input to a valid range
        if(n<=0 || n > 100){
            System.out.println("Invalid Input");
            return;
        }

        // Iterates backwards from 100 down to 1
        for(int i = 100;i>0;--i){
            // Logic A: Checks if 'i' is a FACTOR of 'n' (n divided by i has no remainder)
            if(n%i==0){
                System.out.println(i);
                continue;
            }
            // Logic B: Checks if 'i' is a MULTIPLE of 'n' (i divided by n has no remainder)
            else if(i%n == 0){
                System.out.println(i);
                continue;
            }
        }
    }
}
