package model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final int bookYear;
    private final String genre;

    public Book(int id, String title, String author, int bookYear, String genre) {
        if (title == null || author == null || genre == null) {
            throw new NullPointerException("Book parameters cannot be null.");
        }

        title = title.strip();
        author = author.strip();
        genre = genre.strip();

        if (title.isEmpty() || author.isEmpty() || genre.isEmpty()) {
            throw new IllegalArgumentException("Book parameters cannot be empty.");
        }

        if (!title.matches("[\\p{L}\\p{M}\\p{N} .,!?;:'\"()\\-–—&]+")
                || !author.matches("[\\p{L}\\p{M} '-’]+")
                || !genre.matches("[\\p{L}\\p{M}\\p{N} &/-]+")) {
            throw new IllegalArgumentException(
                    "Parameters can contain only correct symbols."
            );
        }

        if (id <= 0) {
            throw new IllegalArgumentException("Book ID must be positive.");
        }

        if (author.length() < 2 || genre.length() < 2) {
            throw new IllegalArgumentException(
                    "Parameters must contain correct number of characters."
            );
        }

        if(bookYear <= 0 || bookYear > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Book year must be between 1 and the current year.");
        }

        this.id = id;
        this.title = title;
        this.author = author;
        this.bookYear = bookYear;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookYear() {
        return bookYear;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Book other = (Book) obj;

        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id = " + id +
                ", title = " + title +
                ", author = " + author +
                ", bookYear = " + bookYear +
                ", genre = " + genre +
                '}';
    }
}
