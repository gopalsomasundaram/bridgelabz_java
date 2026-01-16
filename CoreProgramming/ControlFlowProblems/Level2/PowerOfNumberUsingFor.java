package ControlFlowProblems.Level2;

import java.util.Scanner;
/*
 * This class calculates the power of a number (base^power) using iterative multiplication.
 * It uses a for-loop to multiply the base by itself 'power' number of times.
 */
public class PowerOfNumberUsingFor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the base number:");
        int base = scanner.nextInt();
        System.out.println("Enter the exponent number:");
        int power = scanner.nextInt();

        //Prevents calculations for certain negative scenarios
        if(base < 0 && power < 0){
            System.out.println("Invalid Input");
            return;
        }
        int result = 1;
        // The loop runs exactly 'power' times
        for(int i = 0;i<power;++i){
            // Logic: result = result * base (repeated multiplication)
            result*=base;
        }
        System.out.println("The result is "+result);
    }
}
