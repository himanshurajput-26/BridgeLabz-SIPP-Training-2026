class InterviewBot {
    // Variable Declarations
    private String botName;
    private String technology;

    // Constructor utilizing identical parameter names to resolve variable ambiguity
    public InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    public void conductInterview() {
        System.out.println("Greeting! My name is " + this.botName + ". I will be evaluating your expertise regarding " + this.technology + " today.");
    }
}

public class MainBot {
    public static void main(String[] args) {
        // Create 3 separate technical diagnostic platform variants
        InterviewBot bot1 = new InterviewBot("Jarvis", "Java Development & Spring Core");
        InterviewBot bot2 = new InterviewBot("Friday", "Machine Learning & Python Pipelines");
        InterviewBot bot3 = new InterviewBot("Karen", "React Framework Architecture");

        bot1.conductInterview();
        bot2.conductInterview();
        bot3.conductInterview();
    }
}