/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.AbstractDomainObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import repository.db.DbConnectionFactory;

/**
 *
 * @author Stefan
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection connection;

    private DBBroker() {
        connection = DbConnectionFactory.getInstance().getConnection();
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }
    
    public Connection getConnection (){
        return connection;
    }

    public AbstractDomainObject getOne(AbstractDomainObject ado) throws SQLException {
        String upit = "SELECT " + ado.alijasiZaKolone()  + " FROM " + ado.nazivTabele() + " " + ado.alijas() + " " + ado.join() + " " + ado.getByIDOne() + " ";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        return ado.vratiJednog(rs);
    }
    
    public List<AbstractDomainObject> getAll(AbstractDomainObject ado) throws SQLException {
        String upit = "SELECT " + ado.alijasiZaKolone() + " FROM " + ado.nazivTabele() + " " + ado.alijas() + " " + ado.join() + " " + ado.getByIDAll() + " ";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        return ado.vratiSve(rs);
    }

    public void insert(AbstractDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " (" + ado.koloneZaInsert() + ") VALUES (" + ado.vrednostiZaInsert() + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit);
    }

    public void update(AbstractDomainObject ado) throws SQLException {
        String upit = "UPDATE " + ado.nazivTabele() + " SET " + ado.vrednostiZaUpdate() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit);
    }

    public void delete(AbstractDomainObject ado) throws SQLException {
        String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit);
    }

}
