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
public class Zaposleni extends AbstractDomainObject implements Serializable {

    private String IDZ;
    private String Ime;
    private String Prezime;
    private String Username;
    private String Password;

    public Zaposleni() {

    }

    public Zaposleni(String IDZ, String Ime, String Prezime, String Username, String Password) {
        this.IDZ = IDZ;
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.Username = Username;
        this.Password = Password;
    }

    public String getIDZ() {
        return IDZ;
    }

    public String getIme() {
        return Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setIDZ(String IDZ) {
        this.IDZ = IDZ;
    }

    public void setIme(String Ime) {
        this.Ime = Ime;
    }

    public void setPrezime(String Prezime) {
        this.Prezime = Prezime;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return Ime + " " + Prezime + " " + IDZ;
    }

    public String podaciOZaposlenom() {
        return "Zaposleni{" + "IDZ=" + IDZ + ", Ime=" + Ime + ", Prezime=" + Prezime + ", Username=" + Username + ", Password" + Password + "}";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.IDZ);
        hash = 71 * hash + Objects.hashCode(this.Ime);
        hash = 71 * hash + Objects.hashCode(this.Prezime);
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
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.IDZ, other.IDZ)) {
            return false;
        }
        return true;
    }

    @Override
    public String nazivTabele() {
        return " zaposleni ";
    }

    @Override
    public String alijas() {
        return " z ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public AbstractDomainObject vratiJednog(ResultSet rs) throws SQLException {
        Zaposleni zaposleni = new Zaposleni();
        if (rs.next()) {
            zaposleni.setIDZ(IDZ);
            zaposleni.setIme(rs.getString("Ime"));
            zaposleni.setPrezime(rs.getString("Prezime"));
            zaposleni.setUsername(rs.getString("Username"));
            zaposleni.setPassword(rs.getString("Password"));
        }
        return zaposleni;
    }

    @Override
    public List<AbstractDomainObject> vratiSve(ResultSet rs) throws SQLException {
        List<AbstractDomainObject> zaposleni = new ArrayList<>();
        while (rs.next()) {
            Zaposleni z = new Zaposleni();
            z.setIDZ(rs.getString("IDZ"));
            z.setIme(rs.getString("Ime"));
            z.setPrezime(rs.getString("Prezime"));
            z.setUsername(rs.getString("Username"));
            z.setPassword(rs.getString("Password"));
            zaposleni.add(z);
        }
        return zaposleni;
    }

    @Override
    public String koloneZaInsert() {
        return "IDZ, Ime, Prezime, Username, Password";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " IDZ = '" + IDZ + "' ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + IDZ + "', "
                + "'" + Ime + "', "
                + "'" + Prezime + "', "
                + "'" + Username + "', "
                + "'" + Password + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " IDZ = '" + IDZ + "', "
                + " Ime = '" + Ime + "', "
                + " Prezime = '" + Prezime + "', "
                + " Username = '" + Username + "', "
                + " Password = '" + Password + "' ";
    }

    @Override
    public String getByIDOne() {
        return " WHERE z.IDZ = '" + IDZ + "' ";
    }

    @Override
    public String alijasiZaKolone() {
        return "*";
    }

    @Override
    public String getByIDAll() {
        return "";
    }

}
