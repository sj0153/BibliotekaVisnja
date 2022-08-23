/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.knjiga;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Knjiga;
import so.AbstractSO;

/**
 *
 * @author Stefan
 */
public class KreirajKnjiguSO extends AbstractSO{

    @Override
    protected void validation(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Knjiga)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Knjiga!");
        }
        Knjiga knjiga = (Knjiga) ado;
        String poruka = "";
        if (knjiga.getIDK().equals("")) {
            poruka += "Polje 'IDK' ne moze da bude prazno.\n";
        }
        if (knjiga.getIDK().length() != 10) {
            poruka += "IDK mora da sadrzi deset znakova.\n";
        }
        if (knjiga.getNaziv().equals("")) {
            poruka += "Polje 'Naziv' ne moze da bude prazno.\n";
        }
        if (knjiga.getNaziv().length() > 50) {
            poruka += "Naziv knjige moze da sadrzi najvise pedeset znakova.\n";
        }
        if (knjiga.getAutor().equals("")) {
            poruka += "Polje 'Autor' ne moze da bude prazno.\n";
        }
        if (knjiga.getAutor().length() > 50) {
            poruka += "Ime autor moze da sadrzi najvise pedeset znakova.\n";
        }
        if (knjiga.getKategorija().equals("")) {
            poruka += "Polje 'Kategorija' ne moze da bude prazno.\n";
        }
        if (knjiga.getKategorija().length() > 50) {
            poruka += "Kategorija moze da sadrzi najvise pedeset cifara.\n";
        }
        if (!poruka.equals("")) {
            throw new Exception(poruka);
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    } 
    
}
