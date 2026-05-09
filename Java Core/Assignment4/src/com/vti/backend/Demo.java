package com.vti.backend;

import com.vti.entity.CanBo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    // ket noi voi DB va lay ra du lieu cac canbo
    public static void getCanBo() throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/qlcb";
        String username = "root";
        String password = "dong";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,username,password);
        if (conn != null)
        {
            System.out.println("Connected to the database");
        }
        String query = "select * from can_bo";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<CanBo> canBoList = new ArrayList<>();
        while (resultSet.next())
        {
            String fullName = resultSet.getString("full_name");
            int age = resultSet.getInt("age");
            

        }
    }
}
