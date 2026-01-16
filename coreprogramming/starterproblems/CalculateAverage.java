package starterproblems;

import java.util.Scanner;
/*
 * This class calculates the arithmetic average of three integers.
 * It prompts the user for three inputs, performs the summation and division,
 * and displays the resulting float value to the console.
 */
public class CalculateAverage{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the first number: ");
    int i = Integer.parseInt(scanner.nextLine());

    System.out.println("Enter the second number: ");
    int j = Integer.parseInt(scanner.nextLine());

    System.out.println("Enter the thirst number: ");
    int k = Integer.parseInt(scanner.nextLine());

    // Sums the three integers and divides by 3 to find the average
    float avg = (i+j+k)/3;

    // Displays the final result with a descriptive string concatenation
    System.out.println("The average of the three given numbers is "+avg);
  }
}
