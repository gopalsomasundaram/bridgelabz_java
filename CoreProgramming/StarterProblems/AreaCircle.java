package StarterProblems;

import java.util.Scanner;
/*
 * Program: AreaCircle
 * Description: Calculates the area of a circle based on an integer radius
 * provided by the user using the formula: Area = π * r^2.
 */
public class AreaCircle{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the radius of circle whose area needs to be calculated:");
    // Read input as String and parse to int
    int radius = Integer.parseInt(scanner.nextLine());
    // Calculate area using the constant Math.PI and the power function for the radius
    double area = Math.PI * (Math.pow(radius,2));
    System.out.printf("The area is %.2f",area);
  }
}
