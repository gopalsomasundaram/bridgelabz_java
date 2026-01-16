package controlflows.Level3;
import java.util.Scanner;
/*
 * This class determines if a year is a Leap Year using a single conditional statement.
 * It combines the three rules of the Gregorian Calendar:
 * 1. Divisible by 4 AND NOT divisible by 100...
 * 2. OR divisible by 400.
 */
public class LeapYearSingleIf {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the year:");
        int year = scanner.nextInt();
        // The logic follows the Order of Operations (Parentheses first)
        // Rule A: (year % 4 == 0 && year % 100 != 0) -> Standard Leap Year
        // Rule B: (year % 400 == 0) -> Century Leap Year exception
        if((year%4==0 && year %100 != 0)||(year%400==0)){
            System.out.println("It is a leap year");
        }
        else{
            System.out.println("It is not a leap year");
        }
    }
}
