package ControlFlowProblems.Level2;

import java.util.Scanner;
public class YoungestTallest{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the age of Amar:");
    int ageAmar = scanner.nextInt();
    System.out.println("Enter the age of Akbar:");
    int ageAkbar = scanner.nextInt();
    System.out.println("Enter the age of Anthony:");
    int ageAnthony = scanner.nextInt();
    System.out.println("Enter the height of Amar:");
    int heightAmar = scanner.nextInt();
    System.out.println("Enter the height of Akbar:");
    int heightAkbar = scanner.nextInt();
    System.out.println("Enter the height of Anthony:");
    int heightAnthony = scanner.nextInt();
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
