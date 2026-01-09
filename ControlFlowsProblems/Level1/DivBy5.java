import java.util.Scanner;
public class DivBy5{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number:");
    int n = scanner.nextInt();
    boolean result;
    if(n%5 == 0){
      System.out.println("Is the number "+n+" divisible by 5? yes");
    }else{
      System.out.println("Is the number "+n+" divisible by 5? no");
    }
  }
}
