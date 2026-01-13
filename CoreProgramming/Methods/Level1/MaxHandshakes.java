package Methods.Level1;

import java.util.Scanner;
public class MaxHandshakes {
    int calcMaxHandshakes(int n ){
        return ((n*(n-1))/2);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int n = scanner.nextInt();
        MaxHandshakes myObj = new MaxHandshakes();
        int result = myObj.calcMaxHandshakes(n);
        System.out.println("The max number of hanshakes is: "+result);
        scanner.close();
    }
}
