class CartItem {
    // Attributes
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public CartItem(String itemName, double price, int initialQuantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = initialQuantity;
    }

    // Method to add item quantity
    public void addQuantity(int count) {
        if (count > 0) {
            this.quantity += count;
            System.out.println("Added " + count + " more units to " + itemName);
        }
    }

    // Method to remove item quantity safely
    public void removeQuantity(int count) {
        if (count > 0 && count <= this.quantity) {
            this.quantity -= count;
            System.out.println("Removed " + count + " units from " + itemName);
        } else {
            System.out.println("Action Denied: Invalid quantity reduction request.");
        }
    }

    // Method to display total cost
    public void displayTotalCost() {
        double cost = price * quantity;
        System.out.println("Product: " + itemName + " | Unit Price: $" + price + 
                           " | Total Quantity: " + quantity + " | Aggregate Cost: $" + cost);
    }
}

public class MainShoppingCart {
    public static void main(String[] args) {
        CartItem cart = new CartItem("Wireless Mouse", 25.0, 2);
        cart.displayTotalCost();
        
        cart.addQuantity(3);
        cart.displayTotalCost();
        
        cart.removeQuantity(1);
        cart.displayTotalCost();
    }
}