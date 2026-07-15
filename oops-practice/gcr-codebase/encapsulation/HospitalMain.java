abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public abstract double calculateBill();

    public void displayPatientDetails() {
        System.out.printf("Patient ID: %s | Name: %-12s | Age: %d", patientId, name, age);
    }
}

class InPatient extends Patient {
    private double roomCharges;
    private double treatmentCharges;

    public InPatient(String patientId, String name, int age, double roomCharges, double treatmentCharges) {
        super(patientId, name, age);
        this.roomCharges = roomCharges;
        this.treatmentCharges = treatmentCharges;
    }

    public double getRoomCharges() { return roomCharges; }
    public void setRoomCharges(double roomCharges) { this.roomCharges = roomCharges; }
    public double getTreatmentCharges() { return treatmentCharges; }
    public void setTreatmentCharges(double treatmentCharges) { this.treatmentCharges = treatmentCharges; }

    @Override
    public double calculateBill() {
        return roomCharges + treatmentCharges;
    }
}

class OutPatient extends Patient {
    private double consultationFee;
    private double treatmentCharges;

    public OutPatient(String patientId, String name, int age, double consultationFee, double treatmentCharges) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.treatmentCharges = treatmentCharges;
    }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }
    public double getTreatmentCharges() { return treatmentCharges; }
    public void setTreatmentCharges(double treatmentCharges) { this.treatmentCharges = treatmentCharges; }

    @Override
    public double calculateBill() {
        return consultationFee + treatmentCharges;
    }
}

public class HospitalMain {
    public static void main(String[] args) {
        Patient ip = new InPatient("IP-501", "David Wright", 45, 1200.0, 3500.0);
        Patient op = new OutPatient("OP-902", "Emma Watson", 29, 150.0, 450.0);

        System.out.println("====== MEDICAL DISCHARGE LEDGER ======");
        ip.displayPatientDetails();
        System.out.printf("%n -> Total Bill: $%.2f%n%n", ip.calculateBill());

        op.displayPatientDetails();
        System.out.printf("%n -> Total Bill: $%.2f%n", op.calculateBill());
    }
}