package org.example.backend.repository.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.entity.Department;
import org.example.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentRepositoryimpl implements IDepartmentRepository {
    @Override
    public List<Department> findAllDepartment()
    {
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
            // close cac ket noi
            DBConnection.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public List<Department> findByDepartmentIdAndName(int searchId, String searchName)
    {
        List<Department> departments = new ArrayList<>(); // lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String query = "SELECT * FROM department WHERE DepartmentID =? AND DepartmentName LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // set dia chi cho dau ?
            preparedStatement.setInt(1, searchId);
            preparedStatement.setString(2, searchName);
            // thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {// lặp qua qua từng dòng của rs
                int id = resultSet.getInt("DepartmentID");
                String name = resultSet.getString("DepartmentName");

                Department department = new Department(id, name);
                departments.add(department);
            }

            DBConnection.closeConnection(connection, preparedStatement, resultSet);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return departments;
    }
    @Override
    public boolean insertDepartmentName(String newName) {
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String query = "insert into Department (DepartmentName) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // set dia chi cho dau ?
            preparedStatement.setString(1, newName);
            // thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            int add = preparedStatement.executeUpdate();
            DBConnection.closeConnection(connection, preparedStatement, null);
            return add > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteDerpartment(int id) {
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: tiến hành xóa department
            String query = "delete from department where DepartmentID =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            DBConnection.closeConnection(connection, preparedStatement, null);
            return c > 0;

        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    // update phòng ban theo id
    // nhập vào id phòng ban cần sửa: 1
    // nhập ten phòng ban muốn sửa: MARKETING_UPDATE
    @Override
    public boolean updateDepartment(int id, String updateName) {
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: tiến hành update department
            String query = "update department set DepartmentName = ? where DepartmentID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updateName);
            preparedStatement.setInt(2, id);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            DBConnection.closeConnection(connection, preparedStatement, null);
            return c > 0;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    @Override
    public List<Department> getDepartmentHasMaxEmployee(){
        List<Department> departments = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT d.DepartmentName, COUNT(a.AccountID) AS Employee_Count FROM Department d\n" +
                    "JOIN `Account` a ON d.DepartmentID = a.DepartmentID\n" +
                    "GROUP BY d.DepartmentID\n" +
                    "HAVING COUNT(a.AccountID) = (\n" +
                    "\t\t\tSELECT MAX(Employee_Count) \n" +
                    "            FROM (\n" +
                    "\t\t\t\tSELECT COUNT(*) AS Employee_Count\n" +
                    "                FROM `Account` a\n" +
                    "                GROUP BY a.DepartmentID\n" +
                    "            ) AS temp\n" +
                    ")\n";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Department department = new Department();
                department.setName(resultSet.getString("DepartmentName"));
                department.setCount(resultSet.getInt("Employee_Count"));

                departments.add(department);
            }
        DBConnection.closeConnection(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public List<Department> getDepartmentHasMinEmployee(){
        List<Department> departments = new ArrayList<>();
        String query = "SELECT d.DepartmentName, COUNT(a.AccountID) AS Employee_Count FROM Department d\n" +
                "left JOIN `Account` a ON d.DepartmentID = a.DepartmentID\n" +
                "GROUP BY d.DepartmentID\n" +
                "HAVING COUNT(a.AccountID) = (\n" +
                "\t\t\t\t\t\tSELECT MIN(Employee_Count) \n" +
                "\t\t\t\t\t\tFROM (\n" +
                "\t\t\t\t\t\t\tSELECT COUNT(a.AccountID) AS Employee_Count\n" +
                "\t\t\t\t\t\t\tFROM `Account` a\n" +
                "right join Department d ON a.DepartmentID = d.DepartmentID\n" +
                "\t\t\t\t\t\t\tGROUP BY d.DepartmentID\n" +
                "\t\t\t\t\t\t) AS temp\n" +
                ");";
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Department department = new Department();
                department.setName(resultSet.getString("DepartmentName"));
                department.setCount(resultSet.getInt("Employee_Count"));
                departments.add(department);

            }
        DBConnection.closeConnection(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public boolean checkExistName(String name, Integer id) {
        boolean check = false;
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "select * from Department where DepartmentName like ? ";
            if (Objects.nonNull(id)) {
                sql += " and DepartmentID != ? ";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            if (Objects.nonNull(id)) {
                preparedStatement.setInt(2, id);
            }
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check = true;
            }
            DBConnection.closeConnection(connection, preparedStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
