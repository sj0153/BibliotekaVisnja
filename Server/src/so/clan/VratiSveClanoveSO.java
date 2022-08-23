/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clan;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Clan;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Stefan
 */
public class VratiSveClanoveSO extends AbstractSO{
    
    private List<Clan> clanovi;

    @Override
    protected void validation(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Clan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        List<AbstractDomainObject> ados = DBBroker.getInstance().getAll(ado);
        clanovi = (ArrayList<Clan>) (ArrayList<?>) ados;
    }
    
    public List<Clan> getList(){
        return clanovi;
    }
    
}
