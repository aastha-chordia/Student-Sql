/*
Aastha Chordia
23070126003
AIML A1
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;
        
         do {
            System.out.println("\n--- Student Data Entry Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by PRN");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
             
            switch (choice) {
                case 1: service.addStudent(scanner); break;
                case 2: service.displayAllStudents(); break;
                case 3: service.searchStudent(scanner); break;
                case 4: service.deleteStudent(scanner); break;
                case 5: service.updateStudent(scanner); break;
                case 6: System.out.println("Exiting application."); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }
}
