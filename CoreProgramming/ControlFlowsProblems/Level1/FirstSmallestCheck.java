import java.util.Scanner;

public class FirstSmallestCheck{
  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number:");
    int n1 = scanner.nextInt();
    System.out.println("Enter the second number:");
    int n2 = scanner.nextInt();
    System.out.println("Enter the third number:");
    int n3 = scanner.nextInt();
    if((n1<n2)&&(n1<n3)){
      System.out.println("Is the first number the smallest? yes");
    }else{
      System.out.println("Is the first number the smallest? no");
    }
  }
}
