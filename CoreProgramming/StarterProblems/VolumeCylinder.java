package StarterProblems;

import java.util.Scanner;
/*
 * This class calculates the volume of a cylinder given its radius and height.
 * It utilizes the mathematical formula V = π * r² * h, making use of
 * Java's Math.PI constant and Math.pow method for high-precision calculations.
 */
public class VolumeCylinder{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter radius of cylinder");
    float radius = Float.parseFloat(scanner.nextLine());

    System.out.println("Enter height of cylinder");
    float height = Float.parseFloat(scanner.nextLine());

    // Calculates volume using PI times radius squared times height
    double volume = Math.PI * (Math.pow(radius,2)) * (double)height;

    // Outputs the final volume calculation formatted to two decimal places
    System.out.printf("The volume of the cylinder is %.2f",volume);
  }
}
