interface FoodDelivery {
    default void trackOrder() {
        System.out.println("Food Delivery: Dispatched from restaurant kitchen. En route in thermal carrier.");
    }
    
    static String generateDeliveryCode() {
        return "FOOD-" + (int)(Math.random() * 9000 + 1000);
    }
}

interface GroceryDelivery {
    default void trackOrder() {
        System.out.println("Grocery Delivery: Items picked and packed from sorting fulfillment warehouse.");
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    // Explicit tracking selection override
    @Override
    public void trackOrder() {
        System.out.println("Tracking Update: Executive is managing concurrent mixed fulfillment tasks.");
    }

    public void processDeliveries(String[] customers) {
        System.out.println("=== Dispatching Delivery Logistics Run ===");
        for (String customer : customers) {
            System.out.println("\nCustomer Allocation: " + customer);
            System.out.println("Security Pass Key Token: " + FoodDelivery.generateDeliveryCode());
            
            // Execute explicit trackings manually to fulfill assignment scenarios
            System.out.print("  -> "); FoodDelivery.super.trackOrder();
            System.out.print("  -> "); GroceryDelivery.super.trackOrder();
        }
    }
}