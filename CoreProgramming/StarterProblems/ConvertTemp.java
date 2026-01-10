package StarterProblems;

import java.util.Scanner;

public class ConvertTemp{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the temperature in celsius:");
    float cel = Float.parseFloat(scanner.nextLine());
    float faren = (cel * 9/5)+32;
    System.out.println("The temperature is "+faren+" in farenheit");
  }
}
