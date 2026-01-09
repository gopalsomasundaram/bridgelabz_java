import java.util.Scanner;

public class CalcSimpleInterest{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the principal:");
    float principal = scanner.nextFloat();
    System.out.println("Enter the interest rate:");
    float rate = scanner.nextFloat();
    System.out.println("Enter the time:");
    float time= scanner.nextFloat();
    float simpleInterest = ((principal*rate*time)/100.0f);
    System.out.printf("The Simple Interes is %.1f for principal %.1f, Rate of Interest %.1f and Time %.1f",simpleInterest,principal,rate,time);
  }
}
