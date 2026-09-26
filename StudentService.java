import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Display all students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n----- Student List -----");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Search student by ID
    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                System.out.println("Student Found:");
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update student
    public void updateStudent(int id, String name, int age,
                              String course, double marks) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(name);
                student.setAge(age);
                student.setCourse(course);
                student.setMarks(marks);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete student
    public void deleteStudent(int id) {

        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {

            Student student = iterator.next();

            if (student.getId() == id) {
                iterator.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Sort by name
    public void sortByName() {

        students.sort(Comparator.comparing(Student::getName));

        System.out.println("Students sorted by name.");
    }

    // Sort by marks
    public void sortByMarks() {

        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());

        System.out.println("Students sorted by marks.");
    }

    // Search by course
    public void searchByCourse(String course) {

        boolean found = false;

        for (Student student : students) {

            if (student.getCourse().equalsIgnoreCase(course)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found for this course.");
        }
    }
}