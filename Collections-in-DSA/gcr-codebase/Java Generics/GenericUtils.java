import java.util.ArrayList;
import java.util.List;

// 1a) Build a generic Pair<T, U> class [cite: 4]
class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return first; }
    public void setFirst(T first) { this.first = first; }

    public U getSecond() { return second; }
    public void setSecond(U second) { this.second = second; }

    @Override
    public String toString() {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }
}

// 1b) Build a generic Stack<T> [cite: 4]
class Stack<T> {
    private final List<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}

// Utility class for Generic Methods and Repositories
class GenericUtils {

    // 2) Write a generic method findMax(T[] arr) bounded to Comparable [cite: 5]
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    // 3) Demonstrate wildcard List<?> for a utility print method [cite: 6]
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}

// 4) Create a generic Repository<T> that stores any entity type [cite: 5]
class Repository<T> {
    private final List<T> database = new ArrayList<>();

    public void add(T entity) {
        database.add(entity);
    }

    public List<T> getAll() {
        return new ArrayList<>(database);
    }

    public boolean remove(T entity) {
        return database.remove(entity);
    }
}