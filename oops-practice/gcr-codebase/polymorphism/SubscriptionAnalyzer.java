class Subscription {
    protected String subscriberName; // [cite: 287]
    protected String subscriptionId; // [cite: 288]

    public Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    public double calculateMonthlyCharge() { return 0.0; } // [cite: 290]
}

class BasicPlan extends Subscription {
    public BasicPlan(String name, String id) { super(name, id); }
    @Override public double calculateMonthlyCharge() { return 199.0; } // [cite: 291]
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String name, String id) { super(name, id); }
    @Override public double calculateMonthlyCharge() { return 499.0; } // [cite: 291]
}

class FamilyPlan extends Subscription {
    public FamilyPlan(String name, String id) { super(name, id); }
    @Override public double calculateMonthlyCharge() { return 799.0; } // [cite: 291]
}

public class SubscriptionAnalyzer {
    // Requirements: Search subscription via unique ID string [cite: 295]
    public static void searchById(Subscription[] subs, String id) {
        for (Subscription s : subs) {
            if (s.subscriptionId.equalsIgnoreCase(id)) {
                System.out.println("ID Verification Successful: " + s.subscriberName + " utilizes a plan billing ₹" + s.calculateMonthlyCharge());
                return;
            }
        }
        System.out.println("Error: Subscription token profile not found.");
    }

    // Requirements: Filter names matching a specific character key [cite: 296]
    public static void displaySubscribersByPrefix(Subscription[] subs, char prefix) {
        System.out.println("\nFiltering Profiles starting with letter '" + prefix + "':");
        char lowerPrefix = Character.toLowerCase(prefix);
        for (Subscription s : subs) {
            if (s.subscriberName.toLowerCase().startsWith(String.valueOf(lowerPrefix))) {
                System.out.println(" -> " + s.subscriberName + " (ID: " + s.subscriptionId + ")");
            }
        }
    }

    // Requirements: Core metrics calculations loop [cite: 297]
    public static double calculateTotalRevenue(Subscription[] subs) {
        double balance = 0;
        for (Subscription s : subs) balance += s.calculateMonthlyCharge(); // [cite: 298]
        return balance;
    }

    // Requirements: Locate peak tariff element profile [cite: 299]
    public static void identifyMostExpensiveSubscription(Subscription[] subs) {
        if (subs.length == 0) return;
        Subscription expensive = subs[0];
        for (Subscription s : subs) {
            if (s.calculateMonthlyCharge() > expensive.calculateMonthlyCharge()) {
                expensive = s;
            }
        }
        System.out.println("\nPeak Billing Consumer Account: " + expensive.subscriberName + " [Charge Tier: ₹" + expensive.calculateMonthlyCharge() + "]");
    }

    public static void main(String[] args) {
        Subscription[] serverDatabase = { // [cite: 293]
            new BasicPlan("Amit Kumar", "SUB-B01"),
            new PremiumPlan("Harshita", "SUB-P02"),
            new FamilyPlan("Aakash Roy", "SUB-F03"),
            new PremiumPlan("Bhavna", "SUB-P04")
        };

        System.out.println("Platform Metrics: Total Recurring Revenue: ₹" + calculateTotalRevenue(serverDatabase)); // [cite: 297]
        searchById(serverDatabase, "SUB-P02"); // [cite: 295]
        displaySubscribersByPrefix(serverDatabase, 'A'); // [cite: 296]
        identifyMostExpensiveSubscription(serverDatabase); // [cite: 299]
    }
}