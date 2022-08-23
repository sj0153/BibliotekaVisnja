/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.communication;

import communication.Receiver;
import java.net.Socket;
import communication.Response;
import communication.Request;
import communication.Sender;

/**
 *
 * @author Stefan
 */
public class Communication {
    
    private static Communication instance;
    private Socket socket;
    
    private Communication(){
    }
    
    public static Communication getInstance(){
        if(instance == null){
            instance = new Communication();
        }
        return instance;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public Response login(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev za prijavom na sistem je poslat...");
        return (Response) new Receiver(socket).receive();
    }
    
    public Response vratiSveClanove(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev 'vratiSveClanove' je poslat...");
        return (Response) new Receiver(socket).receive();
    }
    
    public Response vratiDostupneKnjige(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev 'vratiDostupneKnjige' je poslat...");
        return (Response) new Receiver(socket).receive();
    }

    public Response vratiSveKnjige(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev 'vratiSveKnjige' je poslat...");
        return (Response) new Receiver(socket).receive();
    }
    
    public Response kreirajPotvrdu(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev 'kreirajPotvrdu' je poslat...");
        return (Response) new Receiver(socket).receive();
    }
    
    public Response vratiSvePotvrde(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev 'vratiSvePotvrde' je poslat...");
        return (Response) new Receiver(socket).receive();
    }
    
    public Response azurirajPotvrdu(Request request) throws Exception{
        new Sender(socket).send(request);
        System.out.println("Zahtev 'azurirajPotvrdu' je poslat...");
        return (Response) new Receiver(socket).receive();
    }

    public Response kreirajClana(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev 'kreirajClana' je poslat...");
        return (Response) new Receiver(socket).receive();
    }

    public Response azurirajClana(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev 'azurirajClana' je poslat...");
        return (Response) new Receiver(socket).receive();
    }

    public Response obrisiClana(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev 'obrisiClana' je poslat...");
        return (Response) new Receiver(socket).receive();
    }

    public Response kreirajKnjigu(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev 'kreirajKnjigu' je poslat...");
        return (Response) new Receiver(socket).receive();
    }

    public Response obrisiKnjigu(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev 'obrisiKnjigu' je poslat...");
        return (Response) new Receiver(socket).receive();
    }
}
