/**
 * This Program uses the Consumer functional interface to process
 * list elements with a specific action.
 * * @author gopal
 */
package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "cpp", "python", "arch linux");

        // Consumer interface takes one argument and returns nothing (void)
        // Here it defines how to print each string in uppercase
        Consumer<String> upperCasePrinter = s -> System.out.println(s.toUpperCase());

        // forEach accepts a Consumer to apply the action to every element
        list.forEach(upperCasePrinter);
    }
}