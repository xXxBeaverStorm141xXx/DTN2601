package backend;

import entity.Position;
import Enum.PositionEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLPosition {
    public static List<Position> getPosition() {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positions;
    }

    public static void printPosition(List<Position> positions) {
        for (Position position : positions) {
            System.out.println(position);
        }
    }
    public static List<Position> findByPositionIdAndName(int searchId, String searchName)
    {
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


        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return positions;
    }

    public static boolean insertPositionName(String newName) {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "insert into Position (PositionName) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newName);
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

    public static boolean deletePosition(String deleteName) {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "delete from Position where PositionName like ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, deleteName);

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


    public static boolean updatePosition(int id, String updateName) {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "update Position set PositionName = ? where PositionID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updateName);
            preparedStatement.setInt(2, id);

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

    public static void getPositionHasMaxEmployee(){
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
                String name = resultSet.getString("PositionName");
                int count = resultSet.getInt("Employee_Count");

                System.out.println("Position Name: " + name);
                System.out.println("Position Count: " + count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getPositionHasMinEmployee(){
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
                    "                GROUP BY a.PositionID\n" +
                    "            ) AS temp\n" +
                    ");";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("PositionName");
                int count = resultSet.getInt("Employee_Count");

                System.out.println("Position Name: " + name);
                System.out.println("Position Count: " + count);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
