/**
 * This Program implements Predicate composition to combine multiple
 * boolean conditions for filtering.
 * * @author gopal
 */
package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateComposition {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Strawberry", "Banana", "Watermelon", "Kiwi");

        // Condition 1: Length must be > 5
        Predicate<String> lengthCheck = s -> s.length() > 5;
        // Condition 2: Must contain the substring "berry"
        Predicate<String> contentCheck = s -> s.contains("berry");

        System.out.println("Words longer than 5 and containing 'berry':");
        // Using lengthCheck.and(contentCheck) to combine logic
        words.stream()
                .filter(lengthCheck.and(contentCheck))
                .forEach(System.out::println);
    }
}