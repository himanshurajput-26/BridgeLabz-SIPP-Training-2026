class Student {
    public String rollNumber;      // Public
    protected String name;         // Protected
    private double CGPA;           // Private

    public Student(String rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public Getters and Setters to safely access/modify private field CGPA
    public double getCGPA() {
        return this.CGPA;
    }

    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        }
    }
}

class PostgraduateStudent extends Student {
    private String researchTopic;

    public PostgraduateStudent(String rollNumber, String name, double CGPA, String researchTopic) {
        super(rollNumber, name, CGPA);
        this.researchTopic = researchTopic;
    }

    public void displayPGDetails() {
        // Can directly access public 'rollNumber' and protected 'name' from parent class
        System.out.println("PG Student: " + name + " (Roll: " + rollNumber + ") | Research: " + researchTopic + " | CGPA: " + getCGPA());
    }
}

public class MainUniversity {
    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent("PG101", "Alice Smith", 9.2, "Computer Vision");
        pg.displayPGDetails();
        
        // Modifying private CGPA field safely via public setter inheritance structures
        pg.setCGPA(9.5);
        pg.displayPGDetails();
    }
}