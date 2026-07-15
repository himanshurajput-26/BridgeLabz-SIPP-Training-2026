class Product {
    static double discount = 10.0;

    String productName;
    double price;
    int quantity;
    final int productID;

    Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Updated Discount: " + discount + "%");
    }

    void display() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Product ID: " + productID);
    }

    public static void main(String[] args) {
        Product p = new Product("Laptop", 65000, 2, 1001);

        if (p instanceof Product) {
            p.display();
        }

        updateDiscount(15);
    }
}