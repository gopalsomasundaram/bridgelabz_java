import java.util.Scanner;
public class FizzBuzz{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number:");
    int n = scanner.nextInt();
    if(n<0){
      System.out.println("Invalid Input");
      return;
    }
    for(int i = 0;i<=n;++i){
      if((i%3==0)&&(i%5==0)){
        Console.WriteLine("FizzBuzz");
        continue;
      }else if(i%3==0){
        Console.WriteLine("Fizz");
        continue;
      }else if(i % 5 == 0){
        Console.WriteLine("Buzz");
        continue;
      }else{
        Console.WriteLine(i);
      }
    }
  }
}
