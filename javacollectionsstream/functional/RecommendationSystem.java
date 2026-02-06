/**
 * This Program implements a Book Recommendation system with pagination.
 * * @author gopal
 */
package functional;

import java.util.*;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title; this.author = author; this.genre = genre; this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title; this.rating = rating;
    }
    @Override
    public String toString() { return title + " [" + rating + "]"; }
}

public class RecommendationSystem {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.2),
                new Book("The Hobbit", "Tolkien", "Fantasy", 4.8)
        );

        // Problem 3: Filter, Transform, Sort, and Paginate (Page 1, 5 items per page)
        int pageSize = 5;
        int pageNumber = 0; // First page

        List<BookRecommendation> page1 = books.stream()
                .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
                .map(b -> new BookRecommendation(b.title, b.rating))
                .sorted(Comparator.comparingDouble((BookRecommendation r) -> r.rating).reversed())
                .skip(pageNumber * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

        System.out.println("Page 1 Recommendations: " + page1);
    }
}