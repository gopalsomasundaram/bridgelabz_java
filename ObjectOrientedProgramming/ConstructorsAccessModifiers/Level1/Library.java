package ConstructorsAccessModifiers.Level1;
public class Library {
    String title = "Effective Java";
    String author = "Joshua Bloch";
    int price = 600;
    boolean availability = true;

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
        Library obj = new Library();

        obj.displayData();
        obj.borrowBook();
        obj.displayData();
    }
}
