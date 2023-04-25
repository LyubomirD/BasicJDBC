package SQL;

import java.sql.SQLException;
import java.util.Scanner;

public class Connect_Postgres {
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/testdatabase";
        String username = "postgres";
        String password = "";

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