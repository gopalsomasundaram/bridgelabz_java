package ClassAndObject.Level1;
/*
 * This class demonstrates the basics of Object-Oriented Programming.
 * It defines a 'Book' entity with specific attributes and a behavior.
 */
public class Book {
    //Attributes
    String title = "Programming in java";
    String author = "Robert C. Martin";
    int price = 500;
    //Method
    void displayData() {
        System.out.println("Book title : " + title);
        System.out.println("Book author : " + author);
        System.out.println("Book price : " + price);
    }

    public static void main(String[] args) {
        //Object Creation
        Book obj = new Book();
        //Method Invocation
        obj.displayData();
    }
}
