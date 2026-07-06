import java.util.Arrays;

public class AttendanceRanking {
    
    static class Employee implements Comparable<Employee> {
        int id;
        int attendance;

        Employee(int id, int attendance) {
            this.id = id;
            this.attendance = attendance;
        }

        @Override
        public int compareTo(Employee other) {
            // Sort by attendance descending
            if (this.attendance != other.attendance) {
                return Integer.compare(other.attendance, this.attendance);
            }
            // If tied, sort by Employee ID ascending
            return Integer.compare(this.id, other.id);
        }
    }

    public static int[] getTopKEmployees(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            employees[i] = new Employee(employeeIds[i], attendance[i]);
        }

        // Sort using the custom compare properties
        Arrays.sort(employees);

        // Extract top K elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = employees[i].id;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test with the example data
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int k = 3;

        int[] topK = getTopKEmployees(employeeIds, attendance, k);
        System.out.println(Arrays.toString(topK)); // Output: [103, 101, 104]
    }
}