import java.util.Scanner;

public class calc{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number:");
    int num1 = scanner.nextInt();
    System.out.println("Enter the second number:");
    int num2 = scanner.nextInt();
    int add = num1+num2;
    int subtract = num1-num2;
    int multiply = num1*num2;
    int divide = num1/num2;
    System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+num1+" and "+num2+" is "+add+", "+subtract+", "+multiply+", and "+divide);
  }
}
