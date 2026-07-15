import java.util.PriorityQueue; // cite: 261

class Patient {
    int priority; // cite: 258
    String name; // cite: 259

    Patient(int priority, String name) {
        this.priority = priority; // cite: 260
        this.name = name; // cite: 260
    }
}

class ERTriageSystem {
    // Min-heap: prioritizes patients with lower priority numbers
    private PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> a.priority - b.priority); // cite: 261, 262

    void admitPatient(Patient p) {
        triageQueue.offer(p); // cite: 265
    }

    Patient callNextPatient() {
        if (triageQueue.isEmpty()) return null;
        return triageQueue.poll(); // Returns and removes the most urgent patient [cite: 268, 269]
    }
}