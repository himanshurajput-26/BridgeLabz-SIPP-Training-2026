interface Category {}
class BookCategory implements Category {}
class ClothingCategory implements Category {}

// Generic Product class restricted to Category types [cite: 78]
class Product<T extends Category> {
    private final String title;
    private double price;

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getTitle() { return title; }
}

class Marketplace {
    // Generic method to apply discounts dynamically [cite: 79]
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double currentPrice = product.getPrice();
        double newPrice = currentPrice - (currentPrice * (percentage / 100.0));
        product.setPrice(newPrice);
    }
}