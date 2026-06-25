// Base class Person
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

// Subclass Student extending Person
class Student extends Person {
    private final String studentId; // Must be initialized in the constructor
    private double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        super(name, age); // Chaining to Person constructor
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId + ", GPA: " + gpa;
    }
}

// Subclass GradStudent extending Student
class GradStudent extends Student {
    private String thesisTitle;

    public GradStudent(String name, int age, String studentId, double gpa, String thesisTitle) {
        super(name, age, studentId, gpa); // Chaining to Student constructor
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String toString() {
        return super.toString() + ", Thesis: \"" + thesisTitle + "\"";
    }
}