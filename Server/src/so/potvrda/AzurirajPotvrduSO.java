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
import java.text.SimpleDateFormat;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author Stefan
 */
public class AzurirajPotvrduSO extends AbstractSO {

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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dv = format.format(potvrda.getDatumVracanja());
        String ymd[] = dv.split("-");
        if (ymd.length != 3) {
            poruka += "Datum mora biti unet u formatu: yyyy-dd-mm !\n";
        } else {
            try {
                int y = Integer.parseInt(ymd[0]);
                int m = Integer.parseInt(ymd[1]);
                int d = Integer.parseInt(ymd[2]);
                if (m < 1 || m > 12) {
                    poruka += "Mesec mora biti u intervalu 1-12.\n";
                }
                if (d < 1 || d > 31) {
                    poruka += "Dan u mesecu mora biti u intervalu 1-31.\n";
                }
                switch (m) {
                    case 2:
                        if (!(((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) && m == 2 && d > 28) {
                            poruka += "Godina " + y + ". nije prestupna. Februar ima 28 dana.\n";
                        } else if ((((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) && m == 2 && d > 29) {
                            poruka += "U prestupnoj godini februar ima 29 dana.\n";
                        }
                        break;
                    case 4:
                        if (d > 30) {
                            poruka += "April ima 30 dana.\n";
                        }
                        break;
                    case 6:
                        if (d > 30) {
                            poruka += "Jun ima 30 dana.\n";
                        }
                        break;
                    case 9:
                        if (d > 30) {
                            poruka += "Septembar ima 30 dana.\n";
                        }
                        break;
                    case 11:
                        if (d > 30) {
                            poruka += "Novembar ima 30 dana.\n";
                        }
                        break;
                }
                Date danas = new Date();
                danas.getTime();
                if (potvrda.getDatumVracanja().before(potvrda.getDatumIzdavanja())) {
                    poruka += "Datum vracanja ne moze biti pre datuma izdavanja potvrde.\n";
                }
                if (potvrda.getDatumVracanja().after(danas)) {
                    poruka += "Datum vracanja ne moze biti nakon danasnjeg datuma.\n";
                }
            } catch (Exception e) {
                poruka += "Pogresno ste uneli datum";
            }
        }
        if (!poruka.equals("")) {
            throw new Exception(poruka);
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }

}
