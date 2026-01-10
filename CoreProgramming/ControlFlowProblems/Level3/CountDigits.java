package ControlFlowProblems.Level3;
import java.util.Scanner;
public class CountDigits {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        int count=0;
        while(n!=0)
        {
            count++;
            n/=10;
        }
        System.out.println("Number of digits in given number = "+count);
    }
}
