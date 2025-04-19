import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection connection;
    public StudentDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "aastha123"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addStudent(Student student) throws SQLException, StudentAlreadyExistsException {
        if (getStudent(student.getPrn()) != null) {
            throw new StudentAlreadyExistsException("Student with PRN already exists.");
        }

     String query = "INSERT INTO students (prn, name, branch, batch, cgpa) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setLong(1, student.getPrn());
        stmt.setString(2, student.getName());
        stmt.setString(3, student.getBranch());
        stmt.setString(4, student.getBatch());
        stmt.setDouble(5, student.getCgpa());
        stmt.executeUpdate();
    }

    
