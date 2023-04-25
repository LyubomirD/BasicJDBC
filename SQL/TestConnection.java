package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class TestConnection {
    private final String jdbcURL;
    private final String username;
    private final String password;
    private final InsertStatement insertStatements;
    private final DeleteStatement deleteStatement;
    private final SelectStatement selectStatement;
    private final UpdateStatement updateStatement;
    private final Scanner scanner;

    public TestConnection(String jdbcURL, String username, String password, InsertStatement insertStatements, DeleteStatement deleteStatement, SelectStatement selectStatement, UpdateStatement updateStatement, Scanner scanner) {
        this.jdbcURL = jdbcURL;
        this.username = username;
        this.password = password;
        this.insertStatements = insertStatements;
        this.deleteStatement = deleteStatement;
        this.selectStatement = selectStatement;
        this.updateStatement = updateStatement;
        this.scanner = scanner;

        connectionStatus(scanner);
    }


    private void connectionStatus(Scanner scanner) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connect to PostgreSQL server" +
                    "\nTo stop the connection with the server simply type: CLOSE" +
                    "\nWhat command to execute: SELECT, INSERT, UPDATE, DELETE");

            String command;
            do {
                command = scanner.nextLine();
                switch (command.toUpperCase()) {
                    case "SELECT":
                        selectStatement.getSelect(connection);
                        break;
                    case "INSERT":
                        insertStatements.getInsert(connection);
                        break;
                    case "UPDATE":
                        updateStatement.getUpdate(connection);
                        break;
                    case "DELETE":
                        deleteStatement.getDelete(connection);
                        break;
                }
            } while (!command.equalsIgnoreCase("CLOSE"));
            System.out.println("Connection has ended");

            scanner.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
