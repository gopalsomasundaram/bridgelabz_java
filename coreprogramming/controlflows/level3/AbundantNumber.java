package controlflows.level3;

import java.util.Scanner;
/*
 * This class determines if a number is an "Abundant Number."
 * An Abundant Number is one where the sum of its proper divisors
 * (excluding itself) is strictly greater than the number.
 * Example: 12 (Divisors: 1, 2, 3, 4, 6. Sum = 16. 16 > 12, so it is Abundant).
 */
public class AbundantNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to be checked if Abundant:");
        int n = scanner.nextInt();
        //Ensures the input is a positive integer
        if(n<=0){
            System.out.println("Invalid Input");
            return;
        }
        int sum = 0;
        // Iterates from 1 up to (but not including) n to find proper divisors
        for(int i=1;i<n;i++){
            // If i divides n perfectly, it's a divisor
            if(n%i==0){
                sum+=i;
            }
        }
        //final: Is the sum of divisors greater than the original number?
        if(sum>n){
            System.out.println(n+" is an abundant number");
        }else{
            System.out.println(n+" is not an abundant number");
        }
    }
}
