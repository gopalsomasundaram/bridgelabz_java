import java.util.Scanner;
public class PrintOddOrEven{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter natural number:");
    int n = scanner.nextInt();
    if(n<0){
      System.out.println("Invalid Input");
      return;
    }
    for(int i = 0;i<=n;++i){
      if(i%2==0){
        System.out.println("Even");
      }else{
        System.out.println("Odd");
      }
    }
  }
}
