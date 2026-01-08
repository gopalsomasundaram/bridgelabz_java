import java.util.Scanner;

public class SimpleInterest{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the Principal:");
    float principal = Float.parseFloat(scanner.nextLine());
    System.out.println("Enter the rate:");
    float rate = Float.parseFloat(scanner.nextLine());
    System.out.println("Enter the time:");
    float time= Float.parseFloat(scanner.nextLine());
    float interest = (principal* time* rate)/100;
    System.out.printf("The interest is %.2f",interest);
  }
}
