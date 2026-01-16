package controlflows.level3;

import java.util.Scanner;
/*
 * This class determines if a given integer is a prime number.
 * A prime number is a natural number greater than 1 that has
 * no positive divisors other than 1 and itself.
 */
public class CheckPrime {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to check if prime:");
        int n = scanner.nextInt();

        // Prime numbers are defined as greater than 1.
        if(n<1){
            System.out.println("Invalid Input");
            return;
        }
        boolean isPrime = true;

        // Loop from 2 up to n-1 to find any potential divisors.
        for(int i =2;i<n;++i){
            if(n%i==0){
                // Logic: If n is divisible by any i, it is not prime.
                isPrime = false;// "Flag" the number as not prime.
                break;
            }
        }
        // Use the boolean "flag" to determine the final output.
        if(isPrime)
        {
            System.out.println("Given number is a prime");
        }else{
            System.out.println("Given number is not a prime");
        }
    }
}
