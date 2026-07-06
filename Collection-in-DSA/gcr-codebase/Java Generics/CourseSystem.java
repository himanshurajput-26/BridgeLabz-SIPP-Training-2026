import java.util.List;

// Abstract course type evaluation strategies
abstract class CourseType {
    private final String code;

    public CourseType(String code) { 
        this.code = code; 
    }

    public String getCode() { 
        return code; 
    }
}

class ExamCourse extends CourseType { 
    public ExamCourse(String code) { 
        super(code); 
    } 
}

class AssignmentCourse extends CourseType { 
    public AssignmentCourse(String code) { 
        super(code); 
    } 
}

// Generic Course container
class Course<T extends CourseType> {
    private final String courseName;
    private final T evaluationType;

    public Course(String courseName, T evaluationType) {
        this.courseName = courseName;
        this.evaluationType = evaluationType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getEvaluationType() {
        return evaluationType;
    }

    // Process lists of mixed courses dynamically using nested wildcards
    public static void processCourses(List<? extends Course<? extends CourseType>> dynamicCourses) {
        for (Course<? extends CourseType> course : dynamicCourses) {
            System.out.println("Course: " + course.getCourseName() + 
                               " | Evaluation Code: " + course.getEvaluationType().getCode());
        }
    }
}