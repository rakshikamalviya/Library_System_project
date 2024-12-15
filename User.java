package LibrarySystem;

import java.time.LocalDate;

public class User {
    private String name;
    private int bookId;
    private LocalDate borrowDate;

    public User(String name, int bookId, LocalDate borrowDate) {
        this.name = name;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public String getName() { return name; }
    public int getBookId() { return bookId; }
    public LocalDate getBorrowDate() { return borrowDate; }
}

