package ProgrammingElementsProblems.Level1;

import java.util.Scanner;
public class CmToFt{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter centimeter value");
    int height = scanner.nextInt();
    float inches = ((float)height/2.54f);
    float feet = inches/(float)12;
    System.out.println("you Height in cm is "+height+" while in feet is "+feet+" and inches is "+inches);
  }
}
