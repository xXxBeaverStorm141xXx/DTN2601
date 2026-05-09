package backend;


import entity.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment {
    public static List<Department> getDepartment() {
        List<Department> departments = new ArrayList<>();

        String query = "SELECT * FROM department";
        try (
                Connection connection = DBConnection.getConnection();

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("DepartmentID"));
                department.setName(resultSet.getString("DepartmentName"));

                departments.add(department);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error when fetching accounts", e);
        }
        return departments;
    }

    public static void printDepartment() {
        List<Department> departments = getDepartment();
        for (Department department : departments) {
            System.out.println(department);
        }
    }

}
