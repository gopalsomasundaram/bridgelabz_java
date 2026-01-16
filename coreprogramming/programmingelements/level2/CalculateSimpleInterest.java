package programmingelements.level2;

import java.util.Scanner;
/*
 * This class calculates the Simple Interest based on user-provided inputs.
 * It takes the principal amount, interest rate, and time period,
 * then applies the standard formula: (Principal * Rate * Time) / 100.
 * The results are displayed with single decimal precision.
 */
public class CalculateSimpleInterest {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the principal:");
    float principal = scanner.nextFloat();

    System.out.println("Enter the interest rate:");
    float rate = scanner.nextFloat();

    System.out.println("Enter the time:");
    float time= scanner.nextFloat();

    // Calculates interest by multiplying the parameters and dividing by the percentage base
    float simpleInterest = ((principal*rate*time)/100.0f);

    // Displays the interest and all input variables formatted to one decimal place
    System.out.printf("The Simple Interes is %.1f for principal %.1f, Rate of Interest %.1f and Time %.1f",simpleInterest,principal,rate,time);
  }
}
