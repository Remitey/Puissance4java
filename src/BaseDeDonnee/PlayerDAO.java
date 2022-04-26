package BaseDeDonnee;

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
        try{

                 PreparedStatement prepare = this.connection.prepareStatement("INSERT INTO player(id,username,email,password,permission)" + "VALUES (?,?,?,?,?)");

                 prepare.setInt(1,obj.getId());
                 prepare.setString(2,obj.getUsername());
                 prepare.setString(3, obj.getEmail());
                 prepare.setString(4, obj.getPassword());
                 prepare.setInt(5,obj.getPermission());

                 prepare.executeUpdate();
                 obj = this.find(obj.getId());

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
}
