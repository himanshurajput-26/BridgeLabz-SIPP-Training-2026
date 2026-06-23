class Item {
    // Attributes
    private String itemCode;
    private String itemName;
    private double price;

    // Constructor
    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayItemDetails() {
        System.out.println("Code: " + itemCode + " | Item: " + itemName + " | Unit Price: $" + price);
    }

    // Method to calculate total cost for a specific quantity
    public double calculateTotalCost(int quantity) {
        return this.price * quantity;
    }
}

public class MainInventory {
    public static void main(String[] args) {
        Item product = new Item("ITM-99X", "Mechanical Keyboard", 89.99);
        product.displayItemDetails();
        
        int orderQuantity = 5;
        double total = product.calculateTotalCost(orderQuantity);
        System.out.println("Total Cost for " + orderQuantity + " items: $" + total);
    }
}