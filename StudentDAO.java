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
    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            list.add(new Student(
                rs.getString("name"),
                rs.getLong("prn"),
                rs.getString("branch"),
                rs.getString("batch"),
                rs.getDouble("cgpa")
            ));
        }
        return list;
    }
