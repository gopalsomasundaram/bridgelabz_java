package ProgrammingElementsProblems.Level2;
/*
 * This class converts a temperature from Fahrenheit to Celsius.
 * It reads a double input, subtracts 32, and then multiplies by the
 * fraction 5/9 to determine the Celsius equivalent.
 */
import java.util.Scanner;
public class TemperatureConverterFarenheitToCelsius {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    double farenheit = scanner.nextDouble();
    System.out.println("Enter the temperature in farenheit:");

    // Subtracts 32 and multiplies by 5/9 to convert to Celsius
    double celsiusResult = ((farenheit-32)*(5.0/9.0));

    // Formats and displays both temperatures to one decimal place
    System.out.printf("The %.1f farenheit is %.1f celsiusResult",farenheit,celsiusResult);
  }
}
