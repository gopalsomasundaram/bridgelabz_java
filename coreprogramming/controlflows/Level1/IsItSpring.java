package controlflows.Level1;

import java.util.Scanner;
/*
 * This class determines if a given date (month and day) falls within the Spring season.
 * Spring is defined as the period from March 20 to June 20.
 * The program uses conditional branches to check the start month, the end month,
 * and the full months in between.
 */
public class IsItSpring{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the month(number):");
    int month = scanner.nextInt();
    System.out.println("Enter the day(number):");
    int day= scanner.nextInt();

    // Checks the start of Spring: March (Month 3) from day 20 onwards
    if(month == 3 && day >=20){
      System.out.println("Its a Spring Season");
      return;
    }
    // Checks the end of Spring: June (Month 6) up to day 20
    else if(month == 6 && day <= 20){
      System.out.println("Its a Spring Season");
      return;
    }
    // Checks the peak of Spring: Any day in April (4) or May (5)
    else if(month>3 && month<6){
      System.out.println("Its a Spring Season");
      return;
    }
    // Executes if the date falls outside the March 20 - June 20 range
    else{
      System.out.println("Not a Spring Season");
    }
  }
}
