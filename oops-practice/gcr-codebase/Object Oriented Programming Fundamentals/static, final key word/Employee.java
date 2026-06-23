class Employee {
    static String companyName = "TCS";
    static int totalEmployees = 0;

    String name;
    final int id;
    String designation;

    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void display() {
        System.out.println(name + " " + id + " " + designation);
    }

    public static void main(String[] args) {
        Employee e = new Employee("Rahul", 501, "Developer");

        if (e instanceof Employee) {
            e.display();
        }

        displayTotalEmployees();
    }
}