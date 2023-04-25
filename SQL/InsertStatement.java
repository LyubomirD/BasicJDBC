package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStatement extends StatementDuplicateCode{
    private final Scanner scanner;
    public InsertStatement(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getInsert(Connection connection) throws SQLException {
        super.getStatementCommand(connection, insertValues(scanner), "Names have been inserted" );
    }

    private static String insertValues(Scanner scanner) {
        System.out.println("Please write your firstname and lastname");
        String firstName = scanner.next();
        String lastName = scanner.next();
        return "INSERT INTO people (first_name, last_name) VALUES ('" + firstName + "', '" + lastName + "')";
    }
}
