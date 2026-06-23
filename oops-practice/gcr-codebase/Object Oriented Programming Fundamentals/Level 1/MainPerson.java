class Person {
    private String name;
    private int age;

    // Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + " | Age: " + age);
    }
}

public class MainPerson {
    public static void main(String[] args) {
        Person person1 = new Person("Himanshu", 21);
        Person person2 = new Person(person1); // Cloning attributes using copy constructor

        System.out.print("Original: ");
        person1.displayDetails();
        System.out.print("Cloned: ");
        person2.displayDetails();
    }
}