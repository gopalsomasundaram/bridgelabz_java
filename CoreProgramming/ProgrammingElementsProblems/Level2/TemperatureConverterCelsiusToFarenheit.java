package ProgrammingElementsProblems.Level2;
/*
 * This class converts a temperature from Celsius to Fahrenheit.
 * It takes a double input for Celsius and applies the standard conversion
 * formula: (Celsius * 9/5) + 32, then displays the result formatted to
 * one decimal place.
 */
import java.util.Scanner;
public class TemperatureConverterCelsiusToFarenheit {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the temperature in celsius:");
    double celsius = scanner.nextDouble();

    // Applies the conversion formula using 9.0/5.0 to maintain decimal precision
    double farenheitResult = ((celsius*(9.0/5.0))+32);

    // Formats and displays both Celsius and Fahrenheit values to one decimal point
    System.out.printf("The %.1f celsius is %.1f farenheit",celsius,farenheitResult);
  }
}
