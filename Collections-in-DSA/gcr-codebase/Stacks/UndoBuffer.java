class UndoBuffer {
    private String[] data;
    private int top;

    UndoBuffer(int maxDepth) {
        data = new String[maxDepth]; // cite: 35
        top = -1; // cite: 35
    }

    boolean push(String edit) {
        if (top == data.length - 1) { // cite: 39
            return false; // Reject the push when at capacity
        }
        data[++top] = edit; // cite: 39
        return true;
    }

    String pop() {
        if (isEmpty()) { // cite: 42
            throw new RuntimeException("Nothing to undo"); // cite: 42
        }
        return data[top--]; // cite: 42
    }

    String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to undo");
        }
        return data[top];
    }

    boolean isEmpty() { 
        return top == -1; // cite: 44
    }
}