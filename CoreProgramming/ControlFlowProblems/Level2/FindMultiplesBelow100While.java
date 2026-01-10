package ControlFlowProblems.Level2;

import java.util.Scanner;

public class FindMultiplesBelow100While {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to find multiples of");
        int n = scanner.nextInt();
        if(n<=0 || n > 100){
            System.out.println("Invalid Input");
            return;
        }
        int i = 100;
        while(i-1>0){
            i--;
            if(n%i==0){
                System.out.println(i);
                continue;
            }else if(i%n == 0){
                System.out.println(i);
                continue;
            }
        }
    }
}
