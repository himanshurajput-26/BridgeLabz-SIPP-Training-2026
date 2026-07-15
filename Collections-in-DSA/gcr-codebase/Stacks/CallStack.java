class CallStack {
    private static class Frame { // cite: 58
        String functionName; // cite: 60
        Frame next; // cite: 61

        Frame(String name, Frame next) { // cite: 62
            this.functionName = name; // cite: 62
            this.next = next; // cite: 62
        }
    }

    private Frame top = null; // cite: 63

    void push(String functionName) {
        top = new Frame(functionName, top); // cite: 66
    }

    String pop() {
        if (isEmpty()) { // cite: 69
            throw new RuntimeException("No active call to return from"); // cite: 69
        }
        String name = top.functionName; // cite: 69, 70
        top = top.next; // cite: 71
        return name; // cite: 72
    }

    String peek() {
        if (isEmpty()) {
            throw new RuntimeException("No active call stack");
        }
        return top.functionName;
    }

    boolean isEmpty() { 
        return top == null; // cite: 74
    }
}