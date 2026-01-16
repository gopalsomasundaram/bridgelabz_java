package Methods.Level1;
import java.util.Scanner;
/*
 * This class uses a static method to perform integer division.
 * It returns an array where:
 * Index 0 = The number of chocolates each child receives (Quotient)
 * Index 1 = The remaining chocolates (Remainder)
 */
public class DivideChocolates {
    public static int[] findRemainderAndQuotient(int number, int divisor){
        int[] arr = new int[2];
        // Integer division
        arr[0] = number/divisor;
        // Modulo operator
        arr[1] = number%divisor;
        return arr;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of chocolates:");
        int numberOfChocolates = scanner.nextInt();
        System.out.println("Enter the number of children:");
        int numberOfChildren= scanner.nextInt();
        // Calling the static method directly
        int[] arr = findRemainderAndQuotient(numberOfChocolates,numberOfChildren);
        System.out.println("each child gets "+arr[0]+" chocolates and the remainder is "+arr[1]);
        scanner.close();
    }
}
