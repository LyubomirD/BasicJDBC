package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStatement {
    private final Scanner scanner;
    public UpdateStatement(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getUpdate(Connection connection) throws SQLException {
        setUpdate(connection);
    }

    private void setUpdate(Connection connection) throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        statement.executeUpdate(updateValues(scanner));
        System.out.println("Table has been updated");
        statement.close();
    }

    private static String updateValues(Scanner scanner) {
        System.out.println("Update firstname to:");
        String firstName = scanner.next();
        System.out.println("Update lastname to:");
        String lastName = scanner.next();
        System.out.println("Select row that will receive the changes:");
        int id = scanner.nextInt();
        return "UPDATE table2 SET first_name = '" + firstName +"', last_name = '" + lastName + "' WHERE id = " + id + ";";
    }

}
