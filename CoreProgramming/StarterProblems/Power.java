package StarterProblems;
import java.util.Scanner;
import java.lang.Math;
/*
 * This class calculates the result of a base number raised to a specific exponent.
 * It uses the Math.pow() method to perform the calculation based on two
 * integer inputs provided by the user and displays the result as a float.
 */
public class Power{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the base number: ");
    int x = Integer.parseInt(scanner.nextLine());

    System.out.println("Enter the exponent number: ");
    int y = Integer.parseInt(scanner.nextLine());

    // Calculates the power using Math.pow and prints the result formatted to one decimal place
    System.out.printf("result: %.1f",Math.pow(x,y));
  }
}
