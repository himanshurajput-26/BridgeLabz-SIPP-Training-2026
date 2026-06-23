abstract class Employee {
    private String employeeId;     // Encapsulated data structures
    private String employeeName;

    public Employee(String employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public abstract double calculateSalary();

    public void displayEmployeeInfo() {
        System.out.println("ID: " + employeeId + " | Name: " + employeeName);
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String employeeId, String employeeName, double monthlySalary) {
        super(employeeId, employeeName);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String employeeId, String employeeName, int hoursWorked, double hourlyRate) {
        super(employeeId, employeeName);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class PayrollMain {
    public static void main(String[] args) {
        Employee ftEmp = new FullTimeEmployee("FT-101", "Alice Vance", 5500.0);
        Employee ptEmp = new PartTimeEmployee("PT-202", "Bob Miller", 80, 25.0);

        System.out.println("====== EMPLOYEE MANAGEMENT SYSTEM ======");
        ftEmp.displayEmployeeInfo();
        System.out.printf("Calculated Salary: $%.2f%n%n", ftEmp.calculateSalary());

        ptEmp.displayEmployeeInfo();
        System.out.printf("Calculated Salary: $%.2f%n", ptEmp.calculateSalary());
    }
}