package String.Level1;

public class DemonstrateNullPointExemption {
    public void generateException() {
        System.out.println("Attempting to generate NullPointerException...");
        String text = null;
        int length = text.length();
    }
    public void handleException() {
        System.out.println("\nAttempting to handle NullPointerException safely...");
        String text = null;

        try {
            // Accessing a String method on a null variable
            int length = text.length();
            System.out.println("Length is: " + length);
        } catch (NullPointerException e) {
            // Catching the RuntimeException
            System.out.println("Caught an Exception: The string variable is null!");
            System.out.println("Exception details: " + e);
        }
    }

    public static void main(String[] args) {
        DemonstrateNullPointExemption obj = new DemonstrateNullPointExemption();
        try {
            obj.generateException();
        } catch (NullPointerException e) {
            System.out.println("Main method caught the crash from generateException().");
        }
        obj.handleException();
        System.out.println("\nProgram execution continued successfully.");
    }
}
