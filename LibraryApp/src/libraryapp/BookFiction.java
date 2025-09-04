package libraryapp;

public class BookFiction extends Book {
    private String genre;

    public BookFiction(String title, String author, String genre, int year) {
        super(title, author, year);
        this.genre = genre;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return super.toString() + " [Fiction, Genre: " + genre + "]";
    }
}