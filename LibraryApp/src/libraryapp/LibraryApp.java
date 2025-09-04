package libraryapp;
import java.util.Scanner;

public class LibraryApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add a new book");
            System.out.println("2. View all books");
            System.out.println("3. Search by title");
            System.out.println("4. Search by author");
            System.out.println("5. Generate report");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addBookMenu(); break;
                case 2: library.viewBooks(); break;
                case 3:
                    System.out.print("Enter title: ");
                    library.searchByTitle(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter author: ");
                    library.searchByAuthor(scanner.nextLine());
                    break;
                case 5: library.generateReport(); break;
                case 6: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    // Sierra, K. and Bates, B. (2019).
    private static void addBookMenu() {
        System.out.print("Is the book fiction or non-fiction? ");
        String type = scanner.nextLine();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        if (type.equalsIgnoreCase("fiction")) {
            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();
            library.addBook(new BookFiction(title, author, genre, year));
        } else {
            System.out.print("Enter subject: ");
            String subject = scanner.nextLine();
            library.addBook(new BookNonFiction(title, author, subject, year));
        }

        System.out.println("Book added successfully!");
    }
}