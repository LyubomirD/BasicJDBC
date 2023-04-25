package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStatement extends StatementDuplicateCode{

    private final Scanner scanner;

    public DeleteStatement(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getDelete(Connection connection) throws SQLException {
        getStatementCommand(connection, deleteValues(scanner), "Contact has been deleted");
    }

    private static String deleteValues(Scanner scanner){
        System.out.println("Which row to delete (id number):");
        int idDelete = scanner.nextInt();
        return "DELETE FROM people WHERE id = " + idDelete + ";";
    }

}
