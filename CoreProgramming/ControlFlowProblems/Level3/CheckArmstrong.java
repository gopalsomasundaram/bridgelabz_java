package ControlFlowProblems.Level3;

import java.util.Scanner;
import java.lang.Math;
public class CheckArmstrong {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to be checked if armstrong:");
        int n = scanner.nextInt();
        int copy = n;
        double sum = 0;
        while(copy!=0){
            int digit = copy%10;
            sum += Math.pow(digit,3);
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
