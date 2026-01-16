package Methods.Level1;
/*
 * This class calculates the quotient and remainder of two integers.
 * It uses a static method to return both values encapsulated in an array.
 */
import java.util.Scanner;
public class QuotientAndRemainder {
    // Method to calculate both values
    public static int[] findRemainderAndQuotient(int number, int divisor){
        int[] arr = new int[2];
        arr[0] = number/divisor;
        arr[1] = number%divisor;
        return arr;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int number = scanner.nextInt();
        System.out.println("Enter the divisor:");
        int divisor = scanner.nextInt();
        // Calling the method - No object needed because it is static
        int[] arr = findRemainderAndQuotient(number,divisor);
        System.out.println("the Quitient is "+arr[0]+" the remainder is "+arr[1]);
        scanner.close();
    }
}
