abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public abstract int getLoanDuration();

    public void displayItemDetails() {
        System.out.printf("ID: %s | Title: '%s' by %s", itemId, title, author);
    }
}

class Book extends LibraryItem {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() { return 14; } // 14 Days Loan
}

class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() { return 7; } // 7 Days Loan
}

class DVD extends LibraryItem {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() { return 3; } // 3 Days Loan
}

public class LibraryMain {
    public static void main(String[] args) {
        LibraryItem book = new Book("B-901", "Effective Java", "Joshua Bloch");
        LibraryItem mag = new Magazine("M-102", "National Geographic", "Various");
        LibraryItem dvd = new DVD("D-554", "Inception", "Christopher Nolan");

        System.out.println("====== ARCHIVAL CATALOG SYSTEM ======");
        book.displayItemDetails();
        System.out.println(" | Loan Limit: " + book.getLoanDuration() + " Days");

        mag.displayItemDetails();
        System.out.println(" | Loan Limit: " + mag.getLoanDuration() + " Days");

        dvd.displayItemDetails();
        System.out.println(" | Loan Limit: " + dvd.getLoanDuration() + " Days");
    }
}