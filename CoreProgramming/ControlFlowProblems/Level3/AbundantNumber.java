package ControlFlowProblems.Level3;

import java.util.Scanner;
public class AbundantNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to be checked if Abundant:");
        int n = scanner.nextInt();
        if(n<=0){
            System.out.println("Invalid Input");
            return;
        }
        int sum = 0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        if(sum>n){
            System.out.println(n+" is an abundant number");
        }else{
            System.out.println(n+" is not an abundant number");
        }
    }
}
