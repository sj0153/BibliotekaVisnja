/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import constant.MyServerConstants;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Stefan
 */
public class DbConnectionFactory {
    
    private Connection connection;
    private static DbConnectionFactory instance;
    
    private DbConnectionFactory(){
        
    }
    
    public static DbConnectionFactory getInstance(){
        if(instance == null){
            instance = new DbConnectionFactory();
        }
        return instance;
    }
    
    public Connection getConnection(){
        try {
            if(connection == null || connection.isClosed()){
                Properties properties = new Properties();
                properties.load(new FileInputStream("config/dbconfig.properties"));
                String url = properties.getProperty(MyServerConstants.DB_CONFIG_URL);
                String username = properties.getProperty(MyServerConstants.DB_CONFIG_USERNAME);
                String password = properties.getProperty(MyServerConstants.DB_CONFIG_PASSWORD);
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
                System.out.println("Konekcija je uspesna uspostavljena.");
            }
        } catch (Exception ex) {
            System.out.println("Neuspesna konekcija!\n" + ex.getMessage());
            ex.printStackTrace();
        }
        return connection;
    }
    
}
