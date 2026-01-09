import java.util.Scanner;
public class KiloMetersToMilesInput{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int km = scanner.nextInt();
    float mi = (float)km/1.6f;
    System.out.println("The total miles is "+mi+" mile for the given "+km+" km");
  }
}
