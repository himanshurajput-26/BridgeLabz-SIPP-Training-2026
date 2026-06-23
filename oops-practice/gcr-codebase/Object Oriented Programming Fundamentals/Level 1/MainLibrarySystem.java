class LibraryItem {
    public String ISBN;          // Public
    protected String title;      // Protected
    private String author;       // Private

    public LibraryItem(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public Getters/Setters for Private Field 'author'
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends LibraryItem {
    private double fileSizeMB;

    public EBook(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public void displayEBookInfo() {
        // Demonstrating access to public (ISBN) and protected (title) members
        System.out.println("EBook: " + title + " | ISBN: " + ISBN + " | Author: " + getAuthor() + " | Size: " + fileSizeMB + "MB");
    }
}

public class MainLibrarySystem {
    public static void main(String[] args) {
        EBook ebook = new EBook("978-3-16", "Design Patterns", "Gang of Four", 4.5);
        ebook.displayEBookInfo();
    }
}