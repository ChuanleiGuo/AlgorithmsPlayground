import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bootstrap {
    public static class Student implements Comparable {
        public String name;
        public Double gpa;

        public int compareTo(Student that) { return this.name.compareTo(that.name); }

        public Student(String name, Double gpa) {
            this.name = name;
            this.gpa = gpa;
        }
    }

    public static void sortByGPA(List<Student> students) {
        Collections.sort(students, Collections.reverseOrder(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.gpa, o2.gpa);
            }
        }));
    }

    public static void sortByName(List<Student> students) {
        Collections.sort(students);
    }
}
