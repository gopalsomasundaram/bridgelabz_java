import java.util.Scanner;

public class YardMiles{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the distance in feet:");
    int feet = scanner.nextInt();
    float yard = (float)feet/3.0f;
    float miles = yard/1760.0f;
    System.out.printf("Distance in feet is %d, in yard %.1f and in miles %.1f",feet,yard,miles);
  }
}
