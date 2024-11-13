import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Математика", 4);
        grades1.put("Физика", 3);
        grades1.put("Химия", 5);
        students.add(new Student("Алиса", "A1", 1, grades1));

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("Математика", 2);
        grades2.put("Физика", 2);
        grades2.put("Информатика", 3);
        students.add(new Student("Вася", "A1", 1, grades2));

        Map<String, Integer> grades3 = new HashMap<>();
        grades3.put("Математика", 5);
        grades3.put("Литература", 4);
        grades3.put("История", 4);
        students.add(new Student("Мария", "A1", 1, grades3));

        Map<String, Integer> grades4 = new HashMap<>();
        grades4.put("Физика", 3);
        grades4.put("Информатика", 3);
        grades4.put("Биология", 2);
        students.add(new Student("Петр", "A1", 1, grades4));

        Map<String, Integer> grades5 = new HashMap<>();
        grades5.put("Математика", 5);
        grades5.put("Физика", 4);
        grades5.put("Химия", 4);
        grades5.put("Информатика", 5);
        students.add(new Student("Ольга", "A1", 1, grades5));

        removeLowScoringStudents(students);

        advanceStudentsToNextCourse(students);

        printStudents(students, 2);
    }

    public static void removeLowScoringStudents(List<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void advanceStudentsToNextCourse(List<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }
}
