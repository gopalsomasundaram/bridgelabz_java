import java.util.Scanner;

public class MaxHandshakes{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of students:");
    int numStudents = scanner.nextInt();
    int result = ((numStudents*(numStudents-1))/2);
    System.out.println("Max possible number of handhakes is:"+result);
  }
}
