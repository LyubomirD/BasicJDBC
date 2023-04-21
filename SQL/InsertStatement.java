package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStatement {
    private final Scanner scanner;
    public InsertStatement(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getInsert(Connection connection) throws SQLException {
        setInsert(connection);
    }

    private void setInsert(Connection connection) throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int rows = statement.executeUpdate(insertValues(scanner));

        if (rows > 0) {
            System.out.println("A new contact has been added");
        }
        statement.close();
    }

    private static String insertValues(Scanner scanner) {
        System.out.println("Please write your firstname and lastname");
        String firstName = scanner.next();
        String lastName = scanner.next();
        return "INSERT INTO table2 (first_name, last_name) VALUES ('" + firstName + "', '" + lastName + "')";
    }
}
