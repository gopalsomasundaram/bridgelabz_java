package Arrays.Level1;

import java.util.Scanner;
/*
 * This class partitions numbers from 0 to n-1 into two separate arrays.
 * It uses the modulo operator to determine parity and maintains
 * independent indices for both the 'odd' and 'even' arrays.
 */
public class OddEvenArrays {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = scanner.nextInt();

        // Since roughly half of numbers are even and half are odd,
        // (n/2)+1 ensures enough space for both cases.
        int[] odd = new int[(n/2)+1];
        int[] even= new int[(n/2)+1];

        //Independent Index Management
        int even_index = 0;
        int odd_index = 0;
        for(int i = 0;i<n;i++){
            if(i%2==0){
                // Number is even; store in even array and increment its index
                even[even_index++]=i;
            }else{
                // Number is odd; store in odd array and increment its index
                odd[odd_index++]=i;
            }
        }
        System.out.println("The Odd array is:");

        //Displaying the results
        for(int i = 0;i<odd.length;++i){
            System.out.println(odd[i]);
        }

        //Displaying the results
        System.out.println("The Even array is:");
        for(int i = 0;i<even.length;++i){
            System.out.println(even[i]);
        }
        scanner.close();
    }
}
