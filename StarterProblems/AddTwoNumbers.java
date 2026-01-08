import java.util.Scanner;

public class AddTwoNumbers{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number");
    int a = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter the second number");
    int b = Integer.parseInt(scanner.nextLine());
    System.out.println("Sum of two numbers is: "+(a+b));
  }
}
