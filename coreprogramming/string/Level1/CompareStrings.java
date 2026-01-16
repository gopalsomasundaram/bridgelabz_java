package string.Level1;
import java.util.Scanner;
/*
 * This class compares two strings manually (character by character)
 * and validates the logic against the built-in .equals() method.
 */
public class CompareStrings {
    // Custom method to check if two strings are identical
    boolean isEqualCustom(String str1,String str2){
        if(str1.length()!=str2.length())
            return false;
        for(int i = 0;i<str1.length();++i){
            if(str1.charAt(i) != str2.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String str1 = scanner.next();
        System.out.println("Enter second string: ");
        String str2  = scanner.next();

        //Java's built-in equality check
        boolean inBuiltResult = str2.equals(str1);
        CompareStrings obj = new CompareStrings();

        //Your manual character-by-character check
        boolean customResult = obj.isEqualCustom(str1,str2);

        //Verification
        if(inBuiltResult == customResult)
            System.out.println("The results are same");
        else
            System.out.println("The results are different");
        scanner.close();
    }
}

