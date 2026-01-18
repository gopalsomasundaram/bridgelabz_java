package StaticFinalAndInstanceOf;
/*
this class is used to demonstrate the use of keywords:
static - for shared library information across all book objects
final - to ensure the ISBN remains constant once assigned
this - to resolve variable shadowing during initialization
*/
class Book {
    // static members
    static String libraryName = "City Central Library";

    // instance members
    String title;
    String author;
    final String isbn;

    // parameterized constructor
    Book(String title, String author, String isbn) {
        // using 'this' to distinguish instance variables from parameters
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // static method to display library name
    static void displayLibraryName() {
        System.out.println("Welcome to: " + libraryName);
    }

    // method to display book details
    void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println();
    }
}

/*
this class contains the main method to simulate the library system,
using the instanceof operator to validate objects before processing
*/
public class LibraryManagement {
    public static void main(String[] args) {
        // displaying static library info using the class name
        Book.displayLibraryName();
        System.out.println();

        // creating book objects
        Book book1 = new Book("Programming in Java", "Sachin Malhotra", "1234");
        Book book2 = new Book("Clean Code", "Robert wilde", "4567");

        // verifying instance of book1
        if (book1 instanceof Book) {
            System.out.println("Validating: Object is a legitimate Book record.");
            book1.displayBookDetails();
        }

        // verifying instance of book2
        if (book2 instanceof Book) {
            book2.displayBookDetails();
        }
    }
}