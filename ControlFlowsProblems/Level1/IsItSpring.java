import java.util.Scanner;
public class IsItSpring{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the month(number):");
    int month = scanner.nextInt();
    System.out.println("Enter the day(number):");
    int day= scanner.nextInt();
    if(month == 3 && day >=20){
      System.out.println("Its a Spring Season");
      return;
    }else if(month == 6 && day <= 20){
      System.out.println("Its a Spring Season");
      return;
    }else if(month>3 && month<6){
      System.out.println("Its a Spring Season");
      return;
    }else{
      System.out.println("Not a Spring Season");
    }
  }
}
