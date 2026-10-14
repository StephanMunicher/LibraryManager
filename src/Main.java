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

        libraryConsole.run();
    }
}
