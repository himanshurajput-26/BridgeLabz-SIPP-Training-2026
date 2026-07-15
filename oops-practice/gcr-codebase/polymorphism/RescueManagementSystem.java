class RescueTeam {
    protected String teamId; // [cite: 312]
    protected String location; // [cite: 313]

    public RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    public void performDuty() { // [cite: 315]
        System.out.println("Team " + teamId + " is preparing deployment configurations.");
    }
}

class MedicalTeam extends RescueTeam { // [cite: 306]
    public MedicalTeam(String id, String loc) { super(id, loc); }
    @Override public void performDuty() { System.out.println("[MEDICAL] Team " + teamId + " has established a field triage unit at " + location + "."); } // [cite: 316]
}

class FireRescueTeam extends RescueTeam { // [cite: 307]
    public FireRescueTeam(String id, String loc) { super(id, loc); }
    @Override public void performDuty() { System.out.println("[FIRE-RESCUE] Team " + teamId + " is extracting structural survivors trapped at " + location + "."); } // [cite: 316]
}

class FoodSupplyTeam extends RescueTeam { // [cite: 308]
    public FoodSupplyTeam(String id, String loc) { super(id, loc); }
    @Override public void performDuty() { System.out.println("[FOOD-SUPPLY] Team " + teamId + " is distributing essential ration packs across " + location + "."); } // [cite: 316]
}

public class RescueManagementSystem {
    // Requirements: Find deployment instances by location string [cite: 319]
    public static void findTeamByLocation(RescueTeam[] teams, String location) {
        System.out.println("\nQuerying Active Units Deployed to: " + location);
        for (RescueTeam t : teams) {
            if (t.location.equalsIgnoreCase(location)) {
                System.out.print(" -> ");
                t.performDuty(); // [cite: 321]
            }
        }
    }

    // Requirements: Dynamic prefix evaluation framework [cite: 320]
    public static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        System.out.println("\nMatching Active Operational Node IDs using prefix filter \"" + prefix + "\":");
        for (RescueTeam t : teams) {
            if (t.teamId.toUpperCase().startsWith(prefix.toUpperCase())) {
                System.out.println(" -> Registered ID: " + t.teamId + " located at sector: " + t.location);
            }
        }
    }

    // Requirements: High-tier analysis mapping allocation matrices [cite: 322, 323]
    public static void processTeamMetrics(RescueTeam[] teams) {
        int medical = 0, fire = 0, food = 0;
        
        for (RescueTeam t : teams) {
            if (t instanceof MedicalTeam) medical++;
            else if (t instanceof FireRescueTeam) fire++;
            else if (t instanceof FoodSupplyTeam) food++;
        }

        System.out.println("\n--- Operational Allocation Balance Sheet ---");
        System.out.println("Medical Contingents: " + medical + " | Fire Crews: " + fire + " | Supply Clusters: " + food); // [cite: 322]

        // Find the team category with maximum deployments [cite: 323]
        String dominantCategory = "Medical Team";
        int maxVal = medical;

        if (fire > maxVal) {
            maxVal = fire;
            dominantCategory = "FireRescue Team";
        }
        if (food > maxVal) {
            maxVal = food;
            dominantCategory = "Food Supply Team";
        }
        System.out.println("Strategic Highest Deployment Concentration: " + dominantCategory + " (" + maxVal + " Units Assigned)"); // [cite: 323]
    }

    public static void main(String[] args) {
        RescueTeam[] disasterControlGrid = { // [cite: 318]
            new MedicalTeam("MED-Alpha", "Sector-1"),
            new FireRescueTeam("FIRE-Zulu", "Sector-2"),
            new FoodSupplyTeam("SUPP-Omega", "Sector-1"),
            new MedicalTeam("MED-Beta", "Sector-3"),
            new FoodSupplyTeam("SUPP-Sigma", "Sector-1")
        };

        System.out.println("=== Initiating Critical Duty Directives ===");
        for (RescueTeam t : disasterControlGrid) t.performDuty(); // [cite: 321]

        processTeamMetrics(disasterControlGrid); // [cite: 322, 323]
        findTeamByLocation(disasterControlGrid, "Sector-1"); // [cite: 319]
        displayTeamsByPrefix(disasterControlGrid, "MED"); // [cite: 320]
    }
}