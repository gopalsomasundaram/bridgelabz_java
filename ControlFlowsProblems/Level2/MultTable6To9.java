import java.util.Scanner;
public class MultTable6To9{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number:");
    int n = scanner.nextInt();
    for(int i = 6;i<=9;++i){
      System.out.println(n+" * "+i+" = "+(n*i));
    }
  }
}
