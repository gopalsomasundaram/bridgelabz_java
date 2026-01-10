package ProgrammingElementsProblems.Level1;

import java.util.Scanner;
public class PerimeterSquare{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter side of square:");
    int side = scanner.nextInt();
    System.out.println("The length of the side is "+side+" whose perimeter is "+(4*side));
  }
}
