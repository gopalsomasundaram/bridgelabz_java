package ControlFlowProblems.Level3;

import java.util.Scanner;
public class Marks {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter physics marks:");
        float physics = scanner.nextFloat();
        System.out.println("Enter chemistry marks:");
        float chemistry = scanner.nextFloat();
        System.out.println("Enter math marks:");
        float math = scanner.nextFloat();
        float percentage = ((math+physics+chemistry)/3);
        System.out.println("Average Marks= "+percentage);
        if(percentage>=80){
            System.out.println("Grade: A");
            System.out.println("Remarks: Level 4, Above agency-normalized standards");
            return;
        }
        else if(percentage>=70 && percentage<=79)
        {
            System.out.println("Grade: B");
            System.out.println("Remarks: Level 3, At agency-normalized standards");
            return;
        }else if(percentage>=60 && percentage<=69)
        {
            System.out.println("Grade: C");
            System.out.println("Remarks: Level 2, Below, but approaching agency-normalized standards");
            return;
        }else if(percentage>=50 && percentage<=59)
        {
            System.out.println("Grade: D");
            System.out.println("Remarks: Level 1, Well below agency-normalized standards");
            return;
        }
        else if(percentage>=40 && percentage <= 49){
            System.out.println("Grade: E");
            System.out.println("Remarks: Level 1, Too below agency-normalized standards");
            return;
        }else{//<=39%
            System.out.println("Grade: R");
            System.out.println("Remarks: Remedial Standards");
        }
    }
}
