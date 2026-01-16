package ControlFlowProblems.Level3;

import java.util.Scanner;
import java.lang.Math;
/*
 * This class determines if a 3-digit number is an Armstrong number.
 * It uses a while loop to extract digits from the end of the number
 * and adds the cube of each digit to a running sum.
 */
public class CheckArmstrong {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to be checked if armstrong:");
        int n = scanner.nextInt();

        //We create a copy of 'n' because we will be destroying it
        int copy = n;
        double sum = 0;

        // Loop runs until all digits have been processed
        while(copy!=0){
            //Extract the last digit using modulo 10
            int digit = copy%10;
            //Cube the digit and add to the sum
            sum += Math.pow(digit,3);
            //Remove the last digit using integer division
            copy/=10;
        }
        if(sum == (double)n)
        {
            System.out.println("It is an armstrong number");
        }
        else
        {
            System.out.println("It is not an armstrong number");
        }
    }
}
