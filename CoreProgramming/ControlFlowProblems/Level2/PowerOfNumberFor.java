package ControlFlowProblems.Level2;

import java.util.Scanner;
public class PowerOfNumberFor {
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
        for(int i = 0;i<power;++i){
            result*=base;
        }
        System.out.println("The result is "+result);
    }
}
