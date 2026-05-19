package org.example.backend.repository.impl;

import org.example.Enums.PositionEnum;
import org.example.backend.repository.IPositionRepository;
import org.example.entity.Position;
import org.example.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PositionRepositoryimpl implements IPositionRepository {

    @Override
    public List<Position> findAllPosition() {
        List<Position> positions = new ArrayList<>();

        String query = "SELECT * FROM position";
        try (
                Connection connection = DBConnection.getConnection();

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                Position position = new Position();
                position.setId(resultSet.getInt("PositionID"));
                position.setName(PositionEnum.valueOf(resultSet.getString("PositionName")));

                positions.add(position);
            }
            DBConnection.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public List<Position> findByPositionIdAndName(int searchId, String searchName) {
        List<Position> positions = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT * FROM Position WHERE PositionID =? AND PositionName LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, searchId);
            preparedStatement.setString(2, searchName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("PositionID");
                String name = resultSet.getString("PositionName");

                Position position = new Position(id, PositionEnum.valueOf(name));
                positions.add(position);
            }
        DBConnection.closeConnection(connection, preparedStatement, resultSet);

        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return positions;
    }

    @Override
    public boolean insertPositionName(String newName) {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "insert into Position (PositionName) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newName);
            int add = preparedStatement.executeUpdate();
            DBConnection.closeConnection(connection, preparedStatement, null);
            return add > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePosition(int idName) {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "delete from Position where PositionID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idName);

            int c = preparedStatement.executeUpdate();
            DBConnection.closeConnection(connection, preparedStatement, null);
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePosition(int id, String updateName) {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "update Position set PositionName = ? where PositionID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updateName);
            preparedStatement.setInt(2, id);
            int c = preparedStatement.executeUpdate();
            DBConnection.closeConnection(connection, preparedStatement, null);
            return  c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Position> getPositionHasMaxEmployee() {
        List<Position> positions = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT p.PositionName, COUNT(a.AccountID) AS Employee_Count FROM `Position` p\n" +
                    "JOIN `Account` a ON p.PositionID = a.PositionID\n" +
                    "GROUP BY p.PositionID\n" +
                    "HAVING COUNT(a.AccountID) = (\n" +
                    "\t\t\tSELECT MAX(Employee_Count) \n" +
                    "            FROM (\n" +
                    "\t\t\t\tSELECT COUNT(*) AS Employee_Count\n" +
                    "                FROM `Account` a\n" +
                    "                GROUP BY a.PositionID\n" +
                    "            ) AS temp\n" +
                    ");";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Position position = new Position();
                position.setName(PositionEnum.valueOf(resultSet.getString("PositionName")));
                position.setCount(resultSet.getInt("Employee_Count"));

                positions.add(position);

            }
        DBConnection.closeConnection(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public List<Position> getPositionHasMinEmployee() {
        List<Position> positions = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT p.PositionName, COUNT(a.AccountID) AS Employee_Count FROM `Position` p\n" +
                    "JOIN `Account` a ON p.PositionID = a.PositionID\n" +
                    "GROUP BY p.PositionID\n" +
                    "HAVING COUNT(a.AccountID) = (\n" +
                    "\t\t\tSELECT MIN(Employee_Count) \n" +
                    "            FROM (\n" +
                    "\t\t\t\tSELECT COUNT(*) AS Employee_Count\n" +
                    "                FROM `Account` a\n" +
                    "right join `Position` p ON a.PositionID = p.PositionID"+
                    "                GROUP BY a.PositionID\n" +
                    "            ) AS temp\n" +
                    ");";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Position position = new Position();
                position.setName(PositionEnum.valueOf(resultSet.getString("PositionName")));
                position.setCount(resultSet.getInt("Employee_Count"));
                positions.add(position);
            }
        DBConnection.closeConnection(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public boolean checkExistName(String name, Integer id) {
        boolean check = false;
        try {
            // b1: kết nối đến DB
            Connection connection = DBConnection.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from `Position` where PositionName like ? ";
            if (Objects.nonNull(id)) { //id != null
                sql += " and PositionID != ? ";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            if (Objects.nonNull(id)) { //id != null
                preparedStatement.setInt(2, id);
            }
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
}
