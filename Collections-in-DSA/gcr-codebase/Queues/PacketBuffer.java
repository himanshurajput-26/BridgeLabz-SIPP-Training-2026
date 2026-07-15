class PacketBuffer {
    private int[] data; // cite: 203
    private int front, count; // cite: 204

    PacketBuffer(int capacity) {
        data = new int[capacity]; // cite: 206
        front = 0; // cite: 208
        count = 0; // cite: 208
    }

    boolean enqueue(int packetId) {
        if (count == data.length) return false; // Buffer full: reject the new packet [cite: 211]
        
        // Calculate insert index using modular arithmetic
        data[(front + count) % data.length] = packetId; // cite: 211
        count++; // cite: 212
        return true; // cite: 213
    }

    int dequeue() {
        if (count == 0) throw new RuntimeException("Buffer empty"); // cite: 216
        
        int val = data[front]; // cite: 217
        front = (front + 1) % data.length; // Shift front pointer with wraparound [cite: 218]
        count--; // cite: 219
        return val; // cite: 220
    }
}