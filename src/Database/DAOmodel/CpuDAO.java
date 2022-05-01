package Database.DAOmodel;

import Database.Table.Cpu;

import java.sql.*;

public class CpuDAO extends DAO<Cpu> {


    @Override
    public Cpu find(Integer id) {
        Cpu cpu = new Cpu();

        try{
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cpu WHERE id =" +id);
            if (result.first()){
                cpu = new Cpu(id,result.getString("description"),result.getInt("depth"));
            }

        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return cpu;
    }

    @Override
    public Cpu create(Cpu obj) {

        try{

            PreparedStatement prepare = this.connection.prepareStatement("INSERT INTO cpu (id,description,depth)" + "VALUES (?,?,?)");

            prepare.setInt(1,obj.getId());
            prepare.setString(2,obj.getDescription());
            prepare.setInt(3, obj.getDepth());

            prepare.executeUpdate();
            obj = this.find(obj.getId());

        } catch  (SQLException exception){
            exception.printStackTrace();
        }
        return obj;
    }

    @Override
    public Cpu update(Cpu obj) {

        try{
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE cpu SET description ='"+ obj.getDescription() +
                    "',"+ "depth = '" + obj.getDepth() +
                    "'" + "WHERE id =" + obj.getId());
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(Cpu obj) {
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM cpu WHERE id =" +obj.getId());
        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }
}
