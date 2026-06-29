import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SmartClassroomAttendanceTracker {
    // Key: Subject Name, Value: List of unique students present [cite: 54, 55, 56]
    private HashMap<String, ArrayList<String>> attendanceMap;

    public SmartClassroomAttendanceTracker() {
        this.attendanceMap = new HashMap<>(); // 
    }

    // Task 1 & 2: Mark attendance and prevent duplicates per subject [cite: 62, 63]
    public void markAttendance(String subjectName, String studentName) {
        // If subject doesn't exist, initialize an empty list [cite: 58]
        attendanceMap.putIfAbsent(subjectName, new ArrayList<>());

        ArrayList<String> students = attendanceMap.get(subjectName);

        // Check for duplicates within the current subject [cite: 57, 63]
        if (students.contains(studentName)) {
            System.out.println("Attendance already marked for " + studentName + " in " + subjectName + ".");
        } else {
            students.add(studentName);
            System.out.println("Attendance marked: " + studentName + " in " + subjectName + ".");
        }
    }

    // Task 3: Display the attendance list for each subject [cite: 64]
    public void displayAttendance() {
        System.out.println("\n--- Attendance List by Subject ---");
        for (Map.Entry<String, ArrayList<String>> entry : attendanceMap.entrySet()) { // [cite: 59]
            System.out.println("Subject: " + entry.getKey() + " -> Students: " + entry.getValue());
        }
    }

    // Task 4: Show the total number of students present in every subject [cite: 65]
    public void displayTotalAttendanceCounts() {
        System.out.println("\n--- Attendance Counts ---");
        for (Map.Entry<String, ArrayList<String>> entry : attendanceMap.entrySet()) {
            System.out.println("Subject: " + entry.getKey() + " | Total Present: " + entry.getValue().size()); // [cite: 65]
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();
        tracker.markAttendance("Java Programming", "Himanshu");
        tracker.markAttendance("Java Programming", "Amit");
        tracker.markAttendance("Java Programming", "Himanshu"); // Duplicate check [cite: 63]
        tracker.markAttendance("Machine Learning", "Himanshu"); // Cross-subject verification [cite: 58]

        tracker.displayAttendance();
        tracker.displayTotalAttendanceCounts();
    }
}