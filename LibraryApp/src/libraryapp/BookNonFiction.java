package libraryapp;

public class BookNonFiction extends Book {
    private String subject;

    public BookNonFiction(String title, String author, String subject, int year) {
        super(title, author, year);
        this.subject = subject;
    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    @Override
    public String toString() {
        return super.toString() + " [Non-Fiction, Subject: " + subject + "]";
    }
}