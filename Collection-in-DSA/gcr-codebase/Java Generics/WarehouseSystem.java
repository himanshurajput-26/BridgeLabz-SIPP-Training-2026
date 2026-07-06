import java.util.List;
import java.util.ArrayList;

// Abstract base class and variants [cite: 69]
abstract class WarehouseItem {
    private final String name;
    public WarehouseItem(String name) { this.name = name; }
    public String getName() { return name; }
}

class Electronics extends WarehouseItem {
    public Electronics(String name) { super(name); }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) { super(name); }
}

// Generic Storage bounded to WarehouseItem [cite: 70]
class Storage<T extends WarehouseItem> {
    private final List<T> items = new ArrayList<>();

    public void store(T item) { items.add(item); }
    public List<T> getItems() { return items; }

    // Wildcard method to display items regardless of specific type [cite: 71]
    public static void displayStorage(List<? extends WarehouseItem> storageItems) {
        for (WarehouseItem item : storageItems) {
            System.out.println("Item: " + item.getName());
        }
    }
}