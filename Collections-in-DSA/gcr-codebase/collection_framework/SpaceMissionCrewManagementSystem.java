import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Astronaut {
    String astronautId; // [cite: 108]
    String name;        // [cite: 109]
    String specialization; // [cite: 110]

    public Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return name + " (" + specialization + ", ID: " + astronautId + ")";
    }
}

public class SpaceMissionCrewManagementSystem {
    private HashMap<String, List<Astronaut>> missionCrewMap; // [cite: 111]
    // Compound key string format: "MissionName:AstronautId" to validate uniqueness efficiently [cite: 114]
    private HashSet<String> assignmentTracker; 

    public SpaceMissionCrewManagementSystem() {
        this.missionCrewMap = new HashMap<>(); // [cite: 111]
        this.assignmentTracker = new HashSet<>(); // [cite: 114]
    }

    // Task 1: Add new missions [cite: 122]
    public void addMission(String missionName) {
        if (!missionCrewMap.containsKey(missionName)) {
            missionCrewMap.put(missionName, new ArrayList<>());
            System.out.println("Mission '" + missionName + "' successfully created.");
        }
    }

    // Task 2 & 3: Assign crew and prevent internal duplicates [cite: 123, 124]
    public void assignAstronautToMission(String missionName, Astronaut astronaut) {
        if (!missionCrewMap.containsKey(missionName)) {
            System.out.println("Mission does not exist! Create it first.");
            return;
        }

        String trackingKey = missionName + ":" + astronaut.astronautId; // [cite: 114]

        if (assignmentTracker.contains(trackingKey)) { // [cite: 114, 124]
            System.out.println("Duplicate Error: Astronaut " + astronaut.name + " is already assigned to " + missionName);
        } else {
            missionCrewMap.get(missionName).add(astronaut); // [cite: 113]
            assignmentTracker.add(trackingKey); // [cite: 114]
            System.out.println("Assigned " + astronaut.name + " to mission " + missionName); // [cite: 115]
        }
    }

    // Task 4 & 5: Display missions, assigned crews, and total counts [cite: 125, 126]
    public void displayMissionDetails() {
        System.out.println("\n--- Space Mission Allocation Overview ---");
        for (Map.Entry<String, List<Astronaut>> entry : missionCrewMap.entrySet()) { // [cite: 116]
            System.out.println("Mission: " + entry.getKey());
            System.out.println("Crew Members Assigned: " + entry.getValue().size()); // [cite: 126]
            for (Astronaut astro : entry.getValue()) {
                System.out.println("  -> " + astro);
            }
            System.out.println("----------------------------------------");
        }
    }

    public static void main(String[] args) {
        SpaceMissionCrewManagementSystem system = new SpaceMissionCrewManagementSystem();
        Astronaut a1 = new Astronaut("A101", "Commander Neil", "Pilot");
        Astronaut a2 = new Astronaut("A102", "Dr. Sally", "Astrophysicist");

        system.addMission("Artemis III");
        system.assignAstronautToMission("Artemis III", a1);
        system.assignAstronautToMission("Artemis III", a2);
        system.assignAstronautToMission("Artemis III", a1); // Duplicate tracking verification [cite: 124]

        system.displayMissionDetails();
    }
}