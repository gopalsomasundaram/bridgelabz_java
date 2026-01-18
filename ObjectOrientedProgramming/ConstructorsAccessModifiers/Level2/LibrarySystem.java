package ConstructorsAccessModifiers.Level2;

/**
 * The Book class represents a generic library book.
 * It uses Access Modifiers to demonstrate different levels of visibility:
 * - Public: Open to all.
 * - Protected: Open to family (subclasses) and neighbors (package).
 * - Private: Open only to itself.
 */

class Book {
    //Attributes
    public String ISBN;
    protected String title;
    private String author;
    public Book(String isbn, String title, String author) {
        this.ISBN = isbn;
        this.title = title;
        this.author = author;
    }
    //getter for author
    public String getAuthor() {
        return author;
    }
    //setter for author
    public void setAuthor(String author) {
        this.author = author;
    }
}
class EBook extends Book {
    //private attribute
    private double fileSizeMB;

    //parameterized constructor
    public EBook(String isbn, String title, String author, double fileSize) {
        super(isbn, title, author);
        this.fileSizeMB = fileSize;
    }

    public void displayEBookInfo() {
        System.out.println("E-Book ISBN: " + ISBN); // Public - OK
        System.out.println("Title      : " + title); // Protected - OK
        System.out.println("Author     : " + getAuthor());
        System.out.println("File Size  : " + fileSizeMB + "MB");
    }
}



public class LibrarySystem {
    public static void main(String[] args) {
        // Create an EBook instance
        EBook myEBook = new EBook("978-0134685991", "Effective Java", "Joshua Bloch", 2.5);

        System.out.println("--- Initial Book Info ---");
        myEBook.displayEBookInfo();

        // Modifying the author using the public setter
        myEBook.setAuthor("J. Bloch");
        myEBook.title="Programming in java";
        System.out.println("\n--- After Author Update ---");
        myEBook.displayEBookInfo();
    }
}