package ProgrammingElementsProblems.Level1;
/*
 * This class converts a user-inputted distance in kilometers to miles.
 * It reads an integer value for kilometers, applies the conversion factor
 * (1.6 km per mile) through division, and outputs the result using
 * string concatenation.
 */
import java.util.Scanner;
public class KiloMetersToMilesInput{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter hte distance in kilometers:");
    int km = scanner.nextInt();

    // Converts kilometers to miles by dividing by 1.6, casting km to float for precision
    float mi = (float)km/1.6f;

    // Concatenates the original input and the calculated result into a final message
    System.out.println("The total miles is "+mi+" mile for the given "+km+" km");
  }
}
