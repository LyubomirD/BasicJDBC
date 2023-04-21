package SQL;

import java.sql.SQLException;
import java.util.Scanner;

public class Connect_Postgres {
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:PORT/testDatabase";
        String username = "<postgres>";
        String password = "<hidden>";

        Scanner scanner = new Scanner(System.in);
        SelectStatement select = new SelectStatement();
        InsertStatement insert = new InsertStatement(scanner);
        UpdateStatement update = new UpdateStatement(scanner);
        DeleteStatement delete = new DeleteStatement(scanner);
        new TestConnection(jdbcURL, username, password, insert, delete, select, update, scanner);

    }

}

/* My database example looks like this:

id  | first_name | lastname
 1  | YourName   | YourName
... | .......... | .......

Note:
The id is auto generated

 */