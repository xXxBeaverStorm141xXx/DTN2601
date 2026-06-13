package org.example.backend.repository.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.entity.Department;
import org.example.utils.DBConnection;

import java.sql.*;
import java.util.*;

public class DepartmentRepositoryimpl implements IDepartmentRepository {
    // lấy ra toàn bộ department
    @Override
    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from Department order by DepartmentID asc;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("DepartmentID");// lấy giá trị từ cloumn department_id
                String name = rs.getString("DepartmentName");//lấy giá trị từ cloumn department_name

                Department dep = new Department(id, name);
                departments.add(dep);
            }
            // đóng các kết nối
            DBConnection.closeConnection(connection, statement, rs);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return departments;
    }

    // them 1 department
    @Override
    public boolean create(String name) {
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: tiến hành thêm mới department
            String sql = "insert into Department (DepartmentName) values (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            DBConnection.closeConnection(connection, preparedStatement, null);
            return c > 0;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }



    @Override
    public boolean createDepartments(List<Department> departments) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // b1: kết nối đến DB
            connection = DBConnection.getConnection();
            connection.setAutoCommit(false);// tắt auto commit để có lỗi thì còn rollback
            // b2: tiến hành thêm mới department
            String sql = "insert into Department (DepartmentName) values (?);";
            preparedStatement = connection.prepareStatement(sql);
            for (Department department : departments) {
                preparedStatement.setString(1, department.getName());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();// thuc thi câu lenh xong
            connection.commit();// ko xảy ra lỗi , lưu dữ liệu vào DB
            DBConnection.closeConnection(connection, preparedStatement, null);
            return true;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            try {
                connection.rollback();// hoàn lại dữ liệu nếu gặp lỗi
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            e.printStackTrace();// show ra exception
        } finally {
            DBConnection.closeConnection(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public Map<String, Department> mapDepartmentByName() {
        Map<String, Department> map = new HashMap<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from Department order by DepartmentID asc;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("DepartmentID");// lấy giá trị từ cloumn department_id
                String name = rs.getString("DepartmentName");//lấy giá trị từ cloumn department_name

                Department dep = new Department(id, name);
                map.put(name, dep);
            }
            // đóng các kết nối
            DBConnection.closeConnection(connection, statement, rs);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return map;
    }

    @Override
    public boolean update(int id, String name) {
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: tiến hành update department
            String sql = "update Department set DepartmentName = ? where DepartmentID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            // đóng các kết nối
            DBConnection.closeConnection(connection, preparedStatement, null);
            return c > 0;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: tiến hành xóa department
            String sql = "delete from Department where DepartmentID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            DBConnection.closeConnection(connection, preparedStatement, null);
            return c > 0;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return false;
    }

    @Override
    public boolean checkExistName(String name, Integer id) {
        boolean check = false;
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from Department where DepartmentName like ? and (DepartmentID != ? or ? is null )";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setObject(2, id);
            preparedStatement.setObject(3, id);
            ResultSet rs = preparedStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {// lặp qua qua từng dòng của rs
                check = true;
            }
            // đóng các kết nối
            DBConnection.closeConnection(connection, preparedStatement, rs);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return check;
    }

    @Override
    public boolean checkExistId(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        boolean check = false;
        try {
            // b1: kết nối đến DB
            connection = DBConnection.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from Department where DepartmentID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {// lặp qua qua từng dòng của rs
                check = true;
            }
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {// luôn luôn thực hiên câu lệnh trong finally cho dù try hoặc catch
            // đóng các kết nối cho dù query thnh cong hay co loi
            DBConnection.closeConnection(connection, preparedStatement, rs);
        }
        return check;
    }
}
