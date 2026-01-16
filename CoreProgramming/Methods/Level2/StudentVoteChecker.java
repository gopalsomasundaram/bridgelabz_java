package Methods.Level2;

import java.util.Scanner;
/*
 * This class determines voting eligibility for a group of students.
 * It uses a boolean method for the logic and parallel arrays to store
 * the input ages and their corresponding eligibility status.
 */
public class StudentVoteChecker {
    // Method to check if a single age meets the requirement
    public boolean canStudentVote(int age){
        if(age < 18) return false;
        else return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Parallel arrays: index i in 'arr' matches index i in 'canVote'
        int[] arr = new int[10];
        boolean[] canVote = new boolean[10];
        System.out.println("Enter the age of 10 students");
        StudentVoteChecker obj = new StudentVoteChecker();
        //Input and Logic Processing
        for(int i = 0;i<10;++i){
            arr[i] = scanner.nextInt();
            canVote[i] = obj.canStudentVote(arr[i]);
        }
        //Output Display
        for(int i = 0;i<10;++i){
            if(canVote[i]){
                System.out.println("Student of age "+arr[i]+" can vote");
            }else{
                System.out.println("Student of age "+arr[i]+" cannot vote");
            }
        }
        scanner.close();
    }
}