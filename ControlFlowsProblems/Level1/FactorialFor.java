import java.util.Scanner;
public class FactorialFor{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number whose factorial needs to be found:");
    int n = scanner.nextInt();
    if(n<0){
      System.out.println("Invalid Input");
      return;
    }
    int result = 1;
    for(int i =1;i<=n;++i){
      result*=i;
    }
    System.out.println("The factorial is "+result);
  }
}
