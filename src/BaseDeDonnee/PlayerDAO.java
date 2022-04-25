package BaseDeDonnee;

import GestionUtilisateur.Play;

import java.sql.*;

public class PlayerDAO extends DAO<Player>{

    @Override
    public Player find(Integer id) {
        Player player =new Player();

        try{
            ResultSet result =this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM player WHERE id =" + id);
            if (result.first()){
                player = new Player(id,result.getString("username"),result.getString("email"),result.getString("password"),result.getInt("permission"));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    return player;
    }

    @Override
    public Player create(Player obj) {
        return null;
    }

    @Override
    public Player update(Player obj) {
        return null;
    }

    @Override
    public void delete(Player obj) {

    }
}
