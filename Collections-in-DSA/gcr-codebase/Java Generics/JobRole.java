import java.util.List;

abstract class JobRole {
    private final String title;
    
    public JobRole(String title) { 
        this.title = title; 
    }
    
    public String getTitle() { 
        return title; 
    }
}

class SoftwareEngineer extends JobRole { 
    public SoftwareEngineer() { 
        super("Software Engineer"); 
    } 
}

class DataScientist extends JobRole { 
    public DataScientist() { 
        super("Data Scientist"); 
    } 
}

// Generic Resume container
class Resume<T extends JobRole> {
    private final String applicantName;
    private final T targetRole;

    public Resume(String applicantName, T targetRole) {
        this.applicantName = applicantName;
        this.targetRole = targetRole;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public T getTargetRole() {
        return targetRole;
    }

    // Screening pipeline handling mixed Resume containers dynamically using wildcards
    public static void runScreeningPipeline(List<? extends Resume<? extends JobRole>> executionPipeline) {
        for (Resume<? extends JobRole> resume : executionPipeline) {
            System.out.println("Applicant: " + resume.getApplicantName() + 
                               " | Evaluating alignment for target role: " + resume.getTargetRole().getTitle());
        }
    }
}