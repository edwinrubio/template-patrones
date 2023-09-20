import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.6:3306/pruebas", "root", "test")) {
            EmployeeTableGateway gateway = new EmployeeTableGateway(connection);

            // Insert
            Employee newEmployee = new Employee();
            newEmployee.setName("Edwin pruebas");
            newEmployee.setEmail("edwin@allfait.com");
            newEmployee.setSalary(50000);
            gateway.insert(newEmployee);

            // Find by ID
            Employee foundEmployee = gateway.findById(1);
            System.out.println("Empleado encontrado: " + foundEmployee.getName());

            // Find all employees
            List<Employee> allEmployees = gateway.findAll();
            for (Employee employee : allEmployees) {
                System.out.println("Empleado: " + employee.getName());
            }

            // Update
            foundEmployee.setSalary(55000);
            gateway.update(foundEmployee);

            // Delete
            gateway.delete(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
