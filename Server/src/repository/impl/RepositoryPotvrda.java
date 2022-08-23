/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import domain.Clan;
import domain.Potvrda;
import domain.Zaposleni;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author Stefan
 */
public class RepositoryPotvrda implements DbRepository<Potvrda> {

    Connection connection;

    public RepositoryPotvrda() {

    }

    @Override
    public void kreiraj(Potvrda potvrda) throws SQLException, IOException {
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "INSERT INTO Potvrde (IDP, DatumIzdavanja, RokZaVracanje, DatumVracanja, zaposleni, clan) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, potvrda.getIDP());
            if (potvrda.getDatumIzdavanja() != null) {
                statement.setDate(2, new Date(potvrda.getDatumIzdavanja().getTime()));
            } else {
                statement.setDate(2, null);
            }
            if (potvrda.getRokZaVracanje() != null) {
                statement.setDate(3, new Date(potvrda.getRokZaVracanje().getTime()));
            } else {
                statement.setDate(3, null);
            }
            if (potvrda.getDatumVracanja() != null) {
                statement.setDate(4,new Date(potvrda.getDatumVracanja().getTime()));
            } else {
                statement.setDate(4, null);
            }
            statement.setString(5, potvrda.getZaposleni().getIDZ());
            statement.setString(6, potvrda.getClan().getIDC());
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreirana potvrda.");
        } catch (SQLException ex) {
            System.out.println("Neuspesno kreirana potvrda!\n" + ex.getMessage());
            throw ex;
        }

    }

    @Override
    public Potvrda vrati(Potvrda potvrda) throws SQLException, IOException {
        try {
            String IDP = potvrda.getIDP();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "SELECT "
                    + "p.IDP AS pidp,"
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
                    + "c.Zanimanje AS cz "
                    + "FROM Potvrde p INNER JOIN Zaposleni z ON p.zaposleni=z.IDZ INNER JOIN Clanovi c ON p.clan=c.IDC "
                    + "WHERE p.IDP=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, IDP);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Potvrda p = new Potvrda();
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
                rs.close();
                statement.close();
                System.out.println("Uspesno ucitana potvrda.");
                return p;
            } else {
                rs.close();
                statement.close();
                System.out.println("Potvrda ne postoji u bazi.");
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Neuspeno ucitana potvrda!\n" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<Potvrda> vratiSve() throws SQLException, IOException {
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            List<Potvrda> potvrde = new ArrayList<>();
            String upit = "SELECT "
                    + "p.IDP AS pidp,"
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
                    + "c.Zanimanje AS cz "
                    + "FROM Potvrde p INNER JOIN Zaposleni z ON p.zaposleni=z.IDZ INNER JOIN Clanovi c ON p.clan=c.IDC "
                    + "ORDER BY p.IDP";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
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
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista potvrda.");
            return potvrde;
        } catch (SQLException ex) {
            System.out.println("Neuspeno ucitana lista potvrda!\n" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public void obrisi(Potvrda potvrda) throws SQLException, IOException {
        try {
            String IDP = potvrda.getIDP();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "DELETE FROM Potvrde WHERE IDP=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, IDP);
            int i = statement.executeUpdate();
            statement.close();
            if (i == 1) {
                System.out.println("Uspesno obrisana potvrda.");
            } else {
                System.out.println("Potvrda ne postoji u bazi.");
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno obrisana potvrda!\n" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public void azuriraj(Potvrda potvrda) throws SQLException, IOException {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "UPDATE Potvrde SET IDP=?, DatumIzdavanja=?, RokZaVracanje=?, DatumVracanja=?, zaposleni=?, clan=? WHERE IDP=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, potvrda.getIDP());
            statement.setString(2, format.format(potvrda.getDatumIzdavanja()));
            statement.setString(3, format.format(potvrda.getRokZaVracanje()));
            statement.setString(4, format.format(potvrda.getDatumVracanja()));
            statement.setString(5, potvrda.getZaposleni().getIDZ());
            statement.setString(6, potvrda.getClan().getIDC());
            statement.setString(7, potvrda.getIDP());
            int i = statement.executeUpdate();
            statement.close();
            if (i == 1) {
                System.out.println("Uspesno azurirana potvrda.");
            } else {
                System.out.println("Potvrda ne postoji u bazi.");
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno azurirana potvrda!\n" + ex.getMessage());
            throw ex;
        }
    }
}
