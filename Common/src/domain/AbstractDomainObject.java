/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public abstract class AbstractDomainObject implements Serializable {

    public abstract String nazivTabele();
    public abstract String alijas();
    public abstract String alijasiZaKolone();
    public abstract String join();
    public abstract List<AbstractDomainObject> vratiSve(ResultSet rs) throws SQLException;
    public abstract AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException;
    public abstract String koloneZaInsert();
    public abstract String vrednostZaPrimarniKljuc();
    public abstract String vrednostiZaInsert();
    public abstract String vrednostiZaUpdate();
    public abstract String getByIDOne();
    public abstract String getByIDAll();
    
}
