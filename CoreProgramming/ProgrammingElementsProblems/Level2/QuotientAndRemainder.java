import java.util.Scanner;

public class QuotientAndRemainder{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number:");
    int n1 = scanner.nextInt();
    System.out.println("Enter the second number:");
    int n2 = scanner.nextInt();
    float quo = (float)n1/(float)n2;
    float rem = (float)n1%(float)n2;
    System.out.printf("The Quotient is %.1f and Reminder is %.1f of two number %d and %d",quo,rem,n1,n2);
  }
}
