package backend;

import entity.Account;
import entity.Department;
import entity.Position;
import Enum.PositionEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLAccount {
    public static List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();

        String query = "SELECT a.*, d.DepartmentName, p.PositionName " +
                "FROM Account a " +
                "LEFT JOIN Department d ON a.DepartmentID = d.DepartmentID " +
                "LEFT JOIN Position p ON a.PositionID = p.PositionID";
        try (
                Connection connection = DBConnection.getConnection();

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("DepartmentID"));
                department.setName(resultSet.getString("DepartmentName"));

                Position position = new Position();
                position.setId(resultSet.getInt("PositionID"));
                position.setName(PositionEnum.valueOf(resultSet.getString("PositionName")));
                Account account = new Account();

                account.setId(resultSet.getInt("AccountID"));
                account.setEmail(resultSet.getString("Email"));
                account.setUserName(resultSet.getString("Username"));
                account.setFullName(resultSet.getString("FullName"));
                account.setDepartment(department);
                account.setPosition(position);
                account.setCreateDate(resultSet.getDate("CreateDate"));

                accounts.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public static void printAccounts(List<Account> accounts) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public static List<Account> findByAccountIdAndName(int searchId, String searchUserName) {
        List<Account> accounts = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT a.AccountID, a.FullName, a.Email, d.DepartmentID , d.DepartmentName, p.PositionID , p.PositionName "+
                    "FROM account a "+
                    "JOIN department d ON a.DepartmentID = d.DepartmentID "+
                    "JOIN position p ON a.PositionID = p.PositionID "+
                    "WHERE AccountID =? AND Username =? ";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, searchId);
            prepareStatement.setString(2, searchUserName);

            ResultSet rs = prepareStatement.executeQuery();

            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("DepartmentID"));
                department.setName(rs.getString("DepartmentName"));

                Position position = new Position();
                position.setId(rs.getInt("PositionID"));
                position.setName(PositionEnum.valueOf(rs.getString("PositionName")));

                Account account = new Account();
                account.setId(rs.getInt("AccountID"));
                account.setFullName(rs.getString("FullName"));
                account.setEmail(rs.getString("Email"));
                account.setDepartment(department);
                account.setPosition(position);

                accounts.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public static boolean insertAccount(String newEmail, String newUserName, String newFullName, int newDepartmentId, int newPositionId) {
        try {

            Connection connection = DBConnection.getConnection();

            String query = "insert into account (Email, Username, FullName, DepartmentID, PositionID) values (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newEmail);
            preparedStatement.setString(2, newUserName);
            preparedStatement.setString(3, newFullName);
            preparedStatement.setInt(4, newDepartmentId);
            preparedStatement.setInt(5, newPositionId);

            int c = preparedStatement.executeUpdate();
            if (c > 0) {
                return true;
            }  else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteAccount(String deleteUserName) {
        try {

            Connection connection = DBConnection.getConnection();

            String query = "delete from `Account` where Username like ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, deleteUserName);

            int c = preparedStatement.executeUpdate();
            if (c > 0) {
                return true;
            }  else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateAccount(int id, String updateEmail, String updateFullName, String updateUserName, int updateDepartmentId, int updatePositionId) {
        try {

            Connection connection = DBConnection.getConnection();

            String query = "UPDATE `Account` SET Email = ? , FullName = ?, Username = ?, DepartmentID = ?, PositionID = ?\n" +
                    "Where AccountID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updateEmail);
            preparedStatement.setString(2, updateFullName);
            preparedStatement.setString(3, updateUserName);
            preparedStatement.setInt(4, updateDepartmentId);
            preparedStatement.setInt(5, updatePositionId);
            preparedStatement.setInt(6, id);

            int c = preparedStatement.executeUpdate();
            if (c > 0) {
                return true;
            }  else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
