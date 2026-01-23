package runtimeanalysis;

import java.util.Arrays;
import java.util.Random;

/*
this class compares the efficiency of three sorting algorithms: bubble
sort, merge sort, and quick sort. it demonstrates the drastic
performance gap between O(N²) and O(N log N) algorithms when handling
large datasets, highlighting why divide-and-conquer methods are essential.
*/
public class SortingPerformanceComparison {

    //method to perform bubble sort (O(N²) complexity)
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //method to perform quick sort (O(N log N) average complexity)
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    //helper method to partition the array for quick sort
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    //method to run sorting tests and measure execution time
    public void runTest(int n) {
        int[] original = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) original[i] = rand.nextInt(10000);

        System.out.println("Testing dataset size: " + n);

        //measure bubble sort (only for small N to avoid hanging)
        if (n <= 10000) {
            int[] arr1 = original.clone();
            long start = System.currentTimeMillis();
            bubbleSort(arr1);
            System.out.println("Bubble Sort: " + (System.currentTimeMillis() - start) + "ms");
        } else {
            System.out.println("Bubble Sort: Unfeasible for large N");
        }

        //measure merge sort (using Java's built-in optimized merge sort)
        int[] arr2 = original.clone();
        long startMerge = System.currentTimeMillis();
        Arrays.sort(arr2);
        System.out.println("Merge/Dual-Pivot Sort: " + (System.currentTimeMillis() - startMerge) + "ms");

        //measure quick sort
        int[] arr3 = original.clone();
        long startQuick = System.currentTimeMillis();
        quickSort(arr3, 0, n - 1);
        System.out.println("Quick Sort: " + (System.currentTimeMillis() - startQuick) + "ms");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        SortingPerformanceComparison comparison = new SortingPerformanceComparison();
        comparison.runTest(1000);
        comparison.runTest(10000);
    }
}