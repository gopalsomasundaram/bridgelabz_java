package ControlFlowProblems.Level3;

import java.util.Scanner;
public class CheckPrime {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to check if prime:");
        int n = scanner.nextInt();
        if(n<1){
            System.out.println("Invalid Input");
            return;
        }
        boolean isPrime = true;
        for(int i =2;i<n;++i){
            if(n%i==0){
                isPrime = false;
                break;
            }
        }
        if(isPrime)
        {
            System.out.println("Given number is a prime");
        }else{
            System.out.println("Given number is not a prime");
        }
    }
}
