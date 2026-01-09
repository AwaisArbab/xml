package xml.assignment.first_two_questions;

public class Book {
    private final String book_id;
    private final String title;
    private final String author;
    private final int year;

    public String getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public Book(String book_id, String title, String author, int year) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
