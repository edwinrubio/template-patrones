import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTableGateway {
    private Connection connection;

    public EmployeeTableGateway(Connection connection) {
        this.connection = connection;
    }

    public void insert(Employee employee) throws SQLException {
        String sql = "INSERT INTO Employees (name, email, salary) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setDouble(3, employee.getSalary());
            statement.executeUpdate();
        }
    }

    public Employee findById(int id) throws SQLException {
        String sql = "SELECT * FROM Employees WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapRowToEmployee(resultSet);
                }
            }
        }
        return null; // Employee not found
    }

    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employees";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                employees.add(mapRowToEmployee(resultSet));
            }
        }
        return employees;
    }

    public void update(Employee employee) throws SQLException {
        String sql = "UPDATE Employees SET name=?, email=?, salary=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setDouble(3, employee.getSalary());
            statement.setInt(4, employee.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Employees WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private Employee mapRowToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setEmail(resultSet.getString("email"));
        employee.setSalary(resultSet.getDouble("salary"));
        return employee;
    }
}
