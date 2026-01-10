package ControlFlowProblems.Level2;
import java.util.Scanner;
import java.lang.Math;
public class GreatestFactorFor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number whose greatest factor needs to be found");
        int n = scanner.nextInt();
        if(n<=0){
            System.out.println("Invalid Input");
            return;
        }
        int greatestFactor = 1;
        for(int i = 1; i<n;++i){
            if(n%i == 0){
                greatestFactor = Math.max(greatestFactor,i);
            }
        }
        System.out.println("The greatest factor of "+n+" is "+greatestFactor);
    }
}
