package programmingelements.Level1;

import java.util.Scanner;
/*
 * This class converts a distance measurement from feet to yards and miles.
 * It reads an integer input for feet, divides by 3 to find yards,
 * and then divides the yard value by 1760 to determine the distance in miles.
 */
public class YardMiles{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the distance in feet:");
    int feet = scanner.nextInt();

    // Converts feet to yards by dividing by the constant 3.0
    float yard = (float)feet/3.0f;

    // Converts yards to miles by dividing by the constant 1760.0
    float miles = yard/1760.0f;

    // Displays the distance in all three units formatted to one decimal place
    System.out.printf("Distance in feet is %d, in yard %.1f and in miles %.1f",feet,yard,miles);
  }
}
