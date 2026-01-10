package StarterProblems;

import java.util.Scanner;
import java.lang.Math;
public class Power{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the base number: ");
    int x = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter the exponent number: ");
    int y = Integer.parseInt(scanner.nextLine());
    System.out.printf("result: %.1f",Math.pow(x,y));
  }
}
