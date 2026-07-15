class Employee {
    public String employeeID;       // Public
    protected String department;    // Protected
    private double salary;          // Private

    public Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    // Public method to modify private salary
    public void updateSalary(double newSalary) {
        if (newSalary > salary) {
            this.salary = newSalary;
        }
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    public void displayManagerDetails() {
        // Accessing public employeeID and protected department directly
        System.out.println("Manager ID: " + employeeID + " | Department: " + department + 
                           " | Team Size: " + teamSize + " | Salary: $" + getSalary());
    }
}

public class MainEmployeeRecords {
    public static void main(String[] args) {
        Manager mgr = new Manager("MGR404", "Engineering", 85000.0, 12);
        mgr.displayManagerDetails();
        
        mgr.updateSalary(92000.0);
        mgr.displayManagerDetails();
    }
}