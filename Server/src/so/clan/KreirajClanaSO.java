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
public class KreirajClanaSO extends AbstractSO {    

    
    
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
        if (clan.getIme().equals("")) {
            poruka += "Polje 'Ime' ne moze da bude prazno.\n";
        }
        if (clan.getIme().length() > 30) {
            poruka += "Ime moze da sadrzi najvise trideset znakova.\n";
        }
        if (clan.getPrezime().equals("")) {
            poruka += "Polje 'Prezime' ne moze da bude prazno.\n";
        }
        if (clan.getPrezime().trim().length() > 30) {
            poruka += "Prezime moze da sadrzi najvise trideset znakova.\n";
        }
        if (clan.getJMBG().equals("")) {
            poruka += "Polje 'JMBG' ne moze da bude prazno.\n";
        }
        if (clan.getJMBG().length() != 13) {
            poruka += "JMBG mora da sadrzi trinaest cifara.\n";
        }
        if (clan.getBrojLicneKarte().equals("")) {
            poruka += "Polje 'Broj licne karte' ne moze da bude prazno.\n";
        }
        if (clan.getBrojLicneKarte().length() != 9) {
            poruka += "Broj licne karte mora da sadrzi devet cifara.\n";
        }
        if (clan.getKontaktTelefon().equals("")) {
            poruka += "Polje 'Kontakt telefon' ne moze da bude prazno.\n";
        }
        if (clan.getKontaktTelefon().length() > 13) {
            poruka += "Kontakt telefon moze da sadrzi najvise trinaest znakova.\n";
        }
        if (clan.getImejl().length() > 30) {
            poruka += "Imejl moze da sadrzi najvise trideset znakova.\n";
        }
        if (clan.getAdresa().equals("")) {
            poruka += "Polje 'Adresa' ne moze da bude prazno.\n";
        }
        if (clan.getAdresa().length() > 50) {
            poruka += "Adresa moze da sadrzi najvise pedeset znakova.\n";
        }
        if (clan.getPrivremenaAdresa().length() > 50) {
            poruka += "Privremena adresa moze da sadrzi najvise pedeset znakova.\n";
        }
        if (clan.getZanimanje().length() > 50) {
            poruka += "Zanimanje moze da sadrzi najvise pedeset znakova.\n";
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
