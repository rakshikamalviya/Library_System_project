package LibrarySystem;

import java.util.Scanner;


public class Main{
    private static final Service Service = null;

	public static void main(String[] args) {
        Service libraryService = new Service();
        libraryService.addBook(new Book(1, "The Alchemist", "Paulo Coelho"));
        libraryService.addBook(new Book(2, "1984", "George Orwell"));
        libraryService.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. List Books\n2. Add Book\n3. Remove Book\n4. Borrow Book\n5. Return Book\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> Service.ListBooks();

                case 2 -> {
                    System.out.print("Enter Book ID, Title, Author: ");
                    int id = scanner.nextInt();
                    String title = scanner.next();
                    String author = scanner.next();
                    libraryService.addBook(new Book(id, title, author));
                }
                case 3 -> {
                    System.out.print("Enter Book ID to remove: ");
                    int id = scanner.nextInt();
                    libraryService.removeBook(id);
                }
                case 4 -> {
                    System.out.print("Enter Book ID to borrow: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    libraryService.borrowBook(id, name);
                }
                case 5 -> {
                    System.out.print("Enter Book ID to return: ");
                    int id = scanner.nextInt();
                    libraryService.returnBook(id);
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}


