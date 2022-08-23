/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavka;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaPotvrde;
import so.AbstractSO;

/**
 *
 * @author Stefan
 */
public class ObrisiStavkuSO extends AbstractSO{

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
        if (stavka.getKnjiga() == null) {
            poruka += "Stavka mora da sadrzi knjigu!\n";
        }
        if (stavka.getRBStavke() < 0 || stavka.getRBStavke() > 3) {
            poruka += "Stavka mora da ima svoj redni broj koji je u intervalu 1-3 !\n";
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
