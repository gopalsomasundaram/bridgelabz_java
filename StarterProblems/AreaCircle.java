import java.util.Scanner;
public class AreaCircle{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the radius of circle whose area needs to be calculated:");
    int radius = Integer.parseInt(scanner.nextLine());
    double area = Math.PI * (Math.pow(radius,2));
    System.out.printf("The area is %.2f",area);
  }
}
