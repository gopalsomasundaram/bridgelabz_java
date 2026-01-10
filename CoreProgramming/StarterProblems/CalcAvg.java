package StarterProblems;

import java.util.Scanner;

public class CalcAvg{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number: ");
    int i = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter the second number: ");
    int j = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter the thirst number: ");
    int k = Integer.parseInt(scanner.nextLine());
    float avg = (i+j+k)/3;
    System.out.println("The average of the three given numbers is "+avg);
  }
}
