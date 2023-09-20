import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root")) {
            StudentQuery studentQuery = new StudentQuery(connection);

            int targetAge = 25;
            List<Student> students = studentQuery.findByAge(targetAge);

            for (Student student : students) {
                System.out.println("Student: " + student.getName() + ", Age: " + student.getAge());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
