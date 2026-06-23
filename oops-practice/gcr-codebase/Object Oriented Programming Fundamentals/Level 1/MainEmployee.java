class Employee {
    // Attributes
    private String name;
    private int id;
    private double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}

public class MainEmployee {
    public static void main(String[] args) {
        Employee emp = new Employee("Himanshu Rajput", 101, 75000.0);
        emp.displayDetails();
    }
}