package ProgrammingElementsProblems.Level1;
/*
 * This class calculates the age of a person (Harry) based on a
 * fixed birth year and a specific current year. It performs a
 * subtraction operation to find the difference and displays the result.
 */
public class HarryAge{
  public static void main(String[] args){
    int birthYear = 2000;
    int currentYear = 2024;

    // Calculates the age by finding the difference between years and prints the output
    System.out.println("Harry's age in 2024 is "+(currentYear-birthYear));
  }
};
