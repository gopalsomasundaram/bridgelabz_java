package methods.level2;

import java.util.Scanner;
/*
 * This class determines if a year is a leap year.
 * Rule: A year is a leap year if it is divisible by 4 but not by 100,
 * unless it is also divisible by 400.
 */
public class LeapYear {
    // Method to check leap year status
    boolean isLeap(int year){
        // Logic: (Divisible by 4 AND not by 100) OR (Divisible by 400)
        if((year%4==0 && year%100!=0)|| year%400==0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the year to be checked:");
        int year = scanner.nextInt();
        //The Gregorian calendar started in 1582
        if(year<1582){
            System.err.println("years less than 1582 cannot be verified using this program");
            System.exit(-1);
        }
        LeapYear obj = new LeapYear();
        boolean result = obj.isLeap(year);
        if(result){
            System.out.println("It is a leap year");
        }
        else{
            System.out.println("It is not a leap year");
        }
    }
}
