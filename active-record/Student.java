import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Student
    public Student() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    } {
    private int id;
    private String name;
    private String email;
    private int age;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // Active Record methods
    public void save() {
        // Perform INSERT or UPDATE operation based on whether the record exists
        if (id == 0) {
            insert();
        } else {
            update();
        }
    }


    public void delete() {
        if (id != 0) {
            // Perform DELETE operation
            // ...
        }
    }

    public static Student findById(int studentId) {
        // Retrieve a student record from the database by ID
        // ...
        return null; // Return a Student object or null if not found
    }

    public static List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        // Retrieve all student records from the database
        // Populate the 'students' list
        // ...
        return students;
    }

    // Private helper methods for insert and update
    private void insert() {
        // Perform INSERT operation
        // ...
    }

    private void update() {
        // Perform UPDATE operation
        // ...
    }
}
