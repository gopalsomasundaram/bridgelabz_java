package String.Level1;
import java.util.Scanner;
public class DemonstrateArrayBounds {
    public void generateException(String[] names) {
        System.out.println("\n--- Generating ArrayIndexOutOfBoundsException ---");
        int invalidIndex = names.length;
        System.out.println("Attempting to access index: " + invalidIndex);
        String name = names[invalidIndex];
        System.out.println("This will not print: " + name);
    }
    public void handleException(String[] names) {
        try {
            int wayOutIndex = 100;
            System.out.println("Attempting to access index: " + wayOutIndex);

            String name = names[wayOutIndex];
            System.out.println("Name found: " + name);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Specific Exception: Index is outside the array limits.");
        } catch (RuntimeException e) {
            System.out.println("Caught Generic RuntimeException: " + e.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DemonstrateArrayBounds demo = new DemonstrateArrayBounds();
        System.out.println("How many names do you want to enter?");
        int size = scanner.nextInt();
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.next();
        }
        try {
            demo.generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The program would have crashed, but main caught the error.");
        }
        demo.handleException(names);
        System.out.println("\nProgram execution finished successfully.");
        scanner.close();
    }
}
