import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataMapper {
    private Connection connection;

    public StudentDataMapper(Connection connection) {
        this.connection = connection;
    }

    public void insert(Student student) {
        // Perform INSERT operation
        // ...
    }

    public Student findById(int studentId) {
        // Retrieve a student record from the database by ID
        // ...
        return null; // Return a Student object or null if not found
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        // Retrieve all student records from the database
        // Populate the 'students' list
        // ...
        return students;
    }

    public void update(Student student) {
        // Perform UPDATE operation
        // ...
    }

    public void delete(int studentId) {
        // Perform DELETE operation
        // ...
    }
}
