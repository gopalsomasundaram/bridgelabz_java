package programmingelements.level2;

import java.util.Scanner;
/*
 * This class calculates the total income of an individual.
 * It takes two integer inputs: salary and bonus, then performs
 * an addition operation to display the combined total in INR.
 */
public class TotalIncome{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the salary:");
    int salary = scanner.nextInt();
    System.out.println("Enter the bonus:");
    int bonus = scanner.nextInt();

    // Performs an addition of salary and bonus while concatenating the result into a final string
    System.out.println("The salary is INR "+salary+" and the bonus is INR "+bonus+". Hence Total Income is INR "+(salary+bonus));
  }
}
