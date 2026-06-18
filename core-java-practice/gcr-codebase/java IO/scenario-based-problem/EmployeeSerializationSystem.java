import java.io.*;
import java.util.Scanner;

// Implement Serializable interface to unlock binary conversions
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int employeeId;
    private String name;
    private String department;
    private double salary;

    public Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee Details [ID=" + employeeId + ", Name=" + name + 
               ", Department=" + department + ", Salary=₹" + salary + "]";
    }
}

public class EmployeeSerializationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filepath = "employee.ser";

        // 1. Gather Employee Information
        System.out.println("=== Enter Employee Details ===");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear scanner buffer
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();
        
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        Employee empObj = new Employee(id, name, dept, salary);

        // 2. Serialization Step
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(empObj);
            System.out.println("\nEmployee object serialized successfully.");
        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }

        // 3. Deserialization Step
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            Employee recoveredEmp = (Employee) ois.readObject();
            System.out.println("\n=== Recovered Employee Information ===");
            System.out.println(recoveredEmp);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}