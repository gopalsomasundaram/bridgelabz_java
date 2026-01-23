package sorting;

/*
this class implements the merge sort algorithm to organize book prices
in ascending order. merge sort is a divide-and-conquer algorithm that
recursively splits the array into halves until each subarray contains
a single element, and then merges those subarrays back together in
sorted order.
*/
public class BookPriceSorter {

    //method to initiate the recursive merge sort process
    public void sort(double[] prices, int left, int right) {
        //base case: continue only if there is more than one element
        if (left < right) {
            //finding the middle point of the current range
            int mid = left + (right - left) / 2;

            //recursively sorting the left and right halves
            sort(prices, left, mid);
            sort(prices, mid + 1, right);

            //merging the two sorted halves
            merge(prices, left, mid, right);
        }
    }

    //helper method to merge two sorted subarrays
    private void merge(double[] prices, int left, int mid, int right) {
        //calculating sizes of the two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //creating temporary arrays for storage
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        //copying data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = prices[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = prices[mid + 1 + j];
        }

        //initial indices for merging
        int i = 0, j = 0;
        int k = left;

        //comparing elements and merging them back into the main array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //copying remaining elements of leftArray if any
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        //copying remaining elements of rightArray if any
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    //helper method to print the array of prices
    public void printPrices(double[] prices) {
        for (double price : prices) {
            System.out.printf("%.2f ", price);
        }
        System.out.println();
    }

    /*
    this main method implements the entry point for the program. it
    initializes an array of book prices, creates an instance of
    BookPriceSorter, and demonstrates the sorting process.
    */
    public static void main(String[] args) {
        //initializing an unsorted array of book prices
        double[] bookPrices = {599.99, 120.50, 450.00, 89.90, 1050.75, 210.00};

        //object creation
        BookPriceSorter sorter = new BookPriceSorter();

        System.out.println("Book Prices before sorting:");
        sorter.printPrices(bookPrices);

        //calling the merge sort method
        sorter.sort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Book Prices after sorting (Ascending):");
        sorter.printPrices(bookPrices);
    }
}
