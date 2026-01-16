package starterproblems;

import java.util.Scanner;
/*
 * This class calculates the perimeter of a rectangle.
 * It accepts the length and breadth as user inputs, applies the
 * formula P = 2 * (length + breadth), and prints the result
 * formatted to one decimal place.
 */
public class PerimeterRectangle{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the length of the rectangle");
    float length = Float.parseFloat(scanner.nextLine());

    System.out.println("Enter the breadth of the rectangle");
    float breadth = Float.parseFloat(scanner.nextLine());

    // Calculates the perimeter by adding dimensions and doubling the sum
    float perimeter = 2 * (length + breadth);

    // Displays the calculated perimeter with single decimal precision
    System.out.printf("the perimeter is %.1f\n",perimeter);
  }
}
