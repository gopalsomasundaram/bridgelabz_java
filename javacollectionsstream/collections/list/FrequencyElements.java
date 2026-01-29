package collections.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FrequencyElements {
    /**
     * Calculates the frequency of each unique string in a list.
     * Uses a HashMap for O(1) average-time lookups.
     */
    public static HashMap<String, Integer> printFrequency(List<String> arr){
        // Initialize a HashMap where the Key is the word and Value is the count
        HashMap<String, Integer> frequency = new HashMap<>();

        // Iterate through each element in the input list
        for(String i : arr){
            // Check if the element has already been encountered
            if(frequency.containsKey(i)){
                // If present, increment the existing count by 1
                frequency.put(i, frequency.get(i) + 1);
            }
            else{
                // If first time seeing the element, initialize count to 1
                frequency.put(i, 1);
            }
        }
        // Return the map containing the frequency of all elements
        return frequency;
    }

    public static void main(String[] args){
        // Create a fixed-size list and pass it to the frequency calculator
        List<String> input = Arrays.asList("apple", "orange", "apple", "banana", "banana");
        HashMap<String, Integer> frequency = printFrequency(input);

        // Print the final key-value pairs (order is not guaranteed in HashMap)
        System.out.println(frequency);
    }
}