class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; // Initially available
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Success: You have borrowed '" + title + "'.");
        } else {
            System.out.println("Error: '" + title + "' is currently checked out.");
        }
    }

    public void displayStatus() {
        System.out.println("Title: " + title + " | Author: " + author + " | Price: $" + price + " | Available: " + isAvailable);
    }
}

public class MainLibrary {
    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Clean Code", "Robert C. Martin", 40.0);
        book.displayStatus();
        book.borrowBook();
        book.borrowBook(); // Attempting to borrow again
    }
}