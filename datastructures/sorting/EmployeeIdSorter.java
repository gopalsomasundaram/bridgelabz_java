package sorting;

/*
this class implements the insertion sort algorithm to organize employee
IDs in ascending order. insertion sort builds the final sorted array
one item at a time by picking an element from the unsorted portion
and shifting the sorted elements to find the correct insertion spot.
*/
public class EmployeeIdSorter {

    //method to perform insertion sort on an array of employee IDs
    public void sortById(int[] employeeIds) {
        int n = employeeIds.length;

        //start from the second element (index 1) as the first is 'sorted'
        for (int i = 1; i < n; i++) {
            //current element to be inserted into the sorted part
            int key = employeeIds[i];
            int j = i - 1;

            //move elements of employeeIds[0..i-1] that are greater than key
            //to one position ahead of their current position
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j = j - 1;
            }

            //place the key at its correct sorted position
            employeeIds[j + 1] = key;
        }
    }

    //helper method to print the array of employee IDs
    public void printIds(int[] employeeIds) {
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    /*
    this main method implements the entry point for the program. it
    initializes an array of employee IDs, creates an instance of
    EmployeeIdSorter, and demonstrates the sorting functionality.
    */
    public static void main(String[] args) {
        //initializing an unsorted array of employee IDs
        int[] ids = {1054, 1002, 1089, 1021, 1005, 1100, 1010};

        //object creation
        EmployeeIdSorter sorter = new EmployeeIdSorter();

        System.out.println("Employee IDs before sorting:");
        sorter.printIds(ids);

        //calling the insertion sort method
        sorter.sortById(ids);

        System.out.println("Employee IDs after sorting (Ascending):");
        sorter.printIds(ids);
    }
}
