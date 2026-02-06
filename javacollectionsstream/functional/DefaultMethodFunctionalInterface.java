/**
 * This Program implements a custom functional interface with
 * a default method for auxiliary functionality.
 * * @author gopal
 */
package functional;

@FunctionalInterface
interface SquareCalculator {
    // The single abstract method (SAM)
    int calculate(int n);

    // Default method: provides a reusable implementation inside the interface
    default void displayResult(int input, int result) {
        System.out.println("The square of " + input + " is: " + result);
    }
}

public class DefaultMethodFunctionalInterface {
    public static void main(String[] args) {
        // Lambda implementation of the calculate method
        SquareCalculator sc = n -> n * n;

        int num = 6;
        int res = sc.calculate(num);
        // Calling the default method from the instance
        sc.displayResult(num, res);
    }
}