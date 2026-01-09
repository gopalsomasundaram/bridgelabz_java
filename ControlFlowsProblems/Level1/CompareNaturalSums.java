import java.util.Scanner;
public class CompareNaturalSums{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the natural number:");
    int n = scanner.nextInt();
    if(n < 0){
      System.out.println("Not a natural number");
      return;
    }
    int formula = ((n*(n+1))/2);
    int manual = 0;
    for(int i = 0;i<=n;i++){
      manual+=i;
    }
    if(manual == formula){
      System.out.println("both the results are same "+manual);
    }else{
      System.out.println("both the results are different, manual="+manual+" and formula="+formula);
    }
  }
}
