package BaseDeDonnee;

import java.sql.*;
import java.sql.Connection;

public class MainBDD {

    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/puissance4";

    private static final String USERNAME = "root";
    private static final String PASSWORD = null;

    public static void main(String[] args) {
        Statement statement = null;


        try (Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD)){

            statement = connection.createStatement();

            Statement update = connection.createStatement();

            ResultSet resultSetStatement = statement.executeQuery("SELECT * FROM player ");

            int player2 = update.executeUpdate("INSERT INTO player VALUES (1,'enculéo','tjhhr','12345',1)");

            System.out.println(player2);
        }catch (SQLException throwables){
            System.out.println("erreur de co");
            throwables.printStackTrace();;
        } finally {
            try{
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException throwables){
                throwables.printStackTrace();

            }
        }

    }


}
