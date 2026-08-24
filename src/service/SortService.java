package service;

import comparator.BookAuthorComparator;
import comparator.BookTitleComparator;
import comparator.BookYearComparator;
import comparator.ReaderFirstNameComparator;
import model.Book;
import model.Reader;

import java.util.ArrayList;
import java.util.List;

public class SortService {
    public List<Book> sortBooksByTitle(List<Book> books) {
        List<Book> result = new ArrayList<>(books);
        result.sort(new BookTitleComparator());
        return result;
    }

    public List<Book> sortBooksByYear(List<Book> books) {
        List<Book> result = new ArrayList<>(books);
        result.sort(new BookYearComparator());
        return result;
    }

    public List<Book> sortBooksByAuthor(List<Book> books) {
        List<Book> result = new ArrayList<>(books);
        result.sort(new BookAuthorComparator());
        return result;
    }

    public List<Reader> sortReadersByFirstName(List<Reader> readers) {
        List<Reader> result = new ArrayList<>(readers);
        result.sort(new ReaderFirstNameComparator());
        return result;
    }
}
