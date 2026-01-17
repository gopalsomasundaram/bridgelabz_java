package ConstructorsAccessModifiers.Level1;
/*
 * This class demonstrates Constructor Overloading.
 * Overloading allows a class to have more than one constructor with different parameters.
 */
public class Book {
    //Attributes
    String title;
    String author;
    int price;

    // Default constructor
    Book() {
        title = "Java Programming";
        author = "James Gosling";
        price = 500;
    }

    // Parameterized constructor
    Book(String t, String a, int p) {
        title = t;
        author = a;
        price = p;
    }

    void displayData() {
        System.out.println("Book Title : " + title);
        System.out.println("Book Author : " + author);
        System.out.println("Book Price : " + price);
    }

    public static void main(String[] args) {
        //Creating an object using the Default Constructor
        Book obj1 = new Book();
        obj1.displayData();

        System.out.println();
        //Creating an object using the Default Constructor
        Book obj2 = new Book("Test Book", "Adam John", 700); // parameterized constructor
        obj2.displayData();
    }
}
