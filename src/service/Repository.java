package service;

import model.Book;
import model.Loan;
import model.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Reader> readers = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public List<Loan> getLoans() {
        return List.copyOf(loans);
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new NullPointerException();
        }

        books.putIfAbsent(book.getId(), book);
    }

    public void removeBook(Book book) {
        if (book == null) {
            throw new NullPointerException();
        }

        books.remove(book.getId(), book);
    }

    public Book findBook(Book book) {
        if (book == null) {
            throw new NullPointerException();
        }

        for (Book libraryBook : books.values()) {
            if (libraryBook.equals(book)) {
                return libraryBook;
            }
        }

        return null;
    }

    public Map<Integer, Book> getBooks() {
        return Map.copyOf(books);
    }

    public void addReader(Reader reader) {
        if (reader == null) {
             throw new NullPointerException();
        }

        readers.putIfAbsent(reader.getId(), reader);
    }

    public void removeReader(Reader reader) {
        if (reader == null) {
            throw new NullPointerException();
        }

        readers.remove(reader.getId(), reader);
    }

    public Reader findReader(Reader reader) {
        if (reader == null) {
            throw new NullPointerException();
        }

        for (Reader libraryReader : readers.values()) {
            if (libraryReader.equals(reader)) {
                return libraryReader;
            }
        }

        readers.containsValue(reader);

        return  null;
    }

    public Map<Integer, Reader> getReaders() {
        return Map.copyOf(readers);
    }

    public void borrowBook(Book book, Reader reader) {
        if (book == null || reader == null) {
            throw new NullPointerException();
        }

        Book foundBook = findBook(book);
        if (foundBook == null) {
            throw new IllegalArgumentException("The book not found!");
        }

        Reader foundReader = findReader(reader);
        if (foundReader == null) {
            throw new IllegalArgumentException("The Reader not found!");
        }

        for (Loan loan : loans) {
            if (loan.getBook().equals(foundBook)) {
                throw new IllegalStateException("The book has already booked by another reader!");
            }
        }

        loans.add(new Loan(foundBook, foundReader));
    }
}
