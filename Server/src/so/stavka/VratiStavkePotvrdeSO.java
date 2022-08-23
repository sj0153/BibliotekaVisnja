/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavka;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaPotvrde;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Stefan
 */
public class VratiStavkePotvrdeSO extends AbstractSO{
    
    List<StavkaPotvrde> stavke;
    
    @Override
    protected void validation(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof StavkaPotvrde)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Potvrda!");
        }
        StavkaPotvrde stavka = (StavkaPotvrde) ado;
        String poruka = "";
        if (stavka.getPotvrda() == null) {
            poruka += "Stavka mora da pripada nekoj potvrdi!\n";
        }
        if (!poruka.equals("")) {
            throw new Exception(poruka);
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        List<AbstractDomainObject> ados = DBBroker.getInstance().getAll(ado);
        stavke = (ArrayList<StavkaPotvrde>) (ArrayList<?>) ados;
    }
    
    
    public List<StavkaPotvrde> getList(){
        return stavke;
    }
    
}
