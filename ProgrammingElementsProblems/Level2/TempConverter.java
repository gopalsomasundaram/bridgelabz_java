import java.util.Scanner;
public class TempConverter{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    double celsius = scanner.nextDouble();
    double farenheitResult = ((celsius*(9.0/5.0))+32);
    System.out.printf("The %.1f celsius is %.1f farenheit",celsius,farenheitResult);
  }
}
