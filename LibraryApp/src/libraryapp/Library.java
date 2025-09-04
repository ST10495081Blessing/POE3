package libraryapp;
import java.util.ArrayList;

public class Library {
    // Schildt, H. (2018).
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
        // Horstmann, C. (2019).
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\n--- List of Books ---");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }
        // Bloch, J. (2018).
    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No books found with title: " + title);
    }
        // Deitel, P. and Deitel, H. (2017).
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No books found by author: " + author);
    }
        // Sierra, K. and Bates, B. (2019).
    public void generateReport() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("\n--- Library Report ---");
            for (Book book : books) {
                System.out.println(book);
            }
            System.out.println("Total books: " + books.size());
            
            /*
            /*1. Schildt, H. (2018). Java: The Complete Reference. 11th ed. McGraw-Hill Education.
- A comprehensive guide to Java programming, covering core concepts, object-oriented programming, and advanced features.

2. Horstmann, C. (2019).Core Java Volume I – Fundamentals. 11th ed. Pearson Education.
- Focuses on Java fundamentals, including classes, inheritance, and arrays.

3. Bloch, J. (2018). Effective Java. 3rd ed. Addison-Wesley.
- A practical guide to best practices in Java programming, including object-oriented design principles.

4. Deitel, P. and Deitel, H. (2017). Java How to Program: Early Objects. 11th ed. Pearson Education.
- Covers Java programming concepts with examples, including arrays, loops, and object-oriented programming.

5. Sierra, K. and Bates, B. (2019). Head First Java. 3rd ed. O'Reilly Media.
- A beginner-friendly book that explains Java concepts in an engaging and visual way.


            */
        }
    }}