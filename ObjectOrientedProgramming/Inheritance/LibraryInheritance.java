package Inheritance;

/*
this class represents the superclass (parent).
it contains general information about a published work.
*/
class Book {
    String title;
    int publicationYear;

    // constructor to initialize common book attributes
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // method to display basic book info
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Published in: " + publicationYear);
    }
}

/*
this class represents the Author and extends the Book class.
it inherits the publication details and adds specific
attributes related to the person who wrote it.
*/
class Author extends Book {
    String name;
    String bio;

    // constructor for subclass initializing both inherited and local fields
    Author(String title, int publicationYear, String name, String bio) {
        /* using super() to pass title and year to the
           parent Book constructor
        */
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    /* method overriding: this specialized version displays
       both the inherited book details and the author details.
    */
    @Override
    void displayInfo() {
        super.displayInfo(); // invokes parent's display logic
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
        System.out.println("------------------------------------------");
    }
}

/*
the driver class manages the creation of author-specific book records.
*/
public class LibraryInheritance{
    public static void main(String[] args) {
        /* creating a subclass object. even though we are
           instantiating an Author, it carries all properties of a Book.
        */
        Author authorRecord = new Author(
                "The Great Gatsby",
                1925,
                "F. Scott Fitzgerald",
                "An American novelist and short story writer."
        );

        System.out.println("--- Library Record ---");
        // calls the overridden method in the Author class
        authorRecord.displayInfo();
    }
}