package controlflows.level1;
import java.util.Scanner;
/*
 * This class identifies if a user-provided integer is positive,
 * negative, or zero. It demonstrates basic control flow logic
 * using conditional statements to direct the program execution
 * path based on the value of the input.
 */
public class CheckSymbol{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter number:");
    int num = scanner.nextInt();

    // Evaluates the input to check if it is exactly equal to zero
    if(num == 0){
      System.out.println("zero");
    }
    // Checks if the number is less than zero if the first condition was false
    else if(num < 0){
      System.out.println("negative");
    }
    // Executes if the number is neither zero nor negative
    else{
      System.out.println("positive");
    }
  }
}
