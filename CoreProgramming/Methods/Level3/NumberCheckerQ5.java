package Methods.Level3;
import java.util.Scanner;
/*
 * This class checks for several special number types in mathematics.
 * It demonstrates how digit manipulation can be used to identify
 * Spy, Neon, Automorphic, and Buzz numbers.
 */
public class NumberCheckerQ5 extends NumberCheckerBase{
    // Prime Number: Only divisible by 1 and itself
    boolean isPrime(int n){
        for(int i = 2;i<n;++i){
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
    // Spy Number: Sum of digits == Product of digits
    boolean isSpyNumber(int n){
        int[] arr = getDigits(n,countDigits(n));
        int sum = 0;
        int product = 1;
        for(int i : arr){
            sum+=i;
            product *= i;
        }
        return sum == product;
    }
    // Neon Number: Sum of digits of its square == The number itself
    boolean isNeon(int n){
        int sqrd = (int)(Math.pow(n,2));
        int[] digits = getDigits(sqrd,countDigits(sqrd));
        int sum = 0;
        for(int i : digits){
            sum+=i;
        }
        return sum == n;
    }
    // Automorphic Number: The square ends with the number itself
    boolean isAutoMorphic(int n){
        int square = (int)(Math.pow(n,2));
        if(square%10 == n){
            return true;
        }
        return false;
    }
    // Buzz Number: Ends with 7 or is divisible by 7
    boolean isBuzzNumber(int n){
        return (n%7 == 0 || n %10 == 7);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = scanner.nextInt();
        NumberCheckerQ5 obj = new NumberCheckerQ5();
        // Logical outputs
        if(obj.isPrime(n)) {
            System.out.println("It is a prime number");
        }
        else{
            System.out.println("It is not a prime number");
        }
        if(obj.isNeon(n)) {
            System.out.println("It is a neon number");
        }
        else{
            System.out.println("It is not a neon number");
        }
        if(obj.isSpyNumber(n)) {
            System.out.println("It is a spy number");
        }
        else{
            System.out.println("It is not a spy number");
        }
        if(obj.isAutoMorphic(n)) {
            System.out.println("It is a automorphic number");
        }
        else{
            System.out.println("It is not a automorphic number");
        }
        if(obj.isBuzzNumber(n)) {
            System.out.println("It is a buzz number");
        }
        else{
            System.out.println("It is not a buzz number");
        }
        scanner.close();
    }
}
