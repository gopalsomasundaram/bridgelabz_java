package Methods.Level2;

import java.util.Scanner;
public class LeapYear {
    boolean isLeap(int year){
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
