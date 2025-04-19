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
       
