/**
 * This Program implements a custom functional interface to perform
 * addition using a lambda expression.
 * * @author gopal
 */
package functional;

/**
 * Functional interface with a single abstract method for math operations.
 */
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        // Implementing the interface using a lambda (takes two ints, returns sum)
        MathOperation addition = (a, b) -> a + b;

        // Executing the functional method
        int result = addition.operate(10, 20);
        System.out.println("Sum using custom functional interface: " + result);
    }
}