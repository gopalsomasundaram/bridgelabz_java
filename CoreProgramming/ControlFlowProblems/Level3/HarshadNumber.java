package ControlFlowProblems.Level3;

import java.util.Scanner;
public class HarshadNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number to be checked if Harshad Number:");
        int n = scanner.nextInt();
        int sum = 0;
        int copy = n;
        while(copy!=0){
            int digit = copy%10;
            sum+=digit;
            copy/=10;
        }
        if(n%sum==0){
            System.out.println(n+" is a Harshad number");
        }else{
            System.out.println(n+" is not a Harshad number");
        }
    }
}
