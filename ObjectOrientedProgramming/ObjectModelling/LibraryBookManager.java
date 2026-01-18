package ObjectModelling;

import java.util.ArrayList;

/*
this class represents the independent entity in the aggregation relationship.
books can exist on their own even if a library is destroyed or closed.
*/
class Books {
    private String title;
    private String author;

    // constructor to initialize book details
    Books(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // method to display details of an individual book
    public void displayBook() {
        System.out.println("Book Title: " + title + " | Written By: " + author);
    }
}

/*
this class represents the container or aggregate.
it 'has-a' collection of books, but it does not 'own' their lifecycle entirely.
this is modeled using an ArrayList of Book objects.
*/
class Library {
    private String libName;
    private ArrayList<Books> books;

    // constructor initializes the library name and an empty list for books
    Library(String libName) {
        this.libName = libName;
        this.books = new ArrayList<>();
    }

    // method to add an existing book object to the library's collection
    public void addBooks(Books book) {
        books.add(book);
    }

    /*
    this method iterates through the aggregated list of books
    to display the library's current inventory
    */
    public void displayLibrary() {
        System.out.println("Library Name: " + libName);
        System.out.println("Books in this library:");
        for (Books b : books) {
            b.displayBook();
        }
        System.out.println();
    }
}

/*
the main class demonstrates the aggregation relationship.
notice how books are created independently before being added to libraries.
*/
public class LibraryBookManager{
    public static void main(String[] args) {
        // creating book objects independently (standalone existence)
        Books b1 = new Books("The Alchemist", "Paulo Coelho");
        Books b2 = new Books("Laws of Power", "Robert Green");
        Books b3 = new Books("1984", "George Orwell");

        // creating library objects
        Library lib1 = new Library("Anna Centenary Library");
        Library lib2 = new Library("Eswari Lending Library");

        // aggregating books into different libraries
        lib1.addBooks(b1);
        lib2.addBooks(b2);
        lib2.addBooks(b3);

        // displaying the data to show the relationship in action
        lib1.displayLibrary();
        lib2.displayLibrary();
    }
}