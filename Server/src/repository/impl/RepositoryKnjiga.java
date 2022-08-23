/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import domain.Knjiga;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
public class RepositoryKnjiga implements DbRepository<Knjiga> {

    Connection connection;

    public RepositoryKnjiga() {

    }

    @Override
    public void kreiraj(Knjiga knjiga) throws SQLException, IOException {
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "INSERT INTO Knjige (IDK, Naziv, Autor, Kategorija) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, knjiga.getIDK());
            statement.setString(2, knjiga.getNaziv());
            statement.setString(3, knjiga.getAutor());
            statement.setString(4, knjiga.getKategorija());
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreirana knjiga.");
        } catch (SQLException ex) {
            System.out.println("Neuspeno kreirana knjiga!\n" + ex.getMessage());
            throw ex;
        }

    }

    @Override
    public Knjiga vrati(Knjiga knjiga) throws SQLException, IOException {
        try {
            String IDK = knjiga.getIDK();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "SELECT IDK, Naziv, Autor, Kategorija FROM Knjige WHERE IDK=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, IDK);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Knjiga k = new Knjiga();
                k.setIDK(IDK);
                k.setNaziv(rs.getString("Naziv"));
                k.setAutor(rs.getString("Autor"));
                k.setKategorija(rs.getString("Kategorija"));
                rs.close();
                statement.close();
                System.out.println("Uspesno ucitana knjiga.");
                return k;
            } else {
                System.out.println("Knjiga ne postoji u bazi!");
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno ucitana knjiga!\n" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<Knjiga> vratiSve() throws SQLException, IOException {
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            List<Knjiga> knjige = new ArrayList<>();
            String upit = "SELECT IDK, Naziv, Autor, Kategorija FROM Knjige ORDER BY Naziv, Autor, IDK";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while (rs.next()) {
                Knjiga knjiga = new Knjiga();
                knjiga.setIDK(rs.getString("IDK"));
                knjiga.setNaziv(rs.getString("Naziv"));
                knjiga.setAutor(rs.getString("Autor"));
                knjiga.setKategorija(rs.getString("Kategorija"));
                knjige.add(knjiga);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista knjiga.");
            return knjige;
        } catch (SQLException ex) {
            System.out.println("Neuspeno ucitana lista knjiga!\n" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public void obrisi(Knjiga knjiga) throws SQLException, IOException {
        try {
            String IDK = knjiga.getIDK();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "DELETE FROM Knjige WHERE IDK=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, IDK);
            int i = statement.executeUpdate();
            statement.close();
            if (i == 1) {
                System.out.println("Uspesno obrisana knjiga.");
            } else {
                System.out.println("Knjiga ne postoji u bazi!");
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno obrisana knjiga!\n" + ex.getMessage());
            throw ex;
        }

    }

    @Override
    public void azuriraj(Knjiga knjiga) throws SQLException, IOException {
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "UPDATE Knjige SET IDK=?, Naziv=?, Autor=?, Kategorija=? WHERE IDK=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, knjiga.getIDK());
            statement.setString(2, knjiga.getNaziv());
            statement.setString(3, knjiga.getAutor());
            statement.setString(4, knjiga.getKategorija());
            statement.setString(5, knjiga.getIDK());
            int i = statement.executeUpdate();
            statement.close();
            if (i == 1) {
                System.out.println("Uspesno azurirana knjiga.");
            } else {
                System.out.println("Knjiga ne postoji u bazi.");
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno azurirana knjiga!\n" + ex.getMessage());
            throw ex;
        }
    }

    public List<Knjiga> vratiDostupne() throws SQLException, IOException {
        try {
            List<Knjiga> knjige = vratiSve();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "SELECT k.IDK AS kidk,"
                    + "k.Naziv AS kn,"
                    + "k.Autor AS ka,"
                    + "k.Kategorija AS kk,"
                    + "s.potvrda AS sp,"
                    + "s.knjiga AS sk,"
                    + "p.IDP AS pidp,"
                    + "p.DatumVracanja AS pdv "
                    + "FROM Knjige k INNER JOIN Stavke s ON k.IDK=s.knjiga INNER JOIN Potvrde p ON s.potvrda=p.IDP";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while (rs.next()) {
                Knjiga knjiga = new Knjiga();
                knjiga.setIDK(rs.getString("kidk"));
                knjiga.setNaziv(rs.getString("kn"));
                knjiga.setAutor(rs.getString("ka"));
                knjiga.setKategorija(rs.getString("kk"));
                if (rs.getDate("pdv") == null) {
                    knjige.remove(knjiga);
                }
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista dostupnih knjiga.");
            return knjige;
        } catch (SQLException ex) {
            System.out.println("Neuspeno ucitana lista dostuponih knjiga!\n" + ex.getMessage());
            throw ex;
        }
    }

}
