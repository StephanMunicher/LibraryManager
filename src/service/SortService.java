package service;

import comparator.BookAuthorComparator;
import comparator.BookTitleComparator;
import comparator.BookYearComparator;
import comparator.ReaderFirstNameComparator;
import model.Book;
import model.Reader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortService {
    public List<Book> sortBooksByTitle(List<Book> books) {
        return sortBooks(books, new BookTitleComparator());
    }

    public List<Book> sortBooksByYear(List<Book> books) {
        return sortBooks(books, new BookYearComparator());
    }

    public List<Book> sortBooksByAuthor(List<Book> books) {
        return sortBooks(books, new BookAuthorComparator());
    }

    public List<Reader> sortReadersByFirstName(List<Reader> readers) {
        return sortReaders(readers, new ReaderFirstNameComparator());
    }

    public List<Book> sortBooks(List<Book> books, Comparator<Book> comparator) {
        List<Book> result = new ArrayList<>(books);
        result.sort(comparator);
        return result;
    }

    public List<Reader> sortReaders(List<Reader> readers, Comparator<Reader> comparator) {
        List<Reader> result = new ArrayList<>(readers);
        result.sort(comparator);
        return result;
    }
}
