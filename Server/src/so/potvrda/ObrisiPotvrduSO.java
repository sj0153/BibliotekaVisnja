/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.potvrda;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Potvrda;
import domain.StavkaPotvrde;
import so.AbstractSO;

/**
 *
 * @author Stefan
 */
public class ObrisiPotvrduSO extends AbstractSO{

    @Override
    protected void validation(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Potvrda)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Potvrda!");
        }
        Potvrda potvrda = (Potvrda) ado;
        String poruka = "";
        if (potvrda.getIDP().equals("")) {
            poruka += "Polje 'IDP' ne moze da bude prazno.\n";
        }
        if (potvrda.getIDP().length() != 10) {
            poruka += "IDP mora da sadrzi deset znakova.\n";
        }
        if (potvrda.getStavke().isEmpty()) {
            poruka += "Potvrda mora da sadrzi barem jednu stavku!\n";
        }
        for (StavkaPotvrde stavkaPotvrde : potvrda.getStavke()) {
            if (stavkaPotvrde.getKnjiga() == null) {
                poruka += "Svaka stavka mora da sadrzi odredjeni primerak knjige!\n";
            }
        }
        if (!poruka.equals("")) {
            throw new Exception(poruka);
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
        Potvrda potvrda = (Potvrda) ado;
        for (StavkaPotvrde stavkaPotvrde : potvrda.getStavke()) {
            DBBroker.getInstance().delete(stavkaPotvrde);
        }
    }
    
}
