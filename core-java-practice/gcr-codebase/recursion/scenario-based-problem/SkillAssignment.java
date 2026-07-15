import java.util.ArrayList;
import java.util.List;

public class SkillAssignment {
    public static void findTeams(int[] skills, int target, int index, List<Integer> currentTeam) {
        // Base Case 1: Target reached
        if (target == 0) {
            System.out.println(currentTeam);
            return;
        }
        // Base Case 2: Out of bounds or target exceeded
        if (index == skills.length || target < 0) {
            return;
        }

        // Choice 1: Include the current employee's skill score
        currentTeam.add(skills[index]);
        // Note: Using 'index + 1' assuming each employee score can only be used once.
        findTeams(skills, target - skills[index], index + 1, currentTeam);
        
        // Backtrack
        currentTeam.remove(currentTeam.size() - 1);

        // Choice 2: Exclude the current employee's skill score
        findTeams(skills, target, index + 1, currentTeam);
    }

    public static void main(String[] args) {
        int[] skills = {2, 3, 5, 7}; // Correcting typo in assignment sheet [cite: 105]
        int target = 10;             // [cite: 106]
        
        findTeams(skills, target, 0, new ArrayList<>()); 
        // Expected Outputs: [2, 3, 5] and [3, 7] [cite: 108, 109]
    }
}