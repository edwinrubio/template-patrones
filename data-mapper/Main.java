public class Main {
    public static void main(String[] args) {
        // Create a new student
        Student student = new Student();
        student.setName("Alice");
        student.setEmail("alice@example.com");
        student.setAge(25);

        // Create a StudentDataMapper instance
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password")) {
            StudentDataMapper studentMapper = new StudentDataMapper(connection);

            // Insert the student record into the database
            studentMapper.insert(student);

            // Find a student by ID
            Student foundStudent = studentMapper.findById(1);
            if (foundStudent != null) {
                System.out.println("Found student: " + foundStudent.getName());
            }

            // Retrieve all students
            List<Student> allStudents = studentMapper.findAll();
            for (Student s : allStudents) {
                System.out.println("Student: " + s.getName());
            }

            // Update a student record
            foundStudent.setName("Updated Name");
            studentMapper.update(foundStudent);

            // Delete a student record
            studentMapper.delete(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
