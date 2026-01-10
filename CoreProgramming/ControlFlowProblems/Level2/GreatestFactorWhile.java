package ControlFlowProblems.Level2;

import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number whose greatest factor needs to be found");
        int n = scanner.nextInt();
        if(n<=0){
            System.out.println("Invalid Input");
            return;
        }
        int greatestFactor = 1;
        int i = 1;
        while(i<n) {
            if (n % i == 0) {
                greatestFactor = Math.max(greatestFactor, i);
            }
            i++;
        }
        System.out.println("The greatest factor of "+n+" is "+greatestFactor);
    }
}
