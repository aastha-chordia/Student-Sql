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

