import java.util.Scanner;
public class SumItUpTill0{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the numbers to be added one by one, enter 0 to stop and get result");
    int sum = 0;
    int userInp = scanner.nextInt();
    while(userInp!=0){
      sum+=userInp;
      userInp = scanner.nextInt();
    }
    System.out.println("The sum is "+sum);
  }
}
