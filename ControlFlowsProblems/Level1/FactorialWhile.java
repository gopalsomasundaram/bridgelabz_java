import java.util.Scanner;
public class FactorialWhile{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number whose factorial needs to be found:");
    int n = scanner.nextInt();
    if(n<0){
      System.out.println("Invalid Input");
      return;
    }
    int result = 1;
    while(n>0){
      result*=n;
      n--;
    }
    System.out.println("The factorial of given number is "+result);
  }
}
