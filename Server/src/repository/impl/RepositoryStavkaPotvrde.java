/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import domain.Clan;
import domain.Knjiga;
import domain.Potvrda;
import domain.StavkaPotvrde;
import domain.Zaposleni;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author Stefan
 */
public class RepositoryStavkaPotvrde implements DbRepository<StavkaPotvrde> {

    Connection connection;

    public RepositoryStavkaPotvrde() {

    }

    @Override
    public void kreiraj(StavkaPotvrde stavka) throws SQLException, IOException {
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "INSERT INTO Stavke (RBStavke, Napomena, knjiga, potvrda) VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setInt(1, stavka.getRBStavke());
            statement.setString(2, stavka.getNapomena());
            statement.setString(3, stavka.getKnjiga().getIDK());
            statement.setString(4, stavka.getPotvrda().getIDP());
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreirana stavka potvrde.");
        } catch (SQLException ex) {
            System.out.println("Neuspesno kreirana stavka potvrde!\n" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public StavkaPotvrde vrati(StavkaPotvrde s) throws SQLException, IOException {
        try {
            int RBStavke = s.getRBStavke();
            String IDP = s.getPotvrda().getIDP();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "SELECT "
                    + "s.RBStavke AS srb,"
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
                    + "c.Zanimanje AS cz "
                    + "FROM Stavke s INNER JOIN Knjige k ON s.knjiga=k.IDK INNER JOIN Potvrde p ON s.potvrda=p.IDP INNER JOIN Zaposleni z ON p.zaposleni=z.IDZ INNER JOIN Clanovi c ON p.clan=c.IDC "
                    + "WHERE s.RBStavke=? AND s.potvrda=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setInt(1, RBStavke);
            statement.setString(2, IDP);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                StavkaPotvrde stavka = new StavkaPotvrde();
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
                System.out.println("Uspesno ucitana stavka potvrde.");
                return stavka;
            } else {
                rs.close();
                statement.close();
                System.out.println("Stavka potvrde ne postoji u bazi.");
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Neupseno ucitana stavka potvrde!\n" + ex.getMessage());
            throw ex;
        }
    }
    
    public List<StavkaPotvrde> vratiStavkePotvrde(Potvrda p) throws SQLException, IOException {
        try {
            String IDP = p.getIDP();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "SELECT "
                    + "s.RBStavke AS srb,"
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
                    + "c.Zanimanje AS cz "
                    + "FROM Stavke s INNER JOIN Knjige k ON s.knjiga=k.IDK INNER JOIN Potvrde p ON s.potvrda=p.IDP INNER JOIN Zaposleni z ON p.zaposleni=z.IDZ INNER JOIN Clanovi c ON p.clan=c.IDC "
                    + "WHERE s.potvrda=? "
                    + "ORDER BY s.RBStavke";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, IDP);
            ResultSet rs = statement.executeQuery();
            List<StavkaPotvrde> stavke = new ArrayList<>();
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
            System.out.println("Uspesno ucitane stavka potvrde.");
            rs.close();
            statement.close();
            System.out.println("Stavka potvrde ne postoji u bazi.");
            return stavke;
        } catch (SQLException ex) {
            System.out.println("Neupseno ucitana stavka potvrde!\n" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<StavkaPotvrde> vratiSve() throws SQLException, IOException {
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            List<StavkaPotvrde> stavke = new ArrayList<>();
            String upit = "SELECT "
                    + "s.RBStavke AS srb,"
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
                    + "c.Zanimanje AS cz "
                    + "FROM Stavke s INNER JOIN Knjige k ON s.knjiga=k.IDK INNER JOIN Potvrde p ON s.potvrda=p.IDP INNER JOIN Zaposleni z ON p.zaposleni=z.IDZ INNER JOIN Clanovi c ON p.clan=c.IDC ";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
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
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista stavki.");
            return stavke;
        } catch (SQLException ex) {
            System.out.println("Neupseno ucitana lista stavki!\n" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public void obrisi(StavkaPotvrde stavka) throws SQLException, IOException {
        try {
            int RBStavke = stavka.getRBStavke();
            String potvrda = stavka.getPotvrda().getIDP();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "DELETE FROM Stavke WHERE RBStavke=? AND potvrda=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setInt(1, RBStavke);
            statement.setString(2, potvrda);
            int i = statement.executeUpdate();
            statement.close();
            if (i == 1) {
                System.out.println("Uspesno obrisana stavka potvrde.");
            } else {
                System.out.println("Stavka potvrde ne postoji u bazi.");
            }
        } catch (SQLException ex) {
            System.out.println("Neupseno obrisana stavka potvrde!\n" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public void azuriraj(StavkaPotvrde stavka) throws SQLException, IOException {
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "UPDATE Stavke SET RBStavke=?, Napomena=?, knjiga=?, potvrda=? WHERE RBStavke=? AND potvrda=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setInt(1, stavka.getRBStavke());
            statement.setString(2, stavka.getNapomena());
            statement.setString(3, stavka.getKnjiga().getIDK());
            statement.setString(4, stavka.getPotvrda().getIDP());
            statement.setInt(5, stavka.getRBStavke());
            statement.setString(6, stavka.getPotvrda().getIDP());
            int i = statement.executeUpdate();
            statement.close();
            if (i == 1) {
                System.out.println("Uspesno azurirana stavka potvrde.");
            } else {
                System.out.println("Stavka potvrde ne postoji u bazi.");
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno azurirana stavka potvrde!\n" + ex.getMessage());
            throw ex;
        }
    }
    
    
}
