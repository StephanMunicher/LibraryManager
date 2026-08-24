package service;

import model.Book;
import model.Loan;
import model.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private final Map<Integer, Book> books = new HashMap<>();
    private final Map<Integer, Reader> readers = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new NullPointerException();
        }

        books.putIfAbsent(book.getId(), book);
    }

    public void removeBook(int bookId) {
        Book book = books.get(bookId);

        if (book == null) {
            throw new IllegalArgumentException("The book not found!");
        }

        for (Loan loan : loans) {
            if (loan.getBook().equals(book)) {
                throw new IllegalStateException("The book is currently borrowed!");
            }
        }

        books.remove(bookId);
    }

    public Book findBookById(int id) {
        return books.get(id);
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

    public void removeReader(int readerId) {
        Reader reader = readers.get(readerId);

        if (reader == null) {
            throw new IllegalArgumentException("The reader not found!");
        }

        for (Loan loan : loans) {
            if (loan.getReader().equals(reader)) {
                throw new IllegalStateException("The reader has borrowed a book!");
            }
        }

        readers.remove(readerId);
    }

    public Reader findReaderById(int id) {
        return readers.get(id);
    }

    public Map<Integer, Reader> getReaders() {
        return Map.copyOf(readers);
    }

    public void returnBook(int bookId) {
        Book foundBook = findBookById(bookId);
        if (foundBook == null) {
            throw new IllegalArgumentException("The book not found!");
        }

        boolean removed = loans.removeIf(loan -> loan.getBook().equals(foundBook));

        if (!removed) {
            throw new IllegalStateException("The book is not borrowed!");
        }
    }

    public List<Loan> getLoans() {
        return List.copyOf(loans);
    }

    public void addLoan(Loan loan) {
        if (loan == null) {
            throw new NullPointerException();
        }
        loans.add(loan);
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.values().stream()
                .filter(b -> author.equals(b.getAuthor()))
                .toList();
    }

    public List<Book> findBooksByGenre(String genre) {
        return books.values().stream()
                .filter(b -> genre.equals(b.getGenre()))
                .toList();
    }

    public List<Book> findBooksByTitle(String title) {
        return books.values().stream()
                .filter(b -> title.equals(b.getTitle()))
                .toList();
    }

    public List<Book> getAllBooks() {
        return List.copyOf(books.values());
    }

    public List<Book> getBorrowedBooks() {
        return loans.stream()
                .map(Loan::getBook)
                .toList();
    }

    public List<Book> getAvailableBooks() {
        return books.values().stream()
                .filter(b -> loans.stream()
                        .noneMatch(l -> l.getBook().equals(b)))
                .toList();
    }

    public List<Reader> getAllReaders() {
        return List.copyOf(readers.values());
    }

    public List<Reader> getReadersByFullName(String fullName) {
        return readers.values().stream()
                .filter(r -> fullName.equals(r.getFullName()))
                .toList();
    }

    public List<Book> getBooksByReader(int readerId) {
        return loans.stream()
                .filter(l -> readerId == l.getReader().getId())
                .map(Loan::getBook)
                .toList();
    }

    public Reader getReaderByBook(int bookId) {
        return loans.stream()
                .filter(l -> bookId == l.getBook().getId())
                .map(Loan::getReader)
                .findFirst()
                .orElse(null);
    }
}
