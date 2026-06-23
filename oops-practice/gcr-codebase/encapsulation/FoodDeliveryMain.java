abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public abstract double calculateTotalPrice();

    public void displayItemDetails() {
        System.out.printf("Item: %-15s | Unit Price: $%-6.2f | Qty: %d", itemName, price, quantity);
    }
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    private double serviceCharge;

    public NonVegItem(String itemName, double price, int quantity, double serviceCharge) {
        super(itemName, price, quantity);
        this.serviceCharge = serviceCharge;
    }

    public double getServiceCharge() { return serviceCharge; }
    public void setServiceCharge(double serviceCharge) { this.serviceCharge = serviceCharge; }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + serviceCharge;
    }
}

public class FoodDeliveryMain {
    public static void main(String[] args) {
        FoodItem paneerTikka = new VegItem("Paneer Tikka", 12.0, 2);
        FoodItem butterChicken = new NonVegItem("Butter Chicken", 15.5, 1, 3.50);

        System.out.println("====== CUSTOMER DELIVERY MANIFEST ======");
        paneerTikka.displayItemDetails();
        System.out.printf(" | Net Cost: $%.2f%n", paneerTikka.calculateTotalPrice());

        butterChicken.displayItemDetails();
        System.out.printf(" | Net Cost: $%.2f (Inc. Svc)%n", butterChicken.calculateTotalPrice());
    }
}