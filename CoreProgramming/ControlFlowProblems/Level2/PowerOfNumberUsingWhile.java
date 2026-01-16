package ControlFlowProblems.Level2;

import java.util.Scanner;
/*
 * This class calculates the power of a number (base raised to power) using
 * a while loop. It performs repeated multiplication of the base,
 * continuing until the counter reaches the exponent value.
 */
public class PowerOfNumberUsingWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the base number:");
        int base = scanner.nextInt();

        System.out.println("Enter the exponent number:");
        int power = scanner.nextInt();

        //Prevents logic issues with simultaneous negative inputs
        if(base < 0 && power < 0){
            System.out.println("Invalid Input");
            return;
        }
        int result = 1;
        int i = 0;
        // Loop runs as long as the counter is less than the desired exponent
        while(i<power){
            // Multiplies the current result by the base in each step
            result*=base;
            i++;
        }
        System.out.println("The result is "+result);
    }
}
