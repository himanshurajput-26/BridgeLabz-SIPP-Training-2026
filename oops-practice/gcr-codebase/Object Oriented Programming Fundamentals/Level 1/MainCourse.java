class Course {
    private String courseName;
    private int duration; // in weeks/months
    private double fee;
    private static String instituteName = "TechAcademy"; // Class Variable

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance Method
    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName + " | Course: " + courseName + 
                           " | Duration: " + duration + " months | Fee: $" + fee);
    }

    // Class Method
    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

public class MainCourse {
    public static void main(String[] args) {
        Course c1 = new Course("Java Full Stack", 6, 300.0);
        Course c2 = new Course("Data Science", 8, 450.0);

        c1.displayCourseDetails();
        
        // Changing static modifier across all active instances instantly
        Course.updateInstituteName("Global Coding Club");
        
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}