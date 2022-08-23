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
public class Knjiga extends AbstractDomainObject implements Serializable {

    private String IDK;
    private String Naziv;
    private String Autor;
    private String Kategorija;

    public Knjiga() {

    }

    public Knjiga(String IDK, String Naziv, String Autor, String Kategorija) {
        this.IDK = IDK;
        this.Naziv = Naziv;
        this.Autor = Autor;
        this.Kategorija = Kategorija;
    }

    public String getIDK() {
        return IDK;
    }

    public String getNaziv() {
        return Naziv;
    }

    public String getAutor() {
        return Autor;
    }

    public String getKategorija() {
        return Kategorija;
    }

    public void setIDK(String IDK) {
        this.IDK = IDK;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public void setKategorija(String Kategorija) {
        this.Kategorija = Kategorija;
    }

    @Override
    public String toString() {
        return Naziv + " | " + Autor + " | " + IDK;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.IDK);
        hash = 53 * hash + Objects.hashCode(this.Naziv);
        hash = 53 * hash + Objects.hashCode(this.Autor);
        hash = 53 * hash + Objects.hashCode(this.Kategorija);
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
        final Knjiga other = (Knjiga) obj;
        if (!Objects.equals(this.IDK, other.IDK)) {
            return false;
        }
        return true;
    }

    @Override
    public String nazivTabele() {
        return " knjige ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException {
        Knjiga k = new Knjiga();
        if (rs.next()) {
            k.setIDK(IDK);
            k.setNaziv(rs.getString("Naziv"));
            k.setAutor(rs.getString("Autor"));
            k.setKategorija(rs.getString("Kategorija"));
            rs.close();
        }
        return k;
    }

    @Override
    public List<AbstractDomainObject> vratiSve(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> knjige = new ArrayList<>();
        while (rs.next()) {
            Knjiga knjiga = new Knjiga();
            knjiga.setIDK(rs.getString("IDK"));
            knjiga.setNaziv(rs.getString("Naziv"));
            knjiga.setAutor(rs.getString("Autor"));
            knjiga.setKategorija(rs.getString("Kategorija"));
            knjige.add(knjiga);
        }
        return knjige;
    }

    @Override
    public String koloneZaInsert() {
        return "IDK, Naziv, Autor, Kategorija";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " IDK = '" + IDK + "' ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + IDK + "', "
                + "'" + Naziv + "', "
                + "'" + Autor + "', "
                + "'" + Kategorija + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " IDK = '" + IDK + "', "
                + " Naziv = '" + Naziv + "', "
                + " Autor = '" + Autor + "', "
                + " Kategorija = '" + Kategorija + "' ";
    }

    @Override
    public String getByIDOne() {
        return " WHERE k.IDK = '" + IDK + "' ";
    }

    @Override
    public String alijasiZaKolone() {
        return "*";
    }

    @Override
    public String getByIDAll() {
        return " ORDER BY Naziv, Autor, IDK";
    }

}
