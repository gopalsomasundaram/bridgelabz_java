package ProgrammingElementsProblems.Level1;

import java.util.Scanner;
/*
 * This class converts a height measurement from centimeters to feet and inches.
 * It first converts centimeters to total inches, then divides that value
 * to find the total feet, displaying the results via string concatenation.
 */
public class CentimeterToFeet {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter centimeter value");
    int height = scanner.nextInt();

    // Converts centimeters to inches by dividing by the constant 2.54
    float inches = ((float)height/2.54f);

    // Converts the total inches into feet by dividing by 12
    float feet = inches/(float)12;

    // Concatenates the original height and the calculated units for display
    System.out.println("you Height in cm is "+height+" while in feet is "+feet+" and inches is "+inches);
  }
}
