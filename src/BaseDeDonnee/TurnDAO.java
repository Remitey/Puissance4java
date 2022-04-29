package BaseDeDonnee;

import java.sql.*;

public class TurnDAO extends DAO<Turn> {

    public Turn find2(Integer game, Integer id) {
        Turn turn = new Turn();
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM turn WHERE TURN = " + id + " AND GAME_id= " + game);

            if (result.first()) {
                ResultSet resultPlayer1 = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT  * FROM player WHERE id = " + result.getInt("player_id"));

                if (resultPlayer1.first()) {

                    Player player1 = new Player(resultPlayer1.getInt("id"), resultPlayer1.getString("username"), resultPlayer1.getString("email"),
                            resultPlayer1.getString("password"), resultPlayer1.getInt("permission"));
                    turn = new Turn(game, id, player1, result.getInt("x"), result.getInt("y"));
                }

            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return turn;
    }


    @Override
    public Turn find(Integer id) {
        return null;
    }

    @Override
    public Turn create(Turn obj) {

        try {
            PreparedStatement prepare = this.connection.prepareStatement("INSERT INTO turn(game_id, turn, player_id, x, y)" + "VALUES (?,?,?,?,?)");

            prepare.setInt(1, obj.getGame());
            prepare.setInt(2, obj.getTurn());
            prepare.setInt(3, obj.getPlayer_id().getId());
            prepare.setInt(4, obj.getX());
            prepare.setInt(5, obj.getY());

            prepare.executeUpdate();

            obj = this.find(obj.getTurn());

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return obj;
    }

    @Override
    public Turn update(Turn obj) {
        return null;
    } // pas forcement besoin non plus quand un tour est passé on ne revient pas dessus

    @Override
    public void delete(Turn obj) {
    } //{ pourquoi aurait t-on besoin de delete un tour pas utile pour le moment
     /*   try{
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE  FROM turn where ")
        }
    }*/

}
