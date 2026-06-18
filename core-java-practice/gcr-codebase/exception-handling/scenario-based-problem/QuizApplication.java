public class QuizApplication {
    public static void main(String[] args) {
        String answers[] = {"A", "B", "C", "C", "D"};
        String correctKeys[] = {"A", "B", "C", "D", "D"};

        // Running a loop beyond normal size constraints to verify recovery flow
        for (int i = 0; i <= answers.length; i++) {
            try {
                // Potential out-of-bounds trigger when i = 5
                if (answers[i].equals(correctKeys[i])) {
                    System.out.println("Question " + (i + 1) + ": Correct Answer");
                } else {
                    System.out.println("Question " + (i + 1) + ": Incorrect Answer");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Handled Exception at item position " + i + ": Attempted index is invalid.");
            }
        }
        System.out.println("Execution completed: Quiz processing complete.");
    }
}