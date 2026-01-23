package stacksqueueshashmaps;

import java.util.HashSet;

/*
this class checks if there exists a pair of elements in an array
that adds up to a specific target sum. it uses a hash set to
achieve $O(N)$ time complexity by checking for the complement
of each element as it traverses the list.
*/
public class PairWithSum {

    //method to check if a pair exists
    public boolean hasPair(int[] arr, int target) {
        //hash set to store visited numbers
        HashSet<Integer> visited = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            //if complement is in set, pair is found
            if (visited.contains(complement)) {
                System.out.println("Pair found: " + num + ", " + complement);
                return true;
            }
            //add current number to set
            visited.add(num);
        }
        return false;
    }

    //main function to test pair existence logic
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, -6, 9, 11};
        int target = 4;
        PairWithSum obj = new PairWithSum();
        if (!obj.hasPair(arr, target)) {
            System.out.println("No pair found with the given target sum.");
        }
    }
}