package runtimeanalysis;

import java.util.Arrays;

/*
this class compares the execution efficiency of linear search and
binary search. it demonstrates that while linear search is simpler
for small datasets, binary search is exponentially faster for large,
sorted datasets, making it the preferred choice for scaling
applications.
*/
public class SearchPerformanceAnalysis {

    //method to perform linear search on an unsorted array
    public int linearSearch(int[] arr, int target) {
        //iterate through the array sequentially
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; //return index if found
            }
        }
        return -1; //target not present
    }

    //method to perform binary search on a sorted array
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        //repeatedly divide the search interval in half
        while (left <= right) {
            int mid = left + (right - left) / 2;

            //check if target is present at mid
            if (arr[mid] == target) return mid;

            //if target is greater, ignore left half
            if (arr[mid] < target) left = mid + 1;
                //if target is smaller, ignore right half
            else right = mid - 1;
        }
        return -1; //target not present
    }

    //method to run the simulation for different dataset sizes
    public void runSimulation(int size) {
        int[] dataset = new int[size];

        //populating the dataset
        for (int i = 0; i < size; i++) {
            dataset[i] = i;
        }

        //target is set to the last element to test worst-case for linear search
        int target = size - 1;

        //measure Linear Search time
        long startLinear = System.nanoTime();
        linearSearch(dataset, target);
        long endLinear = System.nanoTime();
        double linearTimeMs = (endLinear - startLinear) / 1_000_000.0;

        //sorting the dataset is required before binary search
        //note: in a real scenario, we sort once and search many times
        Arrays.sort(dataset);

        //measure Binary Search time
        long startBinary = System.nanoTime();
        binarySearch(dataset, target);
        long endBinary = System.nanoTime();
        double binaryTimeMs = (endBinary - startBinary) / 1_000_000.0;

        //outputting result for comparative analysis
        System.out.println("Dataset Size: " + size);
        System.out.println("Linear Search (Worst Case): " + String.format("%.4f", linearTimeMs) + " ms");
        System.out.println("Binary Search (Worst Case): " + String.format("%.4f", binaryTimeMs) + " ms");
        System.out.println("--------------------------------------------------");
    }

    /*
    this main method triggers the performance test on various dataset
    sizes to validate the theoretical time complexities of O(N) and O(log N).
    */
    public static void main(String[] args) {
        //object creation
        SearchPerformanceAnalysis analysis = new SearchPerformanceAnalysis();

        //testing for 1k, 10k, and 1M elements
        analysis.runSimulation(1000);
        analysis.runSimulation(10000);
        analysis.runSimulation(1000000);
    }
}