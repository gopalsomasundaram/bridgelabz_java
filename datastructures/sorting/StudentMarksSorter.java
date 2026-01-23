package sorting;

/*
this class implements the bubble sort algorithm to organize student marks
in ascending order. bubble sort works by repeatedly stepping through the
list, comparing adjacent elements, and swapping them if they are in the
wrong order. this process repeats until the entire array is sorted.
*/
public class StudentMarksSorter {

    //method to perform bubble sort on an array of marks
    public void sortByMarks(int[] marks) {
        int n = marks.length;
        boolean swapped;

        //outer loop for the number of passes through the array
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            //inner loop for comparing adjacent elements
            //the last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                //if current element is greater than next, swap them
                if (marks[j] > marks[j + 1]) {
                    //performing the swap
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            //if no two elements were swapped in the inner loop, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    //helper method to print the array of marks
    public void printMarks(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    /*
    this main method implements the entry point for the program. it
    initializes an array of student marks, creates a sorter object,
    and displays the marks before and after the sorting process.
    */
    public static void main(String[] args) {
        //initializing an array with unsorted student marks
        int[] marks = {85, 42, 91, 76, 55, 68, 98, 33};

        //object creation
        StudentMarksSorter sorter = new StudentMarksSorter();

        System.out.println("Marks before sorting:");
        sorter.printMarks(marks);

        //calling the bubble sort method
        sorter.sortByMarks(marks);

        System.out.println("Marks after sorting (Ascending):");
        sorter.printMarks(marks);
    }
}
