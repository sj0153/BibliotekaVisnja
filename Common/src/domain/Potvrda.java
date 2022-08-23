/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class Potvrda extends AbstractDomainObject implements Serializable {

    private String IDP;
    private Date DatumIzdavanja;
    private Date RokZaVracanje;
    private Date DatumVracanja;
    private Zaposleni zaposleni;
    private Clan clan;
    private List<StavkaPotvrde> stavke;

    public Potvrda() {

    }

    public Potvrda(String IDP, Date DatumIzdavanja, Date RokZaVracanje, Date DatumVracanja, Zaposleni zaposleni, Clan clan, List<StavkaPotvrde> stavke) {
        this.IDP = IDP;
        this.DatumIzdavanja = DatumIzdavanja;
        this.RokZaVracanje = RokZaVracanje;
        this.DatumVracanja = DatumVracanja;
        this.zaposleni = zaposleni;
        this.clan = clan;
        this.stavke = stavke;
    }

    public String getIDP() {
        return IDP;
    }

    public Date getDatumIzdavanja() {
        return DatumIzdavanja;
    }

    public Date getRokZaVracanje() {
        return RokZaVracanje;
    }

    public Date getDatumVracanja() {
        return DatumVracanja;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public Clan getClan() {
        return clan;
    }

    public void setIDP(String IDP) {
        this.IDP = IDP;
    }

    public void setDatumIzdavanja(Date DatumIzdavanja) {
        this.DatumIzdavanja = DatumIzdavanja;
    }

    public void setRokZaVracanje(Date RokZaVracanje) {
        this.RokZaVracanje = RokZaVracanje;
    }

    public void setDatumVracanja(Date DatumVracanja) {
        this.DatumVracanja = DatumVracanja;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public List<StavkaPotvrde> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaPotvrde> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return IDP;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.IDP);
        hash = 79 * hash + Objects.hashCode(this.DatumIzdavanja);
        hash = 79 * hash + Objects.hashCode(this.RokZaVracanje);
        hash = 79 * hash + Objects.hashCode(this.DatumVracanja);
        hash = 79 * hash + Objects.hashCode(this.zaposleni);
        hash = 79 * hash + Objects.hashCode(this.clan);
        hash = 79 * hash + Objects.hashCode(this.stavke);
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
        final Potvrda other = (Potvrda) obj;
        if (!Objects.equals(this.IDP, other.IDP)) {
            return false;
        }
        return true;
    }

    @Override
    public String nazivTabele() {
        return " potvrde ";
    }

    @Override
    public String alijas() {
        return " p ";
    }

    @Override
    public String join() {
        return " INNER JOIN Zaposleni z ON p.zaposleni=z.IDZ INNER JOIN Clanovi c ON p.clan=c.IDC ";
    }

    @Override
    public AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException {
        Potvrda p = new Potvrda();
        if (rs.next()) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            p.setIDP(rs.getString("pidp"));
            p.setDatumIzdavanja(rs.getDate("pdi"));
            p.setRokZaVracanje(rs.getDate("przv"));
            p.setDatumVracanja(rs.getDate("pdv"));
            Zaposleni zaposleni = new Zaposleni();
            zaposleni.setIDZ(rs.getString("zidz"));
            zaposleni.setIme(rs.getString("zi"));
            zaposleni.setPrezime(rs.getString("zp"));
            zaposleni.setUsername(rs.getString("zu"));
            zaposleni.setPassword(rs.getString("zpass"));
            p.setZaposleni(zaposleni);
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
            p.setClan(clan);
        }
        return p;
    }

    @Override
    public List<AbstractDomainObject> vratiSve(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> potvrde = new ArrayList<>();
        while (rs.next()) {
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
            potvrde.add(potvrda);
        }
        return potvrde;
    }

    @Override
    public String koloneZaInsert() {
        return "IDP, DatumIzdavanja, RokZaVracanje, zaposleni, clan";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " IDP = '" + IDP + "' ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + IDP + "', "
                + "'" + new java.sql.Date(DatumIzdavanja.getTime()) + "', "
                + "'" + new java.sql.Date(RokZaVracanje.getTime()) + "', "
                + "'" + zaposleni.getIDZ() + "', "
                + "'" + clan.getIDC() + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " IDP = '" + IDP + "', "
                + " DatumIzdavanja = '" + new java.sql.Date(DatumIzdavanja.getTime()) + "', "
                + " RokZaVracanje = '" + new java.sql.Date(RokZaVracanje.getTime()) + "', "
                + " DatumVracanja = '" + new java.sql.Date(DatumVracanja.getTime()) + "', "
                + " zaposleni = '" + zaposleni.getIDZ() + "', "
                + " clan = '" + clan.getIDC() + "' ";
    }

    @Override
    public String getByIDOne() {
        return " WHERE p.IDP = '" + IDP + "' ";
    }

    @Override
    public String alijasiZaKolone() {
        return " p.IDP AS pidp,"
                + "p.DatumIzdavanja AS pdi,"
                + "p.RokZaVracanje AS przv,"
                + "p.DatumVracanja AS pdv,"
                + "p.zaposleni AS pz,"
                + "p.clan AS pc,"
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
        return "";
    }

}
