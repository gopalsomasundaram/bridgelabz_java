import java.util.Scanner;
public class VotingEligibility{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the persons age:");
    int age = scanner.nextInt();
    if(age>=18){
      System.out.println("The person's age is "+age+" and they can vote");
    }
    else{
      System.out.println("The perso'n age is "+age+" and they cannot vote");
    }
  }
}
