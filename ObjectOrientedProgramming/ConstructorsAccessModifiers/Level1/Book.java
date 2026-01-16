package ConstructorsAccessModifiers.Level1;

public class Book {
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
        Book obj1 = new Book();
        obj1.displayData();

        System.out.println();

        Book obj2 = new Book("Test Book", "Adam John", 700); // parameterized constructor
        obj2.displayData();
    }
}
