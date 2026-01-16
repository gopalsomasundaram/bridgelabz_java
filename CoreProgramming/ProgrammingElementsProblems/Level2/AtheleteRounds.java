package ProgrammingElementsProblems.Level2;

import java.util.Scanner;
/*
 * This class calculates the number of rounds an athlete needs to run
 * around a triangular perimeter to complete a total distance of 5 km.
 * It takes three side lengths as input, calculates the perimeter,
 * and determines the rounds required.
 */
public class AtheleteRounds{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the first side:");
    int side1 = scanner.nextInt();

    System.out.println("Enter the second side:");
    int side2 = scanner.nextInt();

    System.out.println("Enter the third side:");
    int side3 = scanner.nextInt();
    // Calculates the total perimeter of the triangular track by summing the sides
    float perimeter = (float)side1 + (float)side2 + (float)side3;

    // Calculates the number of rounds needed to reach the 5 km goal
    float rounds = 5.0f/perimeter;

    // Displays the calculated rounds formatted to one decimal place
    System.out.printf("The total number of rounds the athlete will run is %.1f to complete 5 km",rounds);
  }
}
