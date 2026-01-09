import java.util.Scanner;
public class TempConverterToCelsius{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    double farenheit = scanner.nextDouble();
    double celsiusResult = ((farenheit-32)*(5.0/9.0));
    System.out.printf("The %.1f farenheit is %.1f celsiusResult",farenheit,celsiusResult);
  }
}
