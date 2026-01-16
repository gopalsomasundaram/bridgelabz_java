package methods.level3;
import java.util.Scanner;
/*
 * A comprehensive utility class for Matrix Operations.
 * Supports addition, subtraction, multiplication, transpose,
 * determinant calculation, and matrix inversion for 2x2 and 3x3 matrices.
 */
public class MatriceOperations {
    int[][] addMatrice(int[][] matrix1, int[][] matrix2, int m, int n){
        int[][] result = new int[m][n];
        // Element-wise addition: C[i][j] = A[i][j] + B[i][j]
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    int[][] subtractMatrice(int[][] matrix1, int[][] matrix2, int m, int n){
        int[][] result = new int[m][n];
        // Element-wise subtraction: C[i][j] = A[i][j] - B[i][j]

        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    int[][] multiplyMatrice(int[][] matrix1, int[][] matrix2, int m, int n){
        int[][] result = new int[m][n];
        // Matrix Multiplication: Result[i][j] is the dot product of row i and column j
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                for(int k = 0;k<m;++k){
                    result[i][j]+=matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    void fillMatrixRandom(int[][] matrix, int m, int n){
        int min = 0;
        int max = 10;
        for(int i =0;i<m;++i){
            for(int j=0;j<n;++j){
                matrix[i][j] = (int)(Math.random()*(max-min+1)+min);
            }
        }
    }
    void printMatrix(int[][] matrix,int m, int n){
        for(int i = 0;i<m;++i){
            for(int j= 0;j<n;++j){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    void printMatrix(double[][] matrix,int m, int n){
        for(int i = 0;i<m;++i){
            for(int j= 0;j<n;++j){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    int[][] transposeOfMatrix(int[][] matrix, int m, int n){
        int[][] result = new int[n][m];
        // Transpose: Swapping rows with columns (A[i][j] becomes A[j][i])
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;++j){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    int determinant2D(int[][] matrix){

        return ((matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]));
    }
    int determinant3D(int[][] matrix){
        // a(ei - fh) - b(di - fg) + c(dh - eg)
        int a = (matrix[0][0]*((matrix[1][1]*matrix[2][2])-(matrix[1][2]*matrix[2][1])));
        int b = (matrix[0][1]*((matrix[1][0]*matrix[2][2])-(matrix[1][2]*matrix[2][0])));
        int c = (matrix[0][2]*((matrix[1][0]*matrix[2][1])-(matrix[1][1]*matrix[2][0])));
        return a-b+c;
    }
    double[][] inverse2D(int[][] matrix){
        int det = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);

    double[][] inverse = new double[2][2];

    inverse[0][0] =  matrix[1][1] / (double)det;
    inverse[0][1] = -matrix[0][1] / (double)det;
    inverse[1][0] = -matrix[1][0] / (double)det;
    inverse[1][1] =  matrix[0][0] / (double)det;

    return inverse;
    }
    public double[][] inverse3x3(int[][] matrix) {
        double det = determinant3D(matrix);
        // Calculating each element of the Adjugate matrix divided by the determinant
        double[][] inverse = new double[3][3];
        double invDet = 1.0 / det;

        inverse[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) * invDet;
        inverse[0][1] = (matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2]) * invDet;
        inverse[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]) * invDet;

        inverse[1][0] = (matrix[1][2] * matrix[2][0] - matrix[1][0] * matrix[2][2]) * invDet;
        inverse[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]) * invDet;
        inverse[1][2] = (matrix[1][0] * matrix[0][2] - matrix[0][0] * matrix[1][2]) * invDet;

        inverse[2][0] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]) * invDet;
        inverse[2][1] = (matrix[2][0] * matrix[0][1] - matrix[0][0] * matrix[2][1]) * invDet;
        inverse[2][2] = (matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]) * invDet;

        return inverse;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = scanner.nextInt();
        System.out.println("Enter number of columns: ");
        int n = scanner.nextInt();
        MatriceOperations obj = new MatriceOperations();
        int[][] matrix1 = new int[m][n];
        obj.fillMatrixRandom(matrix1,m,n);
        obj.printMatrix(matrix1,m,n);
        double[][] result = obj.inverse3x3(matrix1);
        obj.printMatrix(result,m,n);
        scanner.close();
    }
}
