package ProgrammingElementsProblems.Level2;

import java.util.Scanner;
public class ChocolatesChildren{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of chocolates:");
    int numberOfChocolates = scanner.nextInt();
    System.out.println("Enter the number of children:");
    int numberOfChildren= scanner.nextInt();
    int perChild = numberOfChocolates/numberOfChildren;
    int leftover = numberOfChocolates%numberOfChildren;
    System.out.println("The number of chocolates each child gets is "+perChild+" and the number of remaining chocolates are "+leftover);
  }
}
