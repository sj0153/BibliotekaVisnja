/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class StavkaPotvrde extends AbstractDomainObject implements Serializable {

    private int RBStavke;
    private String Napomena;
    private Knjiga knjiga;
    private Potvrda potvrda;

    public StavkaPotvrde() {

    }

    public StavkaPotvrde(int RBStavke, String Napomena, Knjiga knjiga, Potvrda potvrda) {
        this.RBStavke = RBStavke;
        this.Napomena = Napomena;
        this.knjiga = knjiga;
        this.potvrda = potvrda;
    }

    public int getRBStavke() {
        return RBStavke;
    }

    public String getNapomena() {
        return Napomena;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public Potvrda getPotvrda() {
        return potvrda;
    }

    public void setRBStavke(int RBStavke) {
        this.RBStavke = RBStavke;
    }

    public void setNapomena(String Napomena) {
        this.Napomena = Napomena;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public void setPotvrda(Potvrda potvrda) {
        this.potvrda = potvrda;
    }

    @Override
    public String toString() {
        return knjiga + " | " + Napomena;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.RBStavke;
        hash = 79 * hash + Objects.hashCode(this.Napomena);
        hash = 79 * hash + Objects.hashCode(this.knjiga);
        hash = 79 * hash + Objects.hashCode(this.potvrda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaPotvrde other = (StavkaPotvrde) obj;
        if (this.RBStavke != other.RBStavke) {
            return false;
        }
        if (!Objects.equals(this.potvrda, other.potvrda)) {
            return false;
        }
        return true;
    }

    @Override
    public String nazivTabele() {
        return " stavke ";
    }

    @Override
    public String alijas() {
        return " s ";
    }

    @Override
    public String join() {
        return " INNER JOIN Knjige k ON s.knjiga=k.IDK INNER JOIN Potvrde p ON s.potvrda=p.IDP INNER JOIN Zaposleni z ON p.zaposleni=z.IDZ INNER JOIN Clanovi c ON p.clan=c.IDC ";
    }

    @Override
    public AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException {
        StavkaPotvrde stavka = new StavkaPotvrde();
        if (rs.next()) {
            stavka.setRBStavke(RBStavke);
            stavka.setNapomena(rs.getString("sn"));
            Knjiga knjiga = new Knjiga();
            knjiga.setIDK(rs.getString("kidk"));
            knjiga.setNaziv(rs.getString("kn"));
            knjiga.setAutor(rs.getString("ka"));
            knjiga.setKategorija(rs.getString("kk"));
            stavka.setKnjiga(knjiga);
            Potvrda potvrda = new Potvrda();
            potvrda.setIDP(rs.getString("pidp"));
            potvrda.setDatumIzdavanja(rs.getDate("pdi"));
            potvrda.setRokZaVracanje(rs.getDate("przv"));
            potvrda.setDatumVracanja(rs.getDate("pdv"));
            Zaposleni zaposleni = new Zaposleni();
            zaposleni.setIDZ(rs.getString("zidz"));
            zaposleni.setIme(rs.getString("zi"));
            zaposleni.setPrezime(rs.getString("zp"));
            zaposleni.setUsername(rs.getString("zu"));
            zaposleni.setPassword(rs.getString("zpass"));
            potvrda.setZaposleni(zaposleni);
            Clan clan = new Clan();
            clan.setIDC(rs.getString("cidc"));
            clan.setIme(rs.getString("ci"));
            clan.setPrezime(rs.getString("cp"));
            clan.setJMBG(rs.getString("cjmbg"));
            clan.setBrojLicneKarte(rs.getString("cblk"));
            clan.setKontaktTelefon(rs.getString("ckt"));
            clan.setImejl(rs.getString("cimejl"));
            clan.setAdresa(rs.getString("ca"));
            clan.setPrivremenaAdresa(rs.getString("cpa"));
            clan.setZanimanje(rs.getString("cz"));
            potvrda.setClan(clan);
            stavka.setPotvrda(potvrda);
        }
        return stavka;
    }

    @Override
    public List<AbstractDomainObject> vratiSve(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> stavke = new ArrayList<>();
        while (rs.next()) {
            StavkaPotvrde stavka = new StavkaPotvrde();
            stavka.setRBStavke(rs.getInt("srb"));
            stavka.setNapomena(rs.getString("sn"));
            Knjiga knjiga = new Knjiga();
            knjiga.setIDK(rs.getString("kidk"));
            knjiga.setNaziv(rs.getString("kn"));
            knjiga.setAutor(rs.getString("ka"));
            knjiga.setKategorija(rs.getString("kk"));
            stavka.setKnjiga(knjiga);
            Potvrda potvrda = new Potvrda();
            potvrda.setIDP(rs.getString("pidp"));
            potvrda.setDatumIzdavanja(rs.getDate("pdi"));
            potvrda.setRokZaVracanje(rs.getDate("przv"));
            potvrda.setDatumVracanja(rs.getDate("pdv"));
            Zaposleni zaposleni = new Zaposleni();
            zaposleni.setIDZ(rs.getString("zidz"));
            zaposleni.setIme(rs.getString("zi"));
            zaposleni.setPrezime(rs.getString("zp"));
            zaposleni.setUsername(rs.getString("zu"));
            zaposleni.setPassword(rs.getString("zpass"));
            potvrda.setZaposleni(zaposleni);
            Clan clan = new Clan();
            clan.setIDC(rs.getString("cidc"));
            clan.setIme(rs.getString("ci"));
            clan.setPrezime(rs.getString("cp"));
            clan.setJMBG(rs.getString("cjmbg"));
            clan.setBrojLicneKarte(rs.getString("cblk"));
            clan.setKontaktTelefon(rs.getString("ckt"));
            clan.setImejl(rs.getString("cimejl"));
            clan.setAdresa(rs.getString("ca"));
            clan.setPrivremenaAdresa(rs.getString("cpa"));
            clan.setZanimanje(rs.getString("cz"));
            potvrda.setClan(clan);
            stavka.setPotvrda(potvrda);
            stavke.add(stavka);
        }
        return stavke;
    }

    @Override
    public String koloneZaInsert() {
        return "RBStavke, Napomena, knjiga, potvrda";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " Potvrda = '" + potvrda.getIDP() + "' ";
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + RBStavke + ", "
                + "'" + Napomena + "', "
                + "'" + knjiga.getIDK() + "', "
                + "'" + potvrda.getIDP() + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " RBStavke = " + RBStavke + ", "
                + " Napomena = '" + Napomena + "', "
                + " knjiga = '" + knjiga.getIDK() + "', "
                + " potvrda = '" + potvrda.getIDP() + "' ";
    }

    @Override
    public String getByIDOne() {
        return " WHERE s.potvrda = '" + potvrda.getIDP() + "' ";
    }

    @Override
    public String alijasiZaKolone() {
        return " s.RBStavke AS srb,"
                + "s.Napomena AS sn,"
                + "s.knjiga AS sk,"
                + "s.potvrda AS sp,"
                + "p.IDP AS pidp,"
                + "p.DatumIzdavanja AS pdi,"
                + "p.RokZaVracanje AS przv,"
                + "p.DatumVracanja AS pdv,"
                + "p.zaposleni AS pz,"
                + "p.clan AS pc,"
                + "k.IDK AS kidk,"
                + "k.Naziv AS kn,"
                + "k.Autor AS ka,"
                + "k.Kategorija AS kk,"
                + "z.IDZ AS zidz,"
                + "z.Ime AS zi,"
                + "z.Prezime AS zp,"
                + "z.Username AS zu,"
                + "z.Password AS zpass,"
                + "c.IDC AS cidc,"
                + "c.Ime AS ci,"
                + "c.Prezime AS cp,"
                + "c.JMBG AS cjmbg,"
                + "c.BrojLicneKarte AS cblk,"
                + "c.KontaktTelefon AS ckt,"
                + "c.Imejl AS cimejl,"
                + "c.Adresa AS ca,"
                + "c.PrivremenaAdresa AS cpa,"
                + "c.Zanimanje AS cz ";
    }

    @Override
    public String getByIDAll() {
        return " WHERE s.potvrda = '" + potvrda.getIDP() + "' " + " ORDER BY s.RBStavke";
    }

}
