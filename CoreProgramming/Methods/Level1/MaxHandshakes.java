package Methods.Level1;

import java.util.Scanner;
/*
 * This class calculates the maximum number of handshakes among 'n' students.
 * The logic follows the triangular number pattern (n-1) + (n-2) + ... + 1.
 */
public class MaxHandshakes {
    int calcMaxHandshakes(int n ){
        // Formula: n * (n - 1) / 2
        return ((n*(n-1))/2);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int n = scanner.nextInt();
        // Object creation to access the instance method
        MaxHandshakes myObj = new MaxHandshakes();
        int result = myObj.calcMaxHandshakes(n);
        System.out.println("The max number of hanshakes is: "+result);
        scanner.close();
    }
}
