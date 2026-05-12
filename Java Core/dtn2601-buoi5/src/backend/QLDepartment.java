package backend;


import entity.Department;

import java.sql.*;
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

    public static void printDepartment(List<Department> departments) {
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    // lấy ra ds các phòng ban theo departmentID và departmentName
    // đưa vào departmentID = 1 và departmentName= Marketing, tìm các phòng ban có thông tin như trên
    // "select * from department where department_id = 1 and department_name like 'Marketing';"
    // "select * from department where department_id = 1 or department_name like 'Marketing';"
    public static List<Department> findByDepartmentIdAndName(int searchId, String searchName)
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


        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return departments;
    }
    // với các bài toán thêm , sửa, xóa  thfi trả về boolean,
    // với bài toán tìm kiếm, trả 1 ds
    // thêm 1 department mới, người dùng sẽ nhập vào name, còn id tự động tăng
    // insert, delete, update là câu modify, dùng executeUpdate();
    public static boolean insertDepartmentName(String newName) {
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String query = "insert into Department (DepartmentName) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // set dia chi cho dau ?
            preparedStatement.setString(1, "Phong ban: " + newName);
            // thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            int add = preparedStatement.executeUpdate();
            if (add > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // procedure
    // CallableStatement dùng để call procedure
    public static boolean insertDepartmentProcedure(String newName) {
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: tiến hành thêm mới department bằng  Procedure insert_department()
            String query = "{CALL insert_department(?)}";
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, newName);

            int c = callableStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            if (c > 0) {
                return true;
            }  else {
                return false;
            }
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    // xóa phong ban theo tên
    public static boolean deleteDerpartment(String deleteName) {
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: tiến hành xóa department
            String query = "delete from department where DepartmentName like ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, deleteName);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            if (c > 0) {
                return true;
            }  else {
                return false;
            }
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    // update phòng ban theo id
    // nhập vào id phòng ban cần sửa: 1
    // nhập ten phòng ban muốn sửa: MARKETING_UPDATE
    public static boolean updateDepartment(int id, String updateName) {
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: tiến hành update department
            String query = "update department set DepartmentName = ? where DepartmentID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updateName);
            preparedStatement.setInt(2, id);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            if (c > 0) {
                return true;
            }  else {
                return false;
            }
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    // CRUD department      (CREATE     READ        UPDATE      DELETE)  department

    //Tìm và in phòng ban có nhiều nhân viên nhất
    //Tìm và in phòng ban có ít nhân viên nhất

    public static void getDepartmentHasMaxEmployee(){
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
                String name = resultSet.getString("DepartmentName");
                int count = resultSet.getInt("Employee_Count");

                System.out.println("Department Name: " + name);
                System.out.println("Department Count: " + count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getDepartmentHasMinEmployee(){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT d.DepartmentName, COUNT(a.AccountID) AS Employee_Count FROM Department d\n" +
                    "JOIN `Account` a ON d.DepartmentID = a.DepartmentID\n" +
                    "GROUP BY d.DepartmentID\n" +
                    "HAVING COUNT(a.AccountID) = (\n" +
                    "\t\t\tSELECT MIN(Employee_Count) \n" +
                    "            FROM (\n" +
                    "\t\t\t\tSELECT COUNT(*) AS Employee_Count\n" +
                    "                FROM `Account` a\n" +
                    "                GROUP BY a.DepartmentID\n" +
                    "            ) AS temp\n" +
                    ")\n";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("DepartmentName");
                int count = resultSet.getInt("Employee_Count");

                System.out.println("Department Name: " + name);
                System.out.println("Department Count: " + count);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}