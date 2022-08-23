/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import communication.Operations;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import controller.ServerController;
import domain.Clan;
import domain.Knjiga;
import domain.Potvrda;
import domain.Zaposleni;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class HandleClientThread extends Thread{
    
    private Zaposleni korisnik;
    private final Socket socket;

    public HandleClientThread(Socket socket) {
        this.socket = socket;
    }
    
    
    public Socket getSocket() {
        return socket;
    }
    
    
    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                Request request = (Request) new Receiver(socket).receive();
                Response response = handleRequest(request);
                new Sender(socket).send(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private Response handleRequest(Request request){
        switch (request.getOperacija()) {
                    case Operations.LOGIN:
                        return login(request);
                    case Operations.VRATI_SVE_CLANOVE:
                        return vratiSveClanove(request);
                    case Operations.VRATI_DOSTUPNE_KNJIGE:
                        return vratiDostupneKnjige(request);
                    case Operations.VRATI_SVE_KNJIGE:
                        return vratiSveKnjige(request);
                    case Operations.KREIRAJ_POTVRDU:
                        return kreirajPotvrdu(request);
                    case Operations.VRATI_SVE_POTVRDE:
                        return vratiSvePotvrde(request);
                    case Operations.AZURIRAJ_POTVRDU:
                        return azurirajPotvrdu(request);
                    case Operations.KREIRAJ_CLANA:
                        return kreirajClana(request);
                    case Operations.AZURIRAJ_CLANA:
                        return azurirajClana(request);
                    case Operations.OBRISI_CLANA:
                        return obrisiClana(request);
                    case Operations.KREIRAJ_KNJIGU:
                        return kreirajKnjigu(request);
                    case Operations.OBRISI_KNJIGU:
                        return obrisiKnjigu(request);
                    case Operations.AZURIRAJ_KNJIGU:
                        return azurirajKnjigu(request);
                    default: return null;
                }
    }
    
    private Response login(Request request) {
        Response response = new Response();
        Zaposleni zaposleni = (Zaposleni) request.getArgument();
        try {
            zaposleni = ServerController.getInstance().login(zaposleni);
            System.out.println("Uspesna prijava na sistem.");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(zaposleni);
            korisnik = zaposleni;
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }
    
    private Response vratiSveClanove(Request request){
        Response response = new Response();
        try {
            List<Clan> clanovi = ServerController.getInstance().vratiSveClanove();
            System.out.println("Uspesno ucitani clanovi iz baze.");
            response.setResult(clanovi);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response vratiDostupneKnjige(Request request){
        Response response = new Response();
        try {
            List<Knjiga> knjige = ServerController.getInstance().vratiDostupneKnjige();
            System.out.println("Uspesno ucitani sve dostupne knjige iz baze.");
            response.setResult(knjige);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }

    private Response vratiSveKnjige(Request request) {
        Response response = new Response();
        try {
            List<Knjiga> knjige = ServerController.getInstance().vratiSveKnjige();
            System.out.println("Uspesno ucitani sve dostupne knjige iz baze.");
            response.setResult(knjige);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    public Response kreirajPotvrdu(Request request){
        Response response = new Response();
        try {
            ServerController.getInstance().kreirajPotvrdu((Potvrda)request.getArgument());
            System.out.println("Uspesno kreirana potvrda");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }

    private Response vratiSvePotvrde(Request request) {
        Response response = new Response();
        try {
            List<Potvrda> potvrde = ServerController.getInstance().vratiSvePotvrde();
            System.out.println("Uspesno ucitane potvrde");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(potvrde);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }

    private Response azurirajPotvrdu(Request request) {
        Response response = new Response();
        try {
            ServerController.getInstance().azurirajPotvrdu((Potvrda)request.getArgument());
            System.out.println("Uspesno azurirana potvrda");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }

    private Response kreirajClana(Request request) {
        Response response = new Response();
        try {
            ServerController.getInstance().kreirajClana((Clan) request.getArgument());
            System.out.println("Uspesno kreiran clan biblioteke");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }

    private Response azurirajClana(Request request) {
        Response response = new Response();
        try {
            ServerController.getInstance().azurirajClana((Clan) request.getArgument());
            System.out.println("Uspesno azuriran clan biblioteke");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }

    private Response obrisiClana(Request request) {
        Response response = new Response();
        try {
            ServerController.getInstance().obrisiClana((Clan) request.getArgument());
            System.out.println("Uspesno obrisan clan biblioteke");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }

    private Response kreirajKnjigu(Request request) {
        Response response = new Response();
        try {
            ServerController.getInstance().kreirajKnjigu((Knjiga) request.getArgument());
            System.out.println("Uspesno kreirana knjiga.");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }

    private Response obrisiKnjigu(Request request) {
        Response response = new Response();
        try {
            ServerController.getInstance().obrisiKnjigu((Knjiga) request.getArgument());
            System.out.println("Uspesno obrisana knjiga.");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }

    private Response azurirajKnjigu(Request request) {
        Response response = new Response();
        try {
            ServerController.getInstance().azurirajKnjigu((Knjiga) request.getArgument());
            System.out.println("Uspesno azuriran clan biblioteke");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
}
