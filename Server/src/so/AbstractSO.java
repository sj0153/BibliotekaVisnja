/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domain.AbstractDomainObject;
import java.sql.SQLException;

/**
 *
 * @author Stefan
 */
public abstract class AbstractSO {

    public void execute(AbstractDomainObject ado) throws Exception {
        try {
            validation(ado);
            executeOperation(ado);
            commitTransaction();
            System.out.println("Uspesno izvrsena operacija.");
        } catch (Exception e) {
            rollbackTransaction();
            throw e;
        }
    }

    protected abstract void validation(AbstractDomainObject ado) throws Exception;

    protected abstract void executeOperation(AbstractDomainObject ado) throws Exception;

    public void commitTransaction() throws SQLException{
        DBBroker.getInstance().getConnection().commit();
    }

    public void rollbackTransaction() throws SQLException{
        DBBroker.getInstance().getConnection().rollback();
    }

}
