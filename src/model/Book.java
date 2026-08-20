package model;

import java.util.Objects;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final int bookYear;
    private final String genre;

    public Book(int id, String title, String author, int bookYear, String genre) {
        if (title == null || author == null || genre == null) {
            throw new NullPointerException();
        }

        if (id <= 0) {
            throw new IllegalArgumentException();
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

       return this.id == other.id &&
               this.title.equals(other.title) &&
               this.author.equals(other.author) &&
               this.bookYear == other.bookYear &&
               this.genre.equals(other.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, bookYear, genre);
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
