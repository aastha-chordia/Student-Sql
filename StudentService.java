import java.util.Scanner;
import java.util.List;

public class StudentService {
    private StudentDAO dao = new StudentDAO();

    public void addStudent(Scanner scanner) {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("PRN: ");
            long prn = Long.parseLong(scanner.nextLine());
            System.out.print("Branch: ");
            String branch = scanner.nextLine();
            System.out.print("Batch: ");
            String batch = scanner.nextLine();
            System.out.print("CGPA: ");
            double cgpa = Double.parseDouble(scanner.nextLine());

            dao.addStudent(new Student(name, prn, branch, batch, cgpa));
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void displayAllStudents() {
        try {
            List<Student> students = dao.getAllStudents();
            if (students.isEmpty()) System.out.println("No students found.");
            else students.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error fetching students.");
        }
    }

    public void searchStudent(Scanner scanner) {
        try {
            System.out.print("Enter PRN: ");
            long prn = Long.parseLong(scanner.nextLine());
            Student student = dao.getStudent(prn);
            System.out.println(student != null ? student : "Student not found.");
        } catch (Exception e) {
            System.out.println("Error searching student.");
        }
    }

    public void deleteStudent(Scanner scanner) {
        try {
            System.out.print("Enter PRN: ");
            long prn = Long.parseLong(scanner.nextLine());
            dao.deleteStudent(prn);
            System.out.println("Student deleted.");
        } catch (Exception e) {
            System.out.println("Error deleting student.");
        }
    }

    public void updateStudent(Scanner scanner) {
        try {
            System.out.print("Enter PRN: ");
            long prn = Long.parseLong(scanner.nextLine());
            System.out.print("New Name: ");
            String name = scanner.nextLine();
            System.out.print("New Branch: ");
            String branch = scanner.nextLine();
            System.out.print("New Batch: ");
            String batch = scanner.nextLine();
            System.out.print("New CGPA: ");
            double cgpa = Double.parseDouble(scanner.nextLine());

            dao.updateStudent(new Student(name, prn, branch, batch, cgpa));
            System.out.println("Student updated.");
        } catch (Exception e) {
            System.out.println("Error updating student.");
        }
    }
}
