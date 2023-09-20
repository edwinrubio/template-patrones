public class Main {
    public static void main(String[] args) {
        // Create a new student
        Student student = new Student();
        student.setName("Alice");
        student.setEmail("alice@example.com");
        student.setAge(25);
        
        // Save the student record to the database
        student.save();

        // Find a student by ID
        Student foundStudent = Student.findById(1);
        if (foundStudent != null) {
            System.out.println("Found student: " + foundStudent.getName());
        }

        // Retrieve all students
        List<Student> allStudents = Student.findAll();
        for (Student s : allStudents) {
            System.out.println("Student: " + s.getName());
        }

        // Delete a student record
        student.delete();
    }
}
