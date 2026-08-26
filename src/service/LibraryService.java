package service;

import model.Book;
import model.Loan;
import model.Reader;

import java.util.List;

public class LibraryService {
    private final Repository repository;
    private final SortService sortService;

    public LibraryService(Repository repository, SortService sortService) {
        this.repository = repository;
        this.sortService = sortService;
    }

    public void borrowBook(int bookId, int readerId) {
        Book foundBook = repository.findBookById(bookId);
        if (foundBook == null) {
            throw new IllegalArgumentException("The book not found!");
        }

        Reader foundReader = repository.findReaderById(readerId);
        if (foundReader == null) {
            throw new IllegalArgumentException("The Reader not found!");
        }

        for (Loan loan : repository.getLoans()) {
            if (loan.getBook().equals(foundBook)) {
                throw new IllegalStateException("The book has already borrowed by another reader!");
            }
        }

        repository.addLoan(new Loan(foundBook, foundReader));
    }

    public void returnBook(int bookId) {
        Book foundBook = repository.findBookById(bookId);
        if (foundBook == null) {
            throw new IllegalArgumentException("The book not found!");
        }

        boolean removed = repository.removeLoan(bookId);

        if (!removed) {
            throw new IllegalStateException("The book is not borrowed!");
        }
    }

    public List<Book> getAvailableBooksSortedByTitle() {
        return sortService.sortBooksByTitle(repository.getAvailableBooks());
    }

    public List<Book> getAvailableBooksSortedByAuthor() {
        return sortService.sortBooksByAuthor(repository.getAvailableBooks());
    }

    public List<Book> getAvailableBooksSortedByYear() {
        return sortService.sortBooksByYear(repository.getAvailableBooks());
    }

    public List<Book> getBorrowedBooksSortedByTitle() {
        return sortService.sortBooksByTitle(repository.getBorrowedBooks());
    }

    public List<Book> getBorrowedBooksSortedByAuthor() {
        return sortService.sortBooksByAuthor(repository.getBorrowedBooks());
    }

    public List<Book> getBorrowedBooksSortedByYear() {
        return sortService.sortBooksByYear(repository.getBorrowedBooks());
    }

    public List<Book> getAllBooksSortedByTitle() {
        return sortService.sortBooksByTitle(repository.getAllBooks());
    }

    public List<Book> getAllBooksSortedByAuthor() {
        return sortService.sortBooksByAuthor(repository.getAllBooks());
    }

    public List<Book> getAllBooksSortedByYear() {
        return sortService.sortBooksByYear(repository.getAllBooks());
    }

    public List<Reader> getAllReadersSortedByFirstName() {
        return sortService.sortReadersByFirstName(repository.getAllReaders());
    }
}
