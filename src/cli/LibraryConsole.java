package cli;

import comparator.BookTitleComparator;
import comparator.ReaderFirstNameComparator;
import exceptions.BookAlreadyBorrowedException;
import exceptions.BookNotBorrowedException;
import exceptions.BookNotFoundException;
import exceptions.ReaderNotFoundException;
import model.Book;
import model.Reader;
import service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class LibraryConsole {
    private final LibraryService libraryService;

    public LibraryConsole(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("MENU");
            System.out.println("1. Add book");
            System.out.println("2. Add reader");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Show all book");
            System.out.println("6. Show all readers");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author's name: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter book year: ");
                    int bookYear = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();

                    Book book = new Book(bookId, title, author, bookYear, genre);

                    libraryService.addBook(book);
                    System.out.println("Book added successfully!");
                    break;
                case 3:
                    System.out.print("Enter book ID: ");
                    int id1 = scanner.nextInt();

                    System.out.print("Enter reader ID: ");
                    int id2 = scanner.nextInt();

                    try {
                        libraryService.borrowBook(id1, id2);
                        System.out.println("Book borrowed successfully!");
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (BookAlreadyBorrowedException e) {
                        System.out.println(e.getMessage());
                    } catch (ReaderNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4 :
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();

                    try {
                        libraryService.returnBook(id);
                        System.out.println("Book returned successfully!");
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (BookNotBorrowedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    List<Book> books = libraryService.getAllBooksSorted(new BookTitleComparator());
                    if (books.isEmpty()) {
                        System.out.println("No books in the library yet.");
                    } else {
                        books.forEach(System.out::println);
                    }
                    break;
                case 6:
                    List<Reader> readers = libraryService.getAllReadersSorted(new ReaderFirstNameComparator());
                    if (readers.isEmpty()) {
                        System.out.println("No readers yet.");
                    } else {
                        readers.forEach(System.out::println);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please choose from 0 to 6");
            }
        }
        while (choice != 0);
    }
}
