package programmingelements.level2;

import java.util.Scanner;
/*
 * This class calculates the quotient and remainder of two user-provided integers.
 * It uses type casting to convert integer inputs into floats, ensuring that
 * the division result maintains decimal precision for the output.
 */
public class QuotientAndRemainder{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the first number:");
    int n1 = scanner.nextInt();

    System.out.println("Enter the second number:");
    int n2 = scanner.nextInt();

    // Calculates the quotient by casting integers to floats to allow decimal results
    float quo = (float)n1/(float)n2;

    // Calculates the remainder using the modulo operator on the float-casted values
    float rem = (float)n1%(float)n2;

    // Formats and displays the quotient, remainder, and original numbers in a single string
    System.out.printf("The Quotient is %.1f and Reminder is %.1f of two number %d and %d",quo,rem,n1,n2);
  }
}
