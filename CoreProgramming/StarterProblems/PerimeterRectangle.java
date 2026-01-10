package StarterProblems;

import java.util.Scanner;

public class PerimeterRectangle{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the length of the rectangle");
    float length = Float.parseFloat(scanner.nextLine());
    System.out.println("Enter the breadth of the rectangle");
    float breadth = Float.parseFloat(scanner.nextLine());
    float perimeter = 2 * (length + breadth);
    System.out.printf("the perimeter is %.1f\n",perimeter);
  }
}
