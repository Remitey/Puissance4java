package BaseDeDonnee;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class GameDAO extends DAO<Game>{

    @Override
    public Game find(Integer id) {
        Game game = new Game();
        try{
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM game WHERE id =" +id);

                  /*  ResultSet resultPlayer1 = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT  * FROM game INNER JOIN player ON game.player_1 = player_1.id"
                        + "AND game.player_2 = player_2.id" +"WHERE" );

                Player player1 = new Player(resultPlayer1.getInt("id"),resultPlayer1.getString("username"),resultPlayer1.getString("email"),
                        resultPlayer1.getString("password"),resultPlayer1.getInt("permission"));

                Player player2 = new Player(resultPlayer2.getInt("id"),resultPlayer2.getString("username"),resultPlayer2.getString("email"),
                        resultPlayer2.getString("password"),resultPlayer2.getInt("permission"));*/

            if(result.first()){



                game = new Game(id, result.getInt("player_1"),result.getInt("player_2"),result.getInt("grid_size_row"),result.getInt("grid_size_col"), result.getInt("result"), (LocalDateTime) result.getObject("Datetime_start"), (Duration) result.getObject("duration"));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Game create(Game obj) {
        return null;
    }

    @Override
    public Game update(Game obj) {


        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE game SET player_1 = '" + obj.getPlayer_1() +
                    "'," + " player_2 = '" + obj.getPlayer_2() +
                    "'," + "cpu ='" + obj.getCpu() +
                    "'," + "grid_size_row ='" + obj.getGrid_size_row() +
                    "'," + "grid_size_col ='" + obj.getGrid_size_col() +
                    "'," + "result ='" + obj.getResult() +
                    "'," + "Datetime_Start ='" + obj.getTime() +
                    "'," + "Duration ='" + obj.getDuration() +
                    "'" + "WHERE id = " + obj.getId());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return obj;
    }
    @Override
    public void delete(Game obj) {
        try{
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM game Where id = " + obj.getId());
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }


}
