import java.util.Scanner;
public class ForCountdown{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number to countdown from:");
    int n = scanner.nextInt();
    for(int i = n;i!=1;i--){
      System.out.println(i);
    }
  }
}
