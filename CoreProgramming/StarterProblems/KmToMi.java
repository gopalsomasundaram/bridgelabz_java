package StarterProblems;

import java.util.Scanner;

public class KmToMi{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the distance in Kilometers:");
    float km = Float.parseFloat(scanner.nextLine());
    float miles = km * 0.621371f;
    System.out.printf("The distance in miles is %.2f",miles);
  }
}
