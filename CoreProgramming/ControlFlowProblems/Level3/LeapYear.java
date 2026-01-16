package ControlFlowProblems.Level3;
import java.util.Scanner;
/*
 * This class determines if a year is a Leap Year based on the following rules:
 * 1. A year is a leap year if it is divisible by 4.
 * 2. However, if it is divisible by 100, it is NOT a leap year UNLESS...
 * 3. It is also divisible by 400.
 */
public class LeapYear {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the year:");
        int year = scanner.nextInt();
        // Step 1: Check if divisible by 4
        if(year%4 == 0){
            // Step 2: Check if it's a century year (like 1900 or 2000)
            if(year % 100 == 0){
                // Step 3: Century years must be divisible by 400 to be leap years
                if(year%400 == 0){
                    System.out.println("It is a Leap year");
                }else{
                    System.out.println("It is not a Leap year");
                }
            }
            // Divisible by 4 but not by 100 (e.g., 2024)
            else{
                System.out.println("It is a Leap year");
            }
        }
        else
        {
            // Not divisible by 4 at all (e.g., 2023)
            System.out.println("It is not a Leap year");
        }
    }
}
