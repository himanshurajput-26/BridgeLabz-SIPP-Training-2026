// ==========================================
// 1. BASE CLASS: PERSON
// ==========================================
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return String.format("Person [Name: %s, Age: %d]", name, age);
    }
}

// ==========================================
// 2. SUBCLASS: STUDENT (Inherits Person)
// ==========================================
class Student extends Person {
    // studentId is marked final so it cannot be changed after initialization
    private final String studentId;
    private double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        // Chaining to Person constructor
        super(name, age); 
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() { return studentId; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        // Appending subclass traits to base class representation
        return super.toString() + String.format(" -> Student [ID: %s, GPA: %.2f]", studentId, gpa);
    }
}

// ==========================================
// 3. SUBCLASS: GRADSTUDENT (Inherits Student)
// ==========================================
class GradStudent extends Student {
    private String thesisTitle;

    public GradStudent(String name, int age, String studentId, double gpa, String thesisTitle) {
        // Chaining to Student constructor
        super(name, age, studentId, gpa); 
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String toString() {
        // Appending grad-level traits to the Student/Person representation
        return super.toString() + String.format(" -> GradStudent [Thesis: \"%s\"]", thesisTitle);
    }
}

// ==========================================
// 4. MAIN DEMONSTRATION APPLICATION
// ==========================================
public class UniversityHierarchyApp {
    public static void main(String[] args) {
        System.out.println("--- Instantiating a Graduate Student ---");
        
        // Creating a GradStudent object executes the chained constructor process down the line
        GradStudent grad = new GradStudent("Alex Mercer", 26, "GS-8841", 3.92, "Machine Learning Optimization");

        System.out.println("\n--- Triggering Overridden toString() Stack ---");
        System.out.println(grad);

        System.out.println("\n--- Verifying IS-A Inheritance Hierarchy (Polymorphism) ---");
        
        // Verifying polymorphism relationships using 'instanceof'
        boolean isGradStudent = grad instanceof GradStudent;
        boolean isStudent     = grad instanceof Student;
        boolean isPerson      = grad instanceof Person;
        boolean isObject      = grad instanceof Object;

        System.out.println("Is 'grad' a GradStudent? " + (isGradStudent ? "✅ YES" : "❌ NO"));
        System.out.println("Is 'grad' a Student?     " + (isStudent ? "✅ YES" : "❌ NO (GradStudent IS-A Student)"));
        System.out.println("Is 'grad' a Person?      " + (isPerson ? "✅ YES" : "❌ NO (Student IS-A Person)"));
        System.out.println("Is 'grad' an Object?     " + (isObject ? "✅ YES" : "❌ NO (Every class inherits Object)"));

        System.out.println("\n--- Explicit Polymorphic Variable Assignment ---");
        // A variable of a super type can safely point to an instance of a subtype
        Student studentReference = grad; 
        Person personReference = grad;   

        System.out.println("Referenced via Student variable: " + studentReference.getName() + " (ID: " + studentReference.getStudentId() + ")");
        System.out.println("Referenced via Person variable : " + personReference.getName());
    }
}