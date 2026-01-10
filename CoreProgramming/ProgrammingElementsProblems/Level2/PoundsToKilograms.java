package ProgrammingElementsProblems.Level2;

import java.util.Scanner;
public class PoundsToKilograms{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the weight in pounds:");
    float pounds = scanner.nextFloat();
    float kilograms = (pounds/2.2f);
    System.out.printf("The weight of the person in pound is %.1f and in kg is %.1f",pounds,kilograms);
  }
}
