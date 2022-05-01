package Database.DAOmodel;

import Database.Table.Player;

import java.sql.*;

public class PlayerDAO extends DAO<Player> {



    public Player findPlayer(String username,String password) {

        Player player = new Player();

        try{

            ResultSet result =this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM player WHERE username ='" + username + "' AND password = sha1('" + password + "')");

            if (result.first()){

                player = new Player(result.getInt("id"),username,result.getString("email"),password,result.getInt("permission"));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        if (player.getUsername() == null)
            return null;
    return player;
    }

    public String updatePassword(String password) {
        try{
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE player(password) SET password ="  + password);

        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return password;
    }


    @Override
    public Player find(Integer id){
        return null;
    }

    @Override
    public Player create(Player obj) {
        try{

                 PreparedStatement prepare = this.connection.prepareStatement("INSERT INTO player(username,email,password,permission)" + "VALUES (?,?,sha1(?),?)");

                 prepare.setString(1,obj.getUsername());
                 prepare.setString(2, obj.getEmail());
                 prepare.setString(3, obj.getPassword());
                 prepare.setInt(4,obj.getPermission());


                 prepare.executeUpdate();
        } catch  (SQLException exception){
            exception.printStackTrace();
        }
        return obj;
    }

    @Override
    public Player update(Player obj) {
        try{
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE player SET username = '" + obj.getUsername() +
                    "',"+ " email = '" + obj.getEmail() +
                    "',"+"password ='" + obj.getPassword() +
                    "',"+ "permission ='" + obj.getPermission()
                    +"'"+ "WHERE id = " + obj.getId());
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(Player obj) {
        try{
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM player WHERE id = " + obj.getId());
        }catch (SQLException exception){
            exception.printStackTrace();
        }
}


    public void data(Player obj){
        try{
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT *,game FROM player INNER JOIN game ON player.username = game.player_1");

        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
