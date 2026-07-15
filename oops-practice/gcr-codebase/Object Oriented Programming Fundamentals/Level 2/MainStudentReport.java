class Student {
    // Attributes
    private String name;
    private int rollNumber;
    private double marks;

    // Constructor
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade based on marks
    public char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }

    // Method to display details and the calculated grade
    public void displayReport() {
        System.out.println("=== Student Report Card ===");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Marks Scored: " + marks + "%");
        System.out.println("Final Assigned Grade: " + calculateGrade());
    }
}

public class MainStudentReport {
    public static void main(String[] args) {
        Student student = new Student("Amit Kumar", 45, 87.5);
        student.displayReport();
    }
}