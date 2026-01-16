package ProgrammingElementsProblems.Level1;

import java.util.Scanner;
/*
 * This class calculates the perimeter of a square based on the length
 * of one side provided by the user. It applies the geometric formula
 * P = 4 * side and outputs the results to the console.
 */
public class PerimeterSquare{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter side of square:");
    int side = scanner.nextInt();

    // Performs multiplication and string concatenation to display both the side and the perimeter
    System.out.println("The length of the side is "+side+" whose perimeter is "+(4*side));
  }
}
