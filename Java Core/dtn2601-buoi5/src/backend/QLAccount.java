package backend;

import entity.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLAccount {
    public static List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();

        String query = "SELECT * FROM account";
        try (
                Connection connection = DBConnection.getConnection();

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("AccountID"));
                account.setEmail(resultSet.getString("Email"));
                account.setUserName(resultSet.getString("Username"));
                account.setFullName(resultSet.getString("FullName"));
                account.setDepartment(resultSet.getInt("DepartmentID"));
                account.setPosition(resultSet.getInt("PositionID"));
                account.setCreateDate(resultSet.getDate("CreateDate"));

                accounts.add(account);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error when fetching accounts", e);
        }
        return accounts;
    }

    public static void printAccounts() {
        List<Account> accounts = getAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
