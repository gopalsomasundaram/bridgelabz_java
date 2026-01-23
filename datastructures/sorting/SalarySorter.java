package sorting;

/*
this class implements the heap sort algorithm to organize job applicant
salary demands in ascending order. heap sort utilizes a binary heap
data structure. it first transforms the array into a max-heap, then
repeatedly swaps the root (largest element) with the last element
and restores the heap property to sort the data in-place.
*/
public class SalarySorter {

    //method to perform heap sort on an array of salary values
    public void sortBySalary(int[] salaries) {
        int n = salaries.length;

        //step 1: build a max heap from the input data
        //start from the last non-leaf node and move up to the root
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        //step 2: extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            //move current root (maximum) to the end of the array
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            //call max heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    //helper method to maintain the max-heap property
    private void heapify(int[] arr, int n, int i) {
        int largest = i; //initialize largest as root
        int left = 2 * i + 1; //index of left child
        int right = 2 * i + 2; //index of right child

        //if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        //if right child is larger than current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        //if largest is not the root, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            //recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    //helper method to print the array of salaries
    public void printSalaries(int[] salaries) {
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }

    /*
    this main method implements the entry point for the program. it
    initializes an array of job applicant salary demands, creates
    an instance of SalarySorter, and demonstrates the heap sorting
    process.
    */
    public static void main(String[] args) {
        //initializing an unsorted array of salary expectations
        int[] salaryDemands = {45000, 32000, 75000, 50000, 28000, 90000, 60000};

        //object creation
        SalarySorter sorter = new SalarySorter();

        System.out.println("Salaries before sorting:");
        sorter.printSalaries(salaryDemands);

        //calling the heap sort method
        sorter.sortBySalary(salaryDemands);

        System.out.println("Salaries after sorting (Ascending):");
        sorter.printSalaries(salaryDemands);
    }
}