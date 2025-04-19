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
