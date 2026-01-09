import java.util.Scanner;

public class AtheleteRounds{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first side:");
    int side1 = scanner.nextInt();
    System.out.println("Enter the second side:");
    int side2 = scanner.nextInt();
    System.out.println("Enter the third side:");
    int side3 = scanner.nextInt();
    float perimeter = (float)side1 + (float)side2 + (float)side3;
    float rounds = 5.0f/perimeter;
    System.out.printf("The total number of rounds the athlete will run is %.1f to complete 5 km",rounds);
  }
}
