/**
 * This program demonstrates Exception Propagation in Java.
 * It shows how an exception thrown in a deeply nested method (method1)
 * travels back through the calling methods (method2) to the main method,
 * where it is finally caught and handled.
 *
 * @author gopal;
 */
package exceptionhandling;

public class ExceptionPropogationDemo {

    /**
     * Method where the actual exception occurs.
     * Since ArithmeticException is an Unchecked exception, it does not
     * need to be declared in the method signature.
     */
    public static void method1() {
        // Division by zero triggers an ArithmeticException
        int temp = 10 / 0;
    }

    /**
     * Intermediate method that calls the risky method.
     * Note that this method does not contain a try-catch block,
     * so it simply "passes the buck" to its caller.
     */
    public static void method2() {
        method1();
    }

    public static void main(String[] args) {
        try {
            // main calls method2, which calls method1
            method2();

        } catch (ArithmeticException e) {
            /* * Even though the error happened in method1, the exception
             * bubbled up the call stack to be handled here.
             */
            System.out.println("Exception caught! Handling exception in main.");
            System.out.println("Original cause: " + e.getMessage());
        }
    }
}