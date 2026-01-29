package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Removes duplicates from a list by manually checking if an element
 * already exists in a new 'result' list.
 */
public class RemoveDuplicates {

    public static List<Integer> removeDuplicates(List<Integer> arr){
        // Initialize a new list to store unique elements
        List<Integer> result = new ArrayList<>();

        // Iterate through each integer in the input list
        for(int i : arr){
            // If the element is already in our result list, skip it
            if(result.contains(i)){
                continue;
            } else {
                // Otherwise, add the new unique element to the result list
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        // Convert an array of integers with duplicates into a List and process it
        List<Integer> arr = removeDuplicates(Arrays.asList(1, 1, 4, 4, 2, 3));

        // Print the final list (Expected: [1, 4, 2, 3])
        System.out.println(arr);
    }
}