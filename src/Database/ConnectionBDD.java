package Database;

import java.sql.*;

public class ConnectionBDD {

    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/puissance4";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "123soleil";

    private static Connection connection;

    public static Connection getInstance() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            } catch (SQLException throwables) {
                System.out.println("erreur de co");
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}

