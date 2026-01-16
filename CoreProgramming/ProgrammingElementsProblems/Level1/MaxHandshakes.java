package ProgrammingElementsProblems.Level1;

import java.util.Scanner;
/*
 * This class calculates the maximum number of unique handshakes possible
 * among a specific number of students provided by the user.
 * It uses the handshake formula (n * (n - 1)) / 2 to determine the
 * total combinations.
 */
public class MaxHandshakes{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the number of students:");
    int numStudents = scanner.nextInt();

    // Calculates handshakes by multiplying students by (students-1) and dividing by 2
    int result = ((numStudents*(numStudents-1))/2);

    // Displays the calculated result using string concatenation
    System.out.println("Max possible number of handhakes is:"+result);
  }
}
