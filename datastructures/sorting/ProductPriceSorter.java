package sorting;

/*
this class implements the quick sort algorithm to organize product prices
in ascending order. quick sort is a highly efficient divide-and-conquer
algorithm that picks a 'pivot' element and partitions the array into
sub-arrays of smaller and larger elements, which are then sorted recursively.
*/
public class ProductPriceSorter {

    //method to perform the recursive quick sort operations
    public void sort(double[] prices, int low, int high) {
        //continue if the range has at least two elements
        if (low < high) {
            //partition the array and get the pivot index
            int pivotIndex = partition(prices, low, high);

            //recursively sort elements before and after the pivot
            sort(prices, low, pivotIndex - 1);
            sort(prices, pivotIndex + 1, high);
        }
    }

    //helper method to partition the array based on a pivot element
    private int partition(double[] prices, int low, int high) {
        //using the last element as the pivot
        double pivot = prices[high];
        int i = (low - 1); //index of smaller element

        //traverse the array and swap elements smaller than the pivot
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                //swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        //swap the pivot element to its final sorted position
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
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
    initializes an array of product prices, creates an instance of
    ProductPriceSorter, and demonstrates the sorting process.
    */
    public static void main(String[] args) {
        //initializing an unsorted array of product prices
        double[] productPrices = {1200.50, 450.00, 89.99, 10500.75, 210.00, 35.50};

        //object creation
        ProductPriceSorter sorter = new ProductPriceSorter();

        System.out.println("Product Prices before sorting:");
        sorter.printPrices(productPrices);

        //calling the quick sort method (low index is 0, high is length-1)
        sorter.sort(productPrices, 0, productPrices.length - 1);

        System.out.println("Product Prices after sorting (Ascending):");
        sorter.printPrices(productPrices);
    }
}