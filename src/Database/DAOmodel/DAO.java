package Database.DAOmodel;

import Database.ConnectionBDD;

import java.sql.*;

public abstract class DAO<T> {


    public Connection connection = ConnectionBDD.getInstance();

    public abstract T find(Integer id); // permet de récupérer un objet via son ID

    public abstract T create(T obj); // permet de créer une entrée dans la base de données par rapport à un objet

    public abstract T update(T obj);// Permet de mettre à jour la base de données d'une entrée de la base

    public abstract void delete(T obj);

}
