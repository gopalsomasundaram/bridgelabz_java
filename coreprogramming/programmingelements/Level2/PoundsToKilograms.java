package programmingelements.Level2;

import java.util.Scanner;
/*
 * This class converts weight from pounds to kilograms based on user input.
 * It reads a float value representing pounds, divides it by the
 * conversion factor (2.2), and displays the result formatted to
 * one decimal place.
 */
public class PoundsToKilograms{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the weight in pounds:");
    float pounds = scanner.nextFloat();

    // Calculates the weight in kilograms by dividing the pounds by 2.2
    float kilograms = (pounds/2.2f);

    // Formats and displays both the input weight and the calculated conversion
    System.out.printf("The weight of the person in pound is %.1f and in kg is %.1f",pounds,kilograms);
  }
}
