package service;

import model.Book;
import model.Loan;
import model.Reader;

import java.util.Comparator;
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

    public List<Book> getAllBooksSorted(Comparator<Book> comparator) {
        return sortService.sortBooks(repository.getAllBooks(), comparator);
    }

    public List<Reader> getAllReadersSorted(Comparator<Reader> comparator) {
        return sortService.sortReaders(repository.getAllReaders(), comparator);
    }

    public List<Book> getBorrowedBooksSorted(Comparator<Book> comparator) {
        return sortService.sortBooks(repository.getBorrowedBooks(), comparator);
    }

    public List<Book> getAvailableBooksSorted(Comparator<Book> comparator) {
        return sortService.sortBooks(repository.getAvailableBooks(), comparator);
    }
}
