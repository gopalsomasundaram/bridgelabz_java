package Arrays.Level1;

import java.util.Scanner;
public class VoteEligibility {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0;i<arr.length;++i){
            System.out.printf("Enter the age of students at index %d: ",i);
            arr[i] = scanner.nextInt();
        }
        for (int j : arr) {
            if (j < 0) System.out.println("Invalid Age");
            else if (j >= 18) System.out.printf("The student with the age %d can vote\n", j);
            else System.out.printf("The Student with age %d cannot vote\n",j);
        }
        scanner.close();
    }
}
