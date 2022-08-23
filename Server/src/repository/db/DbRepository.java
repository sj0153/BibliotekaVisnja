/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import java.io.IOException;
import java.sql.SQLException;
import repository.Repository;

/**
 *
 * @author Stefan
 * @param <C>
 */
public interface DbRepository<C> extends Repository<C> {

    @Override
    public default void connect() throws SQLException, IOException {
        DbConnectionFactory.getInstance().getConnection();
    }

    @Override
    public default void disconnect() throws SQLException, IOException {
        DbConnectionFactory.getInstance().getConnection().close();
    }

    @Override
    public default void commit() throws SQLException, IOException {
        DbConnectionFactory.getInstance().getConnection().commit();
    }

    @Override
    public default void rollback() throws SQLException, IOException {
        DbConnectionFactory.getInstance().getConnection().rollback();
    }
}
