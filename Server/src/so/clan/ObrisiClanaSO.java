/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clan;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Clan;
import so.AbstractSO;

/**
 *
 * @author Stefan
 */
public class ObrisiClanaSO extends AbstractSO{

    @Override
    protected void validation(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Clan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
        }
        Clan clan = (Clan) ado;
        String poruka = "";
        if (clan.getIDC().equals("")) {
            poruka += "Polje 'IDC' ne moze da bude prazno.\n";
        }
        if (clan.getIDC().length() != 10) {
            poruka += "IDC mora da sadrzi 10 znakova";
        }
        if (!poruka.equals("")) {
            throw new Exception(poruka);
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
    
    
}
