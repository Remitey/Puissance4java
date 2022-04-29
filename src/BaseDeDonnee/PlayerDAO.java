package BaseDeDonnee;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class PlayerDAO extends DAO<Player>{

   /* public static byte[] hashbyte(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();//    ww   w .    d  e  m o   2  s .   c o   m
        byte[] hash = digest.digest(password.getBytes("UTF-8"));
        return hash;
    }

    public static byte[] getByteTabFromCharTab(char[] tab) {
        byte[] result = new byte[tab.length];
        for(int i=0; i<tab.length; i++) {
            result[i] = (byte) tab[i];
        }
        return result;
    }

    public static char[] getChartkt(byte[] tab) {
        char[] result = new char[tab.length];
        for(int i=0; i<tab.length; i++) {
            result[i] = (char) tab[i];
        }
        return result;
    }
*/


    public Player findPlayer(String username,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Player player = new Player();

       // byte[] test = getByteTabFromCharTab(password);
       // System.out.println(password);

       // byte[] passwordza = hashbyte(password);
      //  System.out.println(passwordza);
      //  char[] password2 = getChartkt(passwordza);
      //  System.out.println(password2);

        try{
            ResultSet result =this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM player WHERE username ='" + username + "'AND password = '" +  password + "'");
           // System.out.println("SELECT * FROM player WHERE username ='" + username + "'AND password = '" +  password + "'");
            if (result.first()){

                player = new Player(result.getInt("id"),username,result.getString("email"),password,result.getInt("permission"));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    return player;
    }

    @Override
    public Player find(Integer id){
        return null;
    }

    @Override
    public Player create(Player obj) {
        try{

                 PreparedStatement prepare = this.connection.prepareStatement("INSERT INTO player(id,username,email,password,permission)" + "VALUES (?,?,?,?,?)");

                // byte[] password = hashbyte(obj.getPassword());
                 //String password2 = (String.copyValueOf(getChartkt(password)));

                // System.out.println(password);
                //System.out.println(getChartkt(password));

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
