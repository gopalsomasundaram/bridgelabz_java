package ControlFlowProblems.Level2;

import java.util.Scanner;

public class PowerOfNumberWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the base number:");
        int base = scanner.nextInt();
        System.out.println("Enter the exponent number:");
        int power = scanner.nextInt();
        if(base < 0 && power < 0){
            System.out.println("Invalid Input");
            return;
        }
        int result = 1;
        int i = 0;
        while(i<power){
            result*=base;
            i++;
        }
        System.out.println("The result is "+result);
    }
}
