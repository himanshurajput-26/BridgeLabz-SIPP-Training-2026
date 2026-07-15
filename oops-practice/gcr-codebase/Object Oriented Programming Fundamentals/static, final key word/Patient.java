class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    String name;
    int age;
    String ailment;
    final int patientID;

    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Patient ID: " + patientID);
    }

    public static void main(String[] args) {
        Patient p = new Patient("Riya", 24, "Fever", 501);

        if (p instanceof Patient) {
            p.display();
        }

        getTotalPatients();
    }
}