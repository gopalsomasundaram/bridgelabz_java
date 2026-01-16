package arrays.Level1;
import java.util.Scanner;
/*
 * This class demonstrates how to convert (flatten) a 2D array into a 1D array.
 * It takes user-defined rows (m) and columns (n), populates the grid,
 * and then maps each grid coordinate to a single linear index.
 */
public class TwoDToOneD {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows in array:");
        int m = scanner.nextInt();
        System.out.println("Enter the number of columnns in array:");
        int n = scanner.nextInt();
        //Initialize and Populate the 2D Array
        int[][] arr2d = new int[m][n];
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                System.out.printf("Enter the element for index [%d][%d]: ",i,j);
                arr2d[i][j] = scanner.nextInt();
            }
        }
        //Initialize the 1D Array
        int[] arr1d = new int[m*n];
        //Flattening Logic (Row-Major Order)
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                arr1d[(i*m)+j]= arr2d[i][j];
            }
        }
        //Display results
        System.out.println("Elements in 1 dimensional array: ");
        for(int i = 0;i<arr1d.length;++i){
            System.out.println(arr1d[i]);
        }
        scanner.close();
    }
}
