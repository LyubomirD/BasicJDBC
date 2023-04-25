package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStatement extends StatementDuplicateCode{
    private final Scanner scanner;
    public UpdateStatement(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getUpdate(Connection connection) throws SQLException {
        getStatementCommand(connection, updateValues(scanner), "Table has been updated");
    }

    private static String updateValues(Scanner scanner) {
        System.out.println("Update firstname to:");
        String firstName = scanner.next();
        System.out.println("Update lastname to:");
        String lastName = scanner.next();
        System.out.println("Select row that will receive the changes:");
        int id = scanner.nextInt();
        return "UPDATE people SET first_name = '" + firstName +"', last_name = '" + lastName + "' WHERE id = " + id + ";";
    }

}
