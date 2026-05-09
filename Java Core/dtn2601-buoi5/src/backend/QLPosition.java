package backend;

import entity.Position;
import Enum.PositionEnum;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            throw new RuntimeException("Error when fetching accounts", e);
        }
        return positions;
    }

    public static void printPosition() {
        List<Position> positions = getPosition();
        for (Position position : positions) {
            System.out.println(position);
        }
    }

}
