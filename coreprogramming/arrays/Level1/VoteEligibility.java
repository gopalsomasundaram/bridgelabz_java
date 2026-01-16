package arrays.Level1;

import java.util.Scanner;
/*
 * This class collects the ages of 10 students and determines their
 * eligibility to vote based on the legal age of 18.
 * It includes basic validation to catch negative (invalid) age inputs.
 */
public class VoteEligibility {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //Array Initialization
        int[] arr = new int[10];
        //Data Entry
        for(int i = 0;i<arr.length;++i){
            System.out.printf("Enter the age of students at index %d: ",i);
            arr[i] = scanner.nextInt();
        }

        //Eligibility Logic
        for (int j : arr) {
            //Validation
            if (j < 0) System.out.println("Invalid Age");
            //Eligibility (threshold of 18)
            else if (j >= 18) System.out.printf("The student with the age %d can vote\n", j);
            //Ineligibility
            else System.out.printf("The Student with age %d cannot vote\n",j);
        }
        scanner.close();
    }
}
