package Methods.Level2;

import java.util.Scanner;
public class StudentVoteChecker {
    public boolean canStudentVote(int age){
        if(age < 18) return false;
        else return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        boolean[] canVote = new boolean[10];
        System.out.println("Enter the age of 10 students");
        StudentVoteChecker obj = new StudentVoteChecker();
        for(int i = 0;i<10;++i){
            arr[i] = scanner.nextInt();
            canVote[i] = obj.canStudentVote(arr[i]);
        }
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