package Arrays.Level1;
import java.util.Scanner;
public class StoreNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        int input;
        int index_inp=0;
        while(true){
            input = scanner.nextInt();
            if(index_inp>=10||input<=0) break;
            arr[index_inp] = input;
            index_inp++;
        }
        int sum = 0;
        for(int i = 0;i<index_inp;i++){
            sum+=arr[i];
        }
        System.out.println("The sum is "+sum);
        scanner.close();
    }
}
