package StarterProblems;

import java.util.Scanner;
/*
 * This class calculates the simple interest based on user-provided values.
 * It takes inputs for the principal amount, interest rate, and time period,
 * then applies the formula (P * T * R) / 100 to determine the interest.
 */
public class SimpleInterest{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the Principal:");
    float principal = Float.parseFloat(scanner.nextLine());

    System.out.println("Enter the rate:");
    float rate = Float.parseFloat(scanner.nextLine());

    System.out.println("Enter the time:");
    float time= Float.parseFloat(scanner.nextLine());

    // Calculates simple interest using the formula: (Principal * Time * Rate) / 100
    float interest = (principal* time* rate)/100;

    // Displays the calculated interest formatted to two decimal places
    System.out.printf("The interest is %.2f",interest);
  }
}
