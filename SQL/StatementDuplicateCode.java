package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDuplicateCode {

    public void getStatementCommand(Connection connection, String sql, String taskCompleteMessage) throws SQLException {
        setStatementCommand(connection, sql, taskCompleteMessage);
    }

    private void setStatementCommand(Connection connection, String sql, String taskCompleteMessage) throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int rows = statement.executeUpdate(sql);

        if (rows > 0) {
            System.out.println(taskCompleteMessage);
        }
        statement.close();
    }

}
