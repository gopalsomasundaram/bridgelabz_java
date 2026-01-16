package controlflows.Level2;

import java.util.Scanner;
/*
 * This class compares the age and height of three individuals: Amar, Akbar, and Anthony.
 * It uses nested if-else structures to determine the youngest person (minimum age)
 * and the tallest person (maximum height) through sequential comparison.
 */
public class YoungestTallest{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    // Data Input for age
    System.out.println("Enter the age of Amar:");
    int ageAmar = scanner.nextInt();
    System.out.println("Enter the age of Akbar:");
    int ageAkbar = scanner.nextInt();
    System.out.println("Enter the age of Anthony:");
    int ageAnthony = scanner.nextInt();

    // Data Input for Heights
    System.out.println("Enter the height of Amar:");
    int heightAmar = scanner.nextInt();
    System.out.println("Enter the height of Akbar:");
    int heightAkbar = scanner.nextInt();
    System.out.println("Enter the height of Anthony:");
    int heightAnthony = scanner.nextInt();

    //Logic for Finding the Youngest
    if(ageAmar<ageAkbar){
      if(ageAmar<ageAnthony){
        System.out.println("Amar is the youngest");
      }else{
        System.out.println("Anthony is the youngest");
      }
    }else{
      if(ageAkbar<ageAnthony){
        System.out.println("Akbhar is the youngest");
      }else{
        System.out.println("Anthony is the youngest");
      }
    }
    //Logic for Finding the Tallest
    if(heightAmar>heightAkbar){
      if(heightAmar>heightAnthony){
        System.out.println("Amar is the tallest");
      }else{
        System.out.println("Anthony is the tallest");
      }
    }else{
      if(heightAkbar>heightAnthony){
        System.out.println("Akbhar is the tallest");
      }else{
        System.out.println("Anthony is the tallest");
      }
    }
  }
}
