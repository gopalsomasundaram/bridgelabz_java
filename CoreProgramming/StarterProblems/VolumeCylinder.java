package StarterProblems;

import java.util.Scanner;
public class VolumeCylinder{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter radius of cylinder");
    float radius = Float.parseFloat(scanner.nextLine());
    System.out.println("Enter height of cylinder");
    float height = Float.parseFloat(scanner.nextLine());
    double volume = Math.PI * (Math.pow(radius,2)) * (double)height;
    System.out.printf("The volume of the cylinder is %.2f",volume);
  }
}
