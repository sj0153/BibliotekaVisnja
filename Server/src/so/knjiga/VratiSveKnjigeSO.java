/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.knjiga;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Knjiga;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Stefan
 */
public class VratiSveKnjigeSO extends AbstractSO{
    
    List<Knjiga> knjige;
    
    @Override
    protected void validation(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Knjiga)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Knjiga!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        List<AbstractDomainObject> ados = DBBroker.getInstance().getAll(ado);
        knjige = (ArrayList<Knjiga>) (ArrayList<?>) ados;
    }
    
    public List<Knjiga> getList(){
        return knjige;
    }
}
