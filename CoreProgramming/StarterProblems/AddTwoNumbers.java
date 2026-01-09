import java.util.Scanner;

public class AddTwoNumbers{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number");
    float a = Float.parseFloat(scanner.nextLine());
    System.out.println("Enter the second number");
    float b = Float.parseFloat(scanner.nextLine());
    System.out.printf("Sum of two numbers is: %.2f",a+b);
  }
}
