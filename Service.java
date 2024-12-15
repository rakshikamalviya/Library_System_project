package LibrarySystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service {
    private static List<Book> books = new ArrayList<>();
    private HashMap<Integer, User> borrowedBooks = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book);
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getId() == bookId);
        System.out.println("Book removed successfully.");
    }

    public void borrowBook(int bookId, String userName) {
        for (Book book : books) {
            if (book.getId() == bookId && book.isAvailable()) {
                book.setAvailable(false);
                borrowedBooks.put(bookId, new User(userName, bookId, LocalDate.now()));
                System.out.println("Book borrowed successfully.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(int bookId) {
        if (borrowedBooks.containsKey(bookId)) {
            borrowedBooks.remove(bookId);
            books.forEach(book -> {
                if (book.getId() == bookId) {
                    book.setAvailable(true);
                }
            });
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("No record of this book being borrowed.");
        }
    }

    public static void ListBooks() {
        books.forEach(System.out::println);
    }
}
