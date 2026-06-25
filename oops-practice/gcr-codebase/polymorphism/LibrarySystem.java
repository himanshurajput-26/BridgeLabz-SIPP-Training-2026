class LibraryMember {
    protected String memberName; // [cite: 231]
    protected String memberId; // [cite: 232]

    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public double calculateFine(int overdueDays) { // [cite: 234]
        return 0.0; 
    }

    public void displayDetails() { // [cite: 238]
        System.out.print("ID: " + memberId + " | Name: " + memberName);
    }
}

class StudentMember extends LibraryMember { // [cite: 225]
    public StudentMember(String name, String id) { super(name, id); }
    @Override
    public double calculateFine(int overdueDays) { return overdueDays * 2.0; } // ₹2 per day [cite: 235]
}

class FacultyMember extends LibraryMember { // [cite: 226]
    public FacultyMember(String name, String id) { super(name, id); }
    @Override
    public double calculateFine(int overdueDays) { return overdueDays * 5.0; } // ₹5 per day [cite: 235]
}

class GuestMember extends LibraryMember { // [cite: 227]
    public GuestMember(String name, String id) { super(name, id); }
    @Override
    public double calculateFine(int overdueDays) { return overdueDays * 10.0; } // ₹10 per day [cite: 235]
}

public class LibrarySystem {
    public static void searchMemberById(LibraryMember[] members, String id) { // 
        System.out.println("\nSearching for Member ID: [" + id + "]...");
        boolean found = false;
        for (LibraryMember m : members) {
            if (m.memberId.equalsIgnoreCase(id)) {
                System.out.print("Match Located -> ");
                m.displayDetails();
                System.out.println(" | Accrued Fine for 5 Overdue Days: ₹" + m.calculateFine(5)); // [cite: 239]
                found = true;
                break;
            }
        }
        if (!found) System.out.println("System Alert: No active records associate with ID: " + id);
    }

    public static void main(String[] args) {
        LibraryMember[] register = { // [cite: 237]
            new StudentMember("Aman", "STU-441"),
            new FacultyMember("Dr. Sharma", "FAC-902"),
            new GuestMember("Vikram", "GST-108")
        };

        System.out.println("=== Printing All Registered Members ===");
        for (LibraryMember m : register) {
            m.displayDetails();
            System.out.println(); // [cite: 238]
        }

        searchMemberById(register, "FAC-902"); // 
    }
}