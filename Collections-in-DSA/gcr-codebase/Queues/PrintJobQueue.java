import java.util.ArrayDeque;
import java.util.Deque; // cite: 234

class PrintJobQueue {
    private Deque<Integer> printQueue = new ArrayDeque<>(); // cite: 234

    // Normal FIFO submission
    void submitJob(int jobId) {
        printQueue.addLast(jobId); // Joins the back of the line [cite: 237]
    }

    // Urgent bypass submission
    void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId); // Jumps directly to the front [cite: 239]
    }

    // Processing the next available job
    int printNextJob() {
        if (printQueue.isEmpty()) {
            throw new RuntimeException("No print jobs available");
        }
        return printQueue.removeFirst(); // Printer always pulls from the front [cite: 243]
    }
}