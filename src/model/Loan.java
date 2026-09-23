package model;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private final Reader reader;
    private final Book book;
    private final LocalDate loanDate;

    public Loan(Book book, Reader reader, LocalDate loanDate) {
        if (book == null || reader == null || loanDate == null) {
            throw new NullPointerException();
        }

        this.book = book;
        this.reader = reader;
        this.loanDate = loanDate;
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public LocalDate getLoanDate() {
        return loanDate;
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
                ", loanDate = " + loanDate +
                '}';
    }
}
