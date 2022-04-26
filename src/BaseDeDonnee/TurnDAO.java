package BaseDeDonnee;

import java.sql.*;

public class TurnDAO extends DAO<Turn> {

    public Turn find2(Game game,Integer id){
        Turn turn = new Turn();
        try{
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM turn WHERE TURN = "+ id + "AND GAME_ID= "+ game.getId());
            if (result.first()){
                turn = new Turn((Game) result.getObject("id"), id, (Player)result.getObject("id"),result.getInt("x"),result.getInt("y"));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return turn;
    }


    @Override
    public Turn find(Integer id) {
       return  null;
    }

    @Override
    public Turn create(Turn obj) {
        return null;
    }

    @Override
    public Turn update(Turn obj) {
        return null;
    } // pas forcement besoin non plus quand un tour est passé on ne revient pas dessus

    @Override
    public void delete(Turn obj){} //{ pourquoi aurait t-on besoin de delete un tour pas utile pour le moment
     /*   try{
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE  FROM turn where ")
        }
    }*/

}
