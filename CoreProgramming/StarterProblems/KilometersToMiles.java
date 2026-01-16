package StarterProblems;

import java.util.Scanner;

/*
 * This class converts a distance measurement from kilometers to miles.
 * The program takes a floating-point input from the user, multiplies it
 * by the conversion factor (0.621371), and outputs the result formatted
 * to two decimal places.
 */
public class KilometersToMiles{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the distance in Kilometers:");
    float km = Float.parseFloat(scanner.nextLine());

    // Multiplies the kilometer input by the constant conversion factor for miles
    float miles = km * 0.621371f;

    // Prints the formatted result, limiting the miles output to 2 decimal places
    System.out.printf("The distance in miles is %.2f",miles);
  }
}
