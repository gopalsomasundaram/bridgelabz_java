package stacksqueueshashmaps;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/*
this class finds all subarrays within an array that sum up to zero.
it uses a hash map to store cumulative sums and their corresponding
indices. if a cumulative sum is seen again, the elements between
the previous index and the current index sum to zero.
*/
public class ZeroSumSubarrays {

    //method to find and print all subarrays with sum zero
    public void findSubarrays(int[] arr) {
        //map to store cumulative sum and list of indices where it occurred
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int cumulativeSum = 0;

        //iterate through the array
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            //if cumulative sum is 0, subarray from index 0 to i sums to 0
            if (cumulativeSum == 0) {
                System.out.println("Subarray found from index 0 to " + i);
            }

            //if sum exists in map, subarrays exist between previous indices and current i
            if (map.containsKey(cumulativeSum)) {
                List<Integer> indices = map.get(cumulativeSum);
                for (Integer prevIndex : indices) {
                    System.out.println("Subarray found from index " + (prevIndex + 1) + " to " + i);
                }
            }

            //add current index to the list for this cumulative sum
            map.putIfAbsent(cumulativeSum, new ArrayList<>());
            map.get(cumulativeSum).add(i);
        }
    }

    //main function to test zero sum subarray logic
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        ZeroSumSubarrays obj = new ZeroSumSubarrays();
        obj.findSubarrays(arr);
    }
}