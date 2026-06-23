class MobilePhone {
    // Attributes
    private String brand;
    private String model;
    private double price;

    // Constructor
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display specifications
    public void displayPhoneDetails() {
        System.out.println("--- Mobile Specifications ---");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
    }
}

public class MainMobile {
    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone("Apple", "iPhone 15 Pro", 1099.00);
        phone.displayPhoneDetails();
    }
}