package libraryapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestLibrary {

    private Library library;

    @Test
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        Book book = new Book("Clean Code", "Robert Martin", 2008);
        library.addBook(book);
        assertEquals(1, library.getBooks().size());
        assertEquals("Clean Code", library.getBooks().get(0).getTitle());
    }

    @Test
    void testSearchByTitleFound() {
        Book book = new Book("1984", "George Orwell", 1949);
        library.addBook(book);

        boolean found = library.getBooks().stream()
                .anyMatch(b -> b.getTitle().equalsIgnoreCase("1984"));
        assertTrue(found);
    }

    @Test
    void testSearchByTitleNotFound() {
        library.addBook(new Book("Dune", "Frank Herbert", 1965));
        boolean found = library.getBooks().stream()
                .anyMatch(b -> b.getTitle().equalsIgnoreCase("Unknown"));
        assertFalse(found);
    }

    @Test
    void testSearchByAuthorFound() {
        library.addBook(new Book("1984", "George Orwell", 1949));
        boolean found = library.getBooks().stream()
                .anyMatch(b -> b.getAuthor().equalsIgnoreCase("George Orwell"));
        assertTrue(found);
    }

    @Test
    void testGenerateReportCountsBooks() {
        library.addBook(new Book("Book A", "Author A", 2000));
        library.addBook(new Book("Book B", "Author B", 2010));
        assertEquals(2, library.getBooks().size());
    }
}