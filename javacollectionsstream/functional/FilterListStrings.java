/**
 * This Program uses the Stream API to filter a list based on
 * string prefix conditions.
 * * @author gopal
 */
package functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterListStrings {
    public static void main(String[] args) {
        // Initial list of strings
        List<String> names = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Apricot");

        // filter(): keeps elements that return false for startsWith("A")
        // collect(): converts the stream back into a List
        List<String> filteredNames = names.stream()
                .filter(name -> !name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Strings not starting with 'A': " + filteredNames);
    }
}