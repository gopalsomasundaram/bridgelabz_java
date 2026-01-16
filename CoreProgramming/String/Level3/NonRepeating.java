package String.Level3;

import java.util.Scanner;
public class NonRepeating {
    public char findFirstNonRepeating(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NonRepeating obj = new NonRepeating();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Input is empty.");
        } else {
            char result = obj.findFirstNonRepeating(input);

            if (result != '\0') {
                System.out.println("The first non-repeating character is: '" + result + "'");
            } else {
                System.out.println("All characters in the string are repeating.");
            }
        }

        scanner.close();
    }
}
