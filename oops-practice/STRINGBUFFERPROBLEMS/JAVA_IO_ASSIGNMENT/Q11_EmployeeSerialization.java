import java.io.*;

class Employee implements Serializable {

    int id;
    String name;
    String dept;
    double salary;

    Employee(int id, String name,
             String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

public class Q11_EmployeeSerialization {

    public static void main(String[] args)
            throws Exception {

        Employee e =
                new Employee(1,
                        "Yash",
                        "IT",
                        50000);

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("emp.dat"));

        out.writeObject(e);
        out.close();

        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream("emp.dat"));

        Employee emp =
                (Employee) in.readObject();

        System.out.println(emp.name);

        in.close();
    }
}