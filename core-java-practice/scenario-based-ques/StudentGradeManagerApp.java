import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// ==========================================
// 1. STUDENT MODEL CLASS
// ==========================================
class Student {
    private String name;
    private int[] marks; // Array of 5 subjects
    private int totalMarks;
    private double average;
    private char grade;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateResults();
    }

    private void calculateResults() {
        this.totalMarks = Arrays.stream(marks).sum();
        this.average = totalMarks / 5.0;
        
        // Nested conditions for grading calculation
        if (average >= 90) {
            this.grade = 'A';
        } else if (average >= 80) {
            this.grade = 'B';
        } else {
            if (average >= 70) {
                this.grade = 'C';
            } else if (average >= 60) {
                this.grade = 'D';
            } else {
                this.grade = 'F';
            }
        }
    }

    public String getName() { return name; }
    public int getTotalMarks() { return totalMarks; }
    public double getAverage() { return average; }
    public char getGrade() { return grade; }

    @Override
    public String toString() {
        return String.format("%-15s | Total: %3d | Avg: %5.2f | Grade: %c", 
                name, totalMarks, average, grade);
    }
}

// ==========================================
// 2. CORE MANAGER CLASS (Handles Arrays & I/O)
// ==========================================
class GradeManager {
    private Student[] students;
    private int studentCount;
    private static final int MAX_STUDENTS = 100;

    public GradeManager() {
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;
    }

    // File Input Handling with Custom Error Exceptions
    public void loadFromFile(String filename) throws IOException, IllegalArgumentException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("Input file '" + filename + "' not found.");
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine() && studentCount < MAX_STUDENTS) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;

                // Expected structural format: Name,m1,m2,m3,m4,m5
                String[] tokens = line.split(",");
                if (tokens.length != 6) {
                    throw new IllegalArgumentException("Invalid data format in file line: " + line);
                }

                String name = tokens[0].trim();
                int[] marks = new int[5];
                for (int i = 0; i < 5; i++) {
                    marks[i] = Integer.parseInt(tokens[i + 1].trim());
                    if (marks[i] < 0 || marks[i] > 100) {
                        throw new IllegalArgumentException("Marks must be between 0 and 100 for " + name);
                    }
                }

                students[studentCount++] = new Student(name, marks);
            }
        }
    }

    // Custom Sorting Element: Bubble Sort (Descending Order by Total Marks)
    public void sortByTotalMarks() {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (students[j].getTotalMarks() < students[j + 1].getTotalMarks()) {
                    // Classic swap algorithm
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // Linear Search Engine
    public Student searchByName(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                return students[i];
            }
        }
        return null;
    }

    // File Output Handling
    public void writeReportToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("=====================================================");
            writer.println("               STUDENT GRADE REPORT                  ");
            writer.println("=====================================================");
            writer.printf("%-15s | %-15s | %-7s | %-5s\n", "Name", "Total Marks", "Average", "Grade");
            writer.println("-----------------------------------------------------");
            
            for (int i = 0; i < studentCount; i++) {
                Student s = students[i];
                writer.printf("%-15s | %-15d | %-7.2f | %-5c\n", 
                        s.getName(), s.getTotalMarks(), s.getAverage(), s.getGrade());
            }
            writer.println("=====================================================");
        }
    }

    public void displayAll() {
        if (studentCount == 0) {
            System.out.println("No student records present in the active buffer.");
            return;
        }
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }
}

// ==========================================
// 3. MAIN RUNNABLE APP INTERFACE ENTRY POINT
// ==========================================
public class StudentGradeManagerApp {
    public static void main(String[] args) {
        GradeManager manager = new GradeManager();
        Scanner consoleScanner = new Scanner(System.in);

        System.out.println("--- Welcome to the Student Grade Manager ---");
        System.out.print("Enter input data filename (e.g., students.txt): ");
        String inputFile = consoleScanner.nextLine();

        // Safe Initialization and Loading
        try {
            manager.loadFromFile(inputFile);
            System.out.println("Data processed and mapped onto arrays successfully!\n");
        } catch (Exception e) {
            System.err.println("Execution Error: " + e.getMessage());
            System.out.println("Terminating program setup.");
            return;
        }

        // Processing Console Lifecycle Interface
        boolean activeRun = true;
        while (activeRun) {
            System.out.println("\n--- Operations Menu ---");
            System.out.println("1. Display All Records");
            System.out.println("2. Sort Records (Bubble Sort by Marks)");
            System.out.println("3. Search Records by Student Name");
            System.out.println("4. Export Grade Report File");
            System.out.println("5. Exit Application");
            System.out.print("Select menu item: ");

            String choice = consoleScanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("\n--- Current Workspace Records ---");
                    manager.displayAll();
                    break;
                case "2":
                    manager.sortByTotalMarks();
                    System.out.println("\nArray sorting via Bubble Sort complete (Descending total marks applied).");
                    manager.displayAll();
                    break;
                case "3":
                    System.out.print("Search string (Full Student Name): ");
                    String name = consoleScanner.nextLine();
                    Student match = manager.searchByName(name);
                    if (match != null) {
                        System.out.println("\n[Record Found]: " + match);
                    } else {
                        System.out.println("No profile data exists for: \"" + name + "\"");
                    }
                    break;
                case "4":
                    System.out.print("Assign output report target name (e.g., summary_report.txt): ");
                    String outputFile = consoleScanner.nextLine();
                    try {
                        manager.writeReportToFile(outputFile);
                        System.out.println("Data flush sequence completed to target destination: " + outputFile);
                    } catch (Exception e) {
                        System.err.println("Fatal file generation halt: " + e.getMessage());
                    }
                    break;
                case "5":
                    activeRun = false;
                    System.out.println("System cycle terminated. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid menu identifier selection. Try again.");
            }
        }
        consoleScanner.close();
    }
}