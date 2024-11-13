import java.util.Map;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    // Constructor
    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
