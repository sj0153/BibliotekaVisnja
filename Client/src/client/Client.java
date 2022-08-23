/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import forms.FormLogin;
import java.io.IOException;
import java.net.Socket;
import client.communication.Communication;

/**
 *
 * @author Stefan
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.clientConnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void clientConnect() throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);
        System.out.println("Klijent se povezao.");
        Communication.getInstance().setSocket(socket);
        new FormLogin().setVisible(true);
    }
    
}
