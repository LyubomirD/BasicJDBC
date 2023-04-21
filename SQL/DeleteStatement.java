package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStatement {

    private final Scanner scanner;

    public DeleteStatement(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getDelete(Connection connection) throws SQLException {
        setDelete(connection);
    }

    private void setDelete(Connection connection) throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        statement.executeUpdate(deleteValues(scanner));
        System.out.println("Contact has been deleted");
        statement.close();
    }

    private static String deleteValues(Scanner scanner){
        System.out.println("Which row to delete (id number):");
        int idDelete = scanner.nextInt();
        return "DELETE FROM table2 WHERE id = " + idDelete + ";";
    }

    public void getDeleteBetween(Connection connection) throws SQLException {
        setDeleteBetween(connection);
    }

    private void setDeleteBetween(Connection connection) throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        statement.executeUpdate(deleteBetween(scanner));
        System.out.println("Contacts rows have been deleted");
        statement.close();
    }

    private static String deleteBetween(Scanner scanner){
        System.out.println("Which rows in between to delete (id numbers):");
        int idFrom = scanner.nextInt();
        int idTo = scanner.nextInt();
        return "DELETE FROM table2 WHERE id BETWEEN " + idFrom + " AND " + idTo + " ;";
    }

}
