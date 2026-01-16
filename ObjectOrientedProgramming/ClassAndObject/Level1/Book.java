package ClassAndObject.Level1;

public class Book {
    String title = "Programming in java";
    String author = "Robert C. Martin";
    int price = 500;

    void displayData() {
        System.out.println("Book title : " + title);
        System.out.println("Book author : " + author);
        System.out.println("Book price : " + price);
    }

    public static void main(String[] args) {
        Book obj = new Book();
        obj.displayData();
    }
}
