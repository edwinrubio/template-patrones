import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentQuery {
    private Connection connection;

    public StudentQuery(Connection connection) {
        this.connection = connection;
    }

    public List<Student> findByAge(int age) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Students WHERE age = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, age);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(mapRowToStudent(resultSet));
                }
            }
        }
        return students;
    }

    private Student mapRowToStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
