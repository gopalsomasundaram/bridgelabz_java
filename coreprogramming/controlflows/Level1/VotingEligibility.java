package controlflows.Level1;

import java.util.Scanner;
/*
 * This class determines a person's eligibility to vote based on their age.
 * It uses a simple if-else control structure to compare the input age
 * against the legal voting threshold of 18.
 */
public class VotingEligibility{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the persons age:");
    int age = scanner.nextInt();

    // Evaluates if the age meets or exceeds the minimum requirement of 18
    if(age>=18){
      System.out.println("The person's age is "+age+" and they can vote");
    }
    else{
      // Executes if the condition is false (i.e., age is 17 or younger)s
      System.out.println("The perso'n age is "+age+" and they cannot vote");
    }
  }
}
