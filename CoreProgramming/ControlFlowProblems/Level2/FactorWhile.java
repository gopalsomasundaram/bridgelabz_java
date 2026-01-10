package ControlFlowProblems.Level2;

import java.util.Scanner;
public class FactorWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to find factors of:");
        int n = scanner.nextInt();
        if(n<=0){
            System.out.println("Invalid Input");
            return;
        }
        int i = 1;
        while(i!=n){
            if(n%i==0){
                System.out.println(i);
            }
            i++;
        }
    }
}
