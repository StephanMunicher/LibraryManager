package model;

import java.util.Objects;

public class Loan {
    private Reader reader;
    private Book book;

    public Loan(Book book, Reader reader) {
        if (book == null || reader == null) {
            throw new NullPointerException();
        }

        this.book = book;
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Loan other = (Loan) obj;

        return Objects.equals(book, other.book)
                && Objects.equals(reader, other.reader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, reader);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book = " + book +
                ", reader = " + reader +
                '}';
    }
}
