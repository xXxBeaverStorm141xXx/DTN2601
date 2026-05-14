package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/qlnv";
        String username = "root";
        String password = "Phucca7@";// mk mysql
        Connection connection = null;
        try {
            // b1: kết nối đến DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
//            if (connection != null) {
//                System.out.println("Kết nối DB thành công");
//            }
        }  catch (Exception ex) {
            System.out.println("Kết nối DB khong thành công");
        }
        return connection;
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        try{
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(resultSet != null) {
                resultSet.close();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
