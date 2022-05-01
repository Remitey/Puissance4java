package Database.DAOmodel;

import Database.Table.Cpu;
import Database.Table.Game;
import Database.Table.Player;

import java.sql.*;

public class GameDAO extends DAO<Game> {

    @Override
    public Game find(Integer id) {
        Game game = new Game();
        try{
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM game WHERE id =" +id);
            if(result.first()){
                ResultSet resultPlayer1 = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT  * FROM player WHERE id = " + result.getInt("player_1"));
                ResultSet resultPlayer2 = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT  * FROM player WHERE id = " + result.getInt("player_2"));
                ResultSet resultCpu = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT  * FROM cpu WHERE id = " + result.getInt("cpu"));


                if(resultPlayer1.first() && resultPlayer2.first()) {

                    Player player1 = new Player(resultPlayer1.getInt("id"), resultPlayer1.getString("username"), resultPlayer1.getString("email"),
                            resultPlayer1.getString("password"), resultPlayer1.getInt("permission"));

                    Player player2 = new Player(resultPlayer2.getInt("id"), resultPlayer2.getString("username"), resultPlayer2.getString("email"),
                            resultPlayer2.getString("password"), resultPlayer2.getInt("permission"));

                    game = new Game(id, player1, player2, result.getInt("grid_size_row"), result.getInt("grid_size_col"),
                            result.getInt("result"), result.getLong("Datetime_start"), result.getLong("duration"));
                }
                else if (resultPlayer1.first() && resultCpu.first()){

                    Player player1 = new Player(resultPlayer1.getInt("id"), resultPlayer1.getString("username"), resultPlayer1.getString("email"),
                            resultPlayer1.getString("password"), resultPlayer1.getInt("permission"));

                    Cpu cpu = new Cpu(resultCpu.getInt("id"), resultCpu.getString("description"), resultCpu.getInt("depth"));

                    game = new Game(id,player1,cpu,result.getInt("grid_size_row"), result.getInt("grid_size_col"),
                            result.getInt("result"), result.getLong("Datetime_start"), result.getLong("duration"));

                }

            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return game;
    }
    public Game findForId(Game game){
        try{
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM game WHERE datetime_start =" + game.getTime());
            if(result.first()){

                ResultSet resultCpu = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT  * FROM cpu WHERE id = " + result.getInt("cpu"));

                game.setId(result.getInt("id"));

            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return game;

    }

    @Override
    public Game create(Game obj) {

        try{
            if (obj.getCpu() == null){
                PreparedStatement prepare = this.connection.prepareStatement("INSERT INTO game(player_1, player_2, grid_size_row, grid_size_col,DATETIME_START)" + "VALUES (?,?,?,?,?)");

                prepare.setInt(1,obj.getPlayer_1().getId());
                prepare.setInt(2,obj.getPlayer_2().getId());
                prepare.setInt(3,obj.getGrid_size_row());
                prepare.setInt(4,obj.getGrid_size_col());
                prepare.setLong(5,obj.getTime());


                prepare.executeUpdate();

                obj = this.find(obj.getId());
            } else {
                PreparedStatement prepare = this.connection.prepareStatement("INSERT INTO game(player_1,cpu,GRID_SIZE_row,grid_size_col,DATETIME_START)" + "VALUES (?,?,?,?,?)");

                prepare.setInt(1,obj.getPlayer_1().getId());
                prepare.setInt(2,obj.getCpu().getId());
                prepare.setInt(3,obj.getGrid_size_row());
                prepare.setInt(4,obj.getGrid_size_col());
                prepare.setLong(5,obj.getTime());

                prepare.executeUpdate();

                obj = this.find(obj.getId());
            }


        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return obj;
    }

    @Override
    public Game update(Game obj) {
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE game " +
                    "SET player_1 = '" + obj.getPlayer_1().getId() +
                    "', player_2 = '" + obj.getPlayer_2().getId() +
                    "', grid_size_row ='" + obj.getGrid_size_row() +
                    "', grid_size_col ='" + obj.getGrid_size_col() +
                    "', result ='" + obj.getResult() +
                    "', Datetime_Start ='" + obj.getTime() +
                    "', Duration ='" + obj.getDuration() +
                    "' WHERE id = " + obj.getId());
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
