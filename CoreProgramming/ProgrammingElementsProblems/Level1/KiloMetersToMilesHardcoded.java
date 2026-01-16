package ProgrammingElementsProblems.Level1;
/*
 * This class converts a hardcoded distance in kilometers to miles.
 * It uses the conversion factor where 1 mile is approximately 1.6 kilometers,
 * performing a division operation and displaying the result formatted to
 * two decimal places.
 */
public class KiloMetersToMilesHardcoded{
  public static void main(String[] args){
    float km = 10.8f;

    // Calculates the miles by dividing the kilometers by the conversion factor (1.6)
    float miles = km / 1.6f;

    // Displays the input and the result with two-decimal point precision
    System.out.printf("The Distance %.2f Km in miles is %.2f",km,miles);
  }
}
