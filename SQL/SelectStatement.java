package SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStatement {
    public void getSelect(Connection connection) throws SQLException {
        setSelect(connection);
    }

    private void setSelect(Connection connection) throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = statement.executeQuery(selectValues());

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");

            System.out.format("%s, %s, %s\n", id, firstName, lastName);
        }
        statement.close();
    }

    private static String selectValues() {
        return "SELECT * FROM table2";
    }
}


