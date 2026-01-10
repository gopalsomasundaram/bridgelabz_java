package ControlFlowProblems.Level2;

import java.util.Scanner;
public class FactorFor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to find factors of:");
        int n = scanner.nextInt();
        if(n<=0){
            System.out.println("Invalid Input");
            return;
        }
        for(int i = 1; i<n;++i){
            if(n%i == 0){
                System.out.println(i);
            }
        }
    }
}
