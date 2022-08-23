 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

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
public class RepositoryZaposleni implements DbRepository<Zaposleni>{
    
    Connection connection;
    
    public RepositoryZaposleni() {

    }
    
    @Override
     public void kreiraj(Zaposleni zaposleni) throws SQLException, IOException{
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "INSERT INTO Zaposleni (IDZ, Ime, Prezime, Username, Password) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, zaposleni.getIDZ());
            statement.setString(2, zaposleni.getIme());
            statement.setString(3, zaposleni.getPrezime());
            statement.setString(4, zaposleni.getUsername());
            statement.setString(5, zaposleni.getPassword());
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreiran zaposleni.");            
        } catch (SQLException ex) {
            System.out.println("Neuspesno kreiran zaposleni!\n" + ex.getMessage());
            throw ex;
        }
        
    }
     
    @Override
     public Zaposleni vrati(Zaposleni z) throws SQLException, IOException{
        try {
            String IDZ = z.getIDZ();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "SELECT IDZ, Ime, Prezime, Username, Password FROM Zaposleni WHERE IDZ=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1, IDZ);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                Zaposleni zaposleni = new Zaposleni();
                zaposleni.setIDZ(IDZ);
                zaposleni.setIme(rs.getString("Ime"));
                zaposleni.setPrezime(rs.getString("Prezime"));
                zaposleni.setUsername(rs.getString("Username"));
                zaposleni.setPassword(rs.getString("Password"));
                rs.close();
                statement.close();
                System.out.println("Uspesno ucitan zaposleni.");
                return zaposleni;
             }else{
                 System.out.println("Zaposleni ne postoji u bazi.");
                 return null;
             }
        } catch (SQLException ex) {
            System.out.println("Neuspesno ucitan zaposleni!\n" + ex.getMessage());
            throw ex;
        }
    }
     
    @Override
    public List<Zaposleni> vratiSve() throws SQLException, IOException {
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            List<Zaposleni> zaposleni = new ArrayList<>();
            String upit = "SELECT IDZ, Ime, Prezime, Username, Password FROM Zaposleni ORDER BY Ime, Prezime";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while(rs.next()){
                Zaposleni z = new Zaposleni();
                z.setIDZ(rs.getString("IDZ"));
                z.setIme(rs.getString("Ime"));
                z.setPrezime(rs.getString("Prezime"));
                z.setUsername(rs.getString("Username"));
                z.setPassword(rs.getString("Password"));
                zaposleni.add(z);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista zaposlenih.");
            return zaposleni;
        } catch (SQLException ex) {
            System.out.println("Neuspesno ucitana lista zaposlenih!\n" + ex.getMessage());
            throw ex;
        }
    }
    
    @Override
     public void obrisi(Zaposleni zaposleni) throws SQLException, IOException{
        try {
            String IDZ = zaposleni.getIDZ();
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "DELETE FROM Zaposleni WHERE IDZ=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1,IDZ);
            int i = statement.executeUpdate();
            statement.close();
            if(i == 1){
                System.out.println("Uspesno obrisan zaposleni.");
             }else{
                 System.out.println("Zaposleni ne postoji u bazi.");
             }
        } catch (SQLException ex) {
            System.out.println("Neuspesno obrisan zaposleni!\n" + ex.getMessage());
            throw ex;
        }
    }
    @Override
     public void azuriraj(Zaposleni z) throws SQLException, IOException {
        try {
            connection = DbConnectionFactory.getInstance().getConnection();
            String upit = "UPDATE Zaposleni SET IDZ=?, Ime=?, Prezime=?, Username=?, Password=? WHERE IDZ=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            statement.setString(1,z.getIDZ());
            statement.setString(2,z.getIme());
            statement.setString(3,z.getPrezime());
            statement.setString(4,z.getUsername());
            statement.setString(5,z.getPassword());
            statement.setString(6,z.getIDZ());
            int i = statement.executeUpdate();
            statement.close();
            if(i == 1){
                System.out.println("Uspesno azuriran zaposleni.");
            }else{
                System.out.println("Zaposleni ne postoji u bazi.");
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno azuriran zaposleni!\n" + ex.getMessage());
            throw ex;
        }
    }
    
}
