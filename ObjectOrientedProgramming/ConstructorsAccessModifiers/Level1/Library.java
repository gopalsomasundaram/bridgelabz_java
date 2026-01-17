package ConstructorsAccessModifiers.Level1;
/*
 * This class models a Library Book and manages
 * its availability status.
 */
public class Library {
    //Attributes
    String title = "Effective Java";
    String author = "Joshua Bloch";
    int price = 600;

    //State Switch
    boolean availability = true;

    //Modifying state with conditional logic
    void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book is not available");
        }
    }

    void displayData() {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
        System.out.println("Available : " + availability);
    }

    public static void main(String[] args) {
        //Object Creation
        Library obj = new Library();

        obj.displayData();
        obj.borrowBook();
        obj.displayData();
    }
}
