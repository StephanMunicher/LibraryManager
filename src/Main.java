import cli.LibraryConsole;
import model.Book;
import model.Reader;
import repository.Repository;
import service.LibraryService;
import service.SortService;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        SortService sortService = new SortService();
        LibraryService libraryService = new LibraryService(repository, sortService);
        LibraryConsole libraryConsole = new LibraryConsole(libraryService);

        Book book1 = new Book(1, "111", "111", 2000, "111");
        repository.addBook(book1);
        Reader reader1 = new Reader(1, "111", "111");
        repository.addReader(reader1);

        libraryConsole.run();
    }
}
