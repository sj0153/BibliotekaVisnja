/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import domain.Clan;
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
public class RepositoryClan implements DbRepository<Clan>{
    
    Connection connection;
    
    public RepositoryClan(){
        
    }
    
    @Override
    public void kreiraj(Clan clan) throws SQLException, IOException{
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "INSERT INTO Clanovi (IDC, Ime, Prezime, JMBG, BrojLicneKarte, KontaktTelefon, Imejl, Adresa, PrivremenaAdresa, Zanimanje) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, clan.getIDC());
            statement.setString(2, clan.getIme());
            statement.setString(3, clan.getPrezime());
            statement.setString(4, clan.getJMBG());
            statement.setString(5, clan.getBrojLicneKarte());
            statement.setString(6, clan.getKontaktTelefon());
            statement.setString(7, clan.getImejl());
            statement.setString(8, clan.getAdresa());
            statement.setString(9, clan.getPrivremenaAdresa());
            statement.setString(10, clan.getZanimanje());
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreiran clan.");
        } catch (SQLException ex) {
            System.out.println("Neuspeno kreiran clan!\n" + ex.getMessage());
            throw ex;
        }
    }
    
    @Override
    public Clan vrati(Clan clan) throws SQLException, IOException{
        try {
            String IDC = clan.getIDC();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "SELECT IDC, Ime, Prezime, JMBG, BrojLicneKarte, KontaktTelefon, Imejl, Adresa, PrivremenaAdresa, Zanimanje FROM Clanovi WHERE IDC=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, IDC);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                Clan c = new Clan();
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
                rs.close();
                statement.close();
                System.out.println("Uspesno ucitan clan");
                return c;
            }else{
                System.out.println("Clan ne postoji u bazi.");
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno ucitan clan!\n" + ex.getMessage());
            throw ex;
        }
    }
    
    @Override
    public List<Clan> vratiSve() throws SQLException, IOException{
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            List<Clan> clanovi = new ArrayList<>();
            String upit = "SELECT IDC, Ime, Prezime, JMBG, BrojLicneKarte, KontaktTelefon, Imejl, Adresa, PrivremenaAdresa, Zanimanje FROM Clanovi ORDER BY Ime, Prezime";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while(rs.next()){
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
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista clanova.");
            return clanovi;
        } catch (SQLException ex) {
            System.out.println("Neupseno ucitana lista clanova!\n" + ex.getMessage());
            throw ex;
        }
    }
    
    @Override
    public void obrisi(Clan clan) throws SQLException, IOException{
        try {
            String IDC = clan.getIDC();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "DELETE FROM Clanovi WHERE IDC=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, IDC);
            int i = statement.executeUpdate();
            statement.close();
            if(i==1){
                System.out.println("Uspesno obrisan clan");
            }else{
                System.out.println("Clan ne postoji u bazi.");
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno obrisan clan!\n" + ex.getMessage());
            throw ex;
        }
    }
    
    @Override
    public void azuriraj(Clan clan) throws SQLException, IOException{
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "UPDATE Clanovi SET IDC=?, Ime=?, Prezime=?, JMBG=?, BrojLicneKarte=?, KontaktTelefon=?, Imejl=?, Adresa=?, PrivremenaAdresa=?, Zanimanje=? WHERE IDC=?"; 
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1,clan.getIDC());
            statement.setString(2,clan.getIme());
            statement.setString(3,clan.getPrezime());
            statement.setString(4,clan.getJMBG());
            statement.setString(5,clan.getBrojLicneKarte());
            statement.setString(6,clan.getKontaktTelefon());
            statement.setString(7,clan.getImejl());
            statement.setString(8,clan.getAdresa());
            statement.setString(9,clan.getPrivremenaAdresa());
            statement.setString(10,clan.getZanimanje());
            statement.setString(11,clan.getIDC());
            int i = statement.executeUpdate();
            statement.close();
            if(i == 1){
                System.out.println("Uspesno azuriran clan.");
            }else {
                System.out.println("Clan ne postoji u bazi.");
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno azuriranje clana!\n" + ex.getMessage());
            throw ex;
        }
    }
    
}
