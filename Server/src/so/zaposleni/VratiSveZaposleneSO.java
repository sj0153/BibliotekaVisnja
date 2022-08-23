/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zaposleni;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Zaposleni;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Stefan
 */
public class VratiSveZaposleneSO extends AbstractSO{

    List<Zaposleni> zaposleni;
    
    @Override
    protected void validation(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Zaposleni)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zaposleni!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        List<AbstractDomainObject> ados = DBBroker.getInstance().getAll(ado);
        zaposleni  = (ArrayList<Zaposleni>) (ArrayList<?>) ados;
    }
    
    public List<Zaposleni> getList(){
        return zaposleni;
    }
    
}
