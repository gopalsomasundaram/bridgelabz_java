package String.Level1;

import java.util.Scanner;
/*
 * This class manually extracts a part of a string (substring)
 * and compares it with Java's built-in .substring() method.
 */
public class CompareSubstring {
    // Custom method to extract characters between two indices
    String customSubstring(String str, int start, int end){
        //Create an array exactly large enough to hold the slice
        // If start=1 and end=3, we need (3-1)+1 = 3 slots
        char[] arr = new char[end-start+1];
        int index = 0;
        for(int i = start;i<=end;++i){
            arr[index++] = str.charAt(i);
        }
        //Convert the character array back into a String object
        return new String(arr);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string to be split");
        String str = scanner.next();
        System.out.println("Enter the index to start substring from: ");
        int start = scanner.nextInt();
        System.out.println("Enter the index to end substring at: ");
        int end = scanner.nextInt();
        //Java's built-in substring(start, end)
        String substr = str.substring(start,end+1);
        CompareSubstring obj = new CompareSubstring();
        String customSubstr = obj.customSubstring(str,start,end);
// Compare results
        if(substr.equals(customSubstr)) System.out.println("The result for both are the same");
        else System.out.println("The result for both are not the same");
        scanner.close();
    }
}
