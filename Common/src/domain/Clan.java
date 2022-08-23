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
public class Clan extends AbstractDomainObject implements Serializable {

    private String IDC;
    private String Ime;
    private String Prezime;
    private String JMBG;
    private String BrojLicneKarte;
    private String KontaktTelefon;
    private String Imejl;
    private String Adresa;
    private String PrivremenaAdresa;
    private String Zanimanje;

    public Clan() {

    }

    public Clan(String IDC, String Ime, String Prezime, String JMBG, String BrojLicneKarte, String KontaktTelefon, String Imejl, String Adresa, String PrivremenaAdresa, String Zanimanje) {
        this.IDC = IDC;
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.JMBG = JMBG;
        this.BrojLicneKarte = BrojLicneKarte;
        this.KontaktTelefon = KontaktTelefon;
        this.Imejl = Imejl;
        this.Adresa = Adresa;
        this.PrivremenaAdresa = PrivremenaAdresa;
        this.Zanimanje = Zanimanje;
    }

    public String getIDC() {
        return IDC;
    }

    public String getIme() {
        return Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public String getJMBG() {
        return JMBG;
    }

    public String getBrojLicneKarte() {
        return BrojLicneKarte;
    }

    public String getKontaktTelefon() {
        return KontaktTelefon;
    }

    public String getImejl() {
        return Imejl;
    }

    public String getAdresa() {
        return Adresa;
    }

    public String getPrivremenaAdresa() {
        return PrivremenaAdresa;
    }

    public String getZanimanje() {
        return Zanimanje;
    }

    public void setIDC(String IDC) {
        this.IDC = IDC;
    }

    public void setIme(String Ime) {
        this.Ime = Ime;
    }

    public void setPrezime(String Prezime) {
        this.Prezime = Prezime;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public void setBrojLicneKarte(String BrojLicneKarte) {
        this.BrojLicneKarte = BrojLicneKarte;
    }

    public void setKontaktTelefon(String KontaktTelefon) {
        this.KontaktTelefon = KontaktTelefon;
    }

    public void setImejl(String Imejl) {
        this.Imejl = Imejl;
    }

    public void setAdresa(String Adresa) {
        this.Adresa = Adresa;
    }

    public void setPrivremenaAdresa(String PrivremenaAdresa) {
        this.PrivremenaAdresa = PrivremenaAdresa;
    }

    public void setZanimanje(String Zanimanje) {
        this.Zanimanje = Zanimanje;
    }

    @Override
    public String toString() {
        return Ime + " " + Prezime + " " + IDC;
    }

    public String podaciOClanu() {
        return "IDC=" + IDC + ", Ime=" + Ime + ", Prezime=" + Prezime + ", JMBG=" + JMBG + ", BrojLicneKarte=" + BrojLicneKarte + ", KontaktTelefon=" + KontaktTelefon + ", Imejl=" + Imejl + ", Adresa=" + Adresa + ", PrivremenaAdresa=" + PrivremenaAdresa + ", Zanimanje=" + Zanimanje;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.IDC);
        hash = 13 * hash + Objects.hashCode(this.Ime);
        hash = 13 * hash + Objects.hashCode(this.Prezime);
        hash = 13 * hash + Objects.hashCode(this.JMBG);
        hash = 13 * hash + Objects.hashCode(this.BrojLicneKarte);
        hash = 13 * hash + Objects.hashCode(this.KontaktTelefon);
        hash = 13 * hash + Objects.hashCode(this.Imejl);
        hash = 13 * hash + Objects.hashCode(this.Adresa);
        hash = 13 * hash + Objects.hashCode(this.PrivremenaAdresa);
        hash = 13 * hash + Objects.hashCode(this.Zanimanje);
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
        final Clan other = (Clan) obj;
        if (!Objects.equals(this.IDC, other.IDC)) {
            return false;
        }
        return true;
    }

    @Override
    public String nazivTabele() {
        return " clanovi ";
    }

    @Override
    public String alijas() {
        return " c ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException {
        Clan c = new Clan();
        if (rs.next()) {
            c.setIDC(IDC);
            c.setIme(rs.getString("Ime"));
            c.setPrezime(rs.getString("Prezime"));
            c.setJMBG(rs.getString("JMBG"));
            c.setBrojLicneKarte(rs.getString("BrojLicneKarte"));
            c.setKontaktTelefon(rs.getString("KontaktTelefon"));
            c.setImejl(rs.getString("Imejl"));
            c.setAdresa(rs.getString("Adresa"));
            c.setPrivremenaAdresa(rs.getString("PrivremenaAdresa"));
            c.setZanimanje(rs.getString("Zanimanje"));
        }
        return c;
    }

    @Override
    public List<AbstractDomainObject> vratiSve(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> clanovi = new ArrayList<>();
        while (rs.next()) {
            Clan clan = new Clan();
            clan.setIDC(rs.getString("IDC"));
            clan.setIme(rs.getString("Ime"));
            clan.setPrezime(rs.getString("Prezime"));
            clan.setJMBG(rs.getString("JMBG"));
            clan.setBrojLicneKarte(rs.getString("BrojLicneKarte"));
            clan.setKontaktTelefon(rs.getString("KontaktTelefon"));
            clan.setImejl(rs.getString("Imejl"));
            clan.setAdresa(rs.getString("Adresa"));
            clan.setPrivremenaAdresa(rs.getString("PrivremenaAdresa"));
            clan.setZanimanje(rs.getString("Zanimanje"));
            clanovi.add(clan);
        }
        return clanovi;
    }

    @Override
    public String koloneZaInsert() {
        return "IDC, Ime, Prezime, JMBG, BrojLicneKarte, KontaktTelefon, Imejl, Adresa, PrivremenaAdresa, Zanimanje";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " IDC = '" + IDC + "' ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + IDC + "', "
                + "'" + Ime + "', "
                + "'" + Prezime + "', "
                + "'" + JMBG + "', "
                + "'" + BrojLicneKarte + "', "
                + "'" + KontaktTelefon + "', "
                + "'" + Imejl + "', "
                + "'" + Adresa + "', "
                + "'" + PrivremenaAdresa + "', "
                + "'" + Zanimanje + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " IDC = '" + IDC + "', "
                + " Ime = '" + Ime + "', "
                + " Prezime = '" + Prezime + "', "
                + " JMBG = '" + JMBG + "', "
                + " BrojLicneKarte = '" + BrojLicneKarte + "', "
                + " KontaktTelefon = '" + KontaktTelefon + "', "
                + " Imejl = '" + Imejl + "', "
                + " Adresa = '" + Adresa + "', "
                + " PrivremenaAdresa = '" + PrivremenaAdresa + "', "
                + " Zanimanje = '" + Zanimanje + "' ";
    }

    @Override
    public String getByIDOne() {
        return " WHERE c.IDC = '" + IDC + "' ";
    }

    @Override
    public String alijasiZaKolone() {
        return "*";
    }

    @Override
    public String getByIDAll() {
        return " ORDER BY IME,PREZIME,IDC";
    }

}
