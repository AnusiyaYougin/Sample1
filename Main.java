import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService service = new StudentService();

        int choice;

        do {

            System.out.println("\n=======================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("=======================================\n");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort Students by Name");
            System.out.println("7. Sort Students by Marks");
            System.out.println("8. Search Students by Course");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();

                    Student student =
                            new Student(id, name, age, course, marks);

                    service.addStudent(student);

                    break;

                case 2:

                    service.displayStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = scanner.nextInt();

                    service.searchStudent(searchId);

                    break;

                case 4:

                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();

                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();

                    service.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newCourse,
                            newMarks
                    );

                    break;

                case 5:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();

                    service.deleteStudent(deleteId);

                    break;

                case 6:

                    service.sortByName();

                    service.displayStudents();

                    break;

                case 7:

                    service.sortByMarks();

                    service.displayStudents();

                    break;

                case 8:

                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String searchCourse = scanner.nextLine();

                    service.searchByCourse(searchCourse);

                    break;

                case 9:

                    System.out.println("Thank you for using Student Management System!");

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 9);

        scanner.close();
    }
}