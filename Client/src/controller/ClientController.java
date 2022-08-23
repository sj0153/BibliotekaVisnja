/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import client.communication.Communication;
import communication.Operations;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import domain.Clan;
import domain.Knjiga;
import domain.Potvrda;
import domain.Zaposleni;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class ClientController {

    private static ClientController instance;
    private Zaposleni trenutniKorisnik;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public void setTrenutniKorisnik(Zaposleni trenutniKorisnik) {
        this.trenutniKorisnik = trenutniKorisnik;
    }

    public Zaposleni getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public Zaposleni login(String username, String password) throws Exception {
        Zaposleni zaposleni = new Zaposleni();
        zaposleni.setUsername(username);
        zaposleni.setPassword(password);
        Request request = new Request(Operations.LOGIN, zaposleni);
        Response response = Communication.getInstance().login(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            Zaposleni z = (Zaposleni) response.getResult();
            return z;
        } else {
            throw response.getException();
        }
    }

    public List<Clan> vratiSveClanove() throws Exception {
        Request request = new Request(Operations.VRATI_SVE_CLANOVE, null);
        Response response = Communication.getInstance().vratiSveClanove(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return (List) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Knjiga> vratiDostupneKnjige() throws Exception {
        Request request = new Request(Operations.VRATI_DOSTUPNE_KNJIGE, null);
        Response response = Communication.getInstance().vratiDostupneKnjige(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return (List) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Knjiga> vratiSveKnjige() throws Exception {
        Request request = new Request(Operations.VRATI_SVE_KNJIGE, null);
        Response response = Communication.getInstance().vratiSveKnjige(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return (List) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void kreirajPotvrdu(Potvrda potvrda) throws Exception {
        Request request = new Request(Operations.KREIRAJ_POTVRDU, potvrda);
        Response response = Communication.getInstance().kreirajPotvrdu(request);
        if (response.getResponseType().equals(ResponseType.ERROR)) {
            throw response.getException();
        }
    }

    public List<Potvrda> vratiSvePotvrde() throws Exception {
        Request request = new Request(Operations.VRATI_SVE_POTVRDE, null);
        Response response = Communication.getInstance().vratiSvePotvrde(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return (List) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void azurirajPotvrdu(Potvrda potvrda) throws Exception {
        Request request = new Request(Operations.AZURIRAJ_POTVRDU, potvrda);
        Response response = Communication.getInstance().azurirajPotvrdu(request);
        if (response.getResponseType().equals(ResponseType.ERROR)) {
            throw response.getException();
        }
    }

    public void kreirajClana(Clan clan) throws Exception {
        Request request = new Request(Operations.KREIRAJ_CLANA, clan);
        Response response = Communication.getInstance().kreirajClana(request);
        if (response.getResponseType().equals(ResponseType.ERROR)) {
            throw response.getException();
        }
    }

    public void azurirajClana(Clan clan) throws Exception {
        Request request = new Request(Operations.AZURIRAJ_CLANA, clan);
        Response response = Communication.getInstance().azurirajClana(request);
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }

    public void obrisiClana(Clan clan) throws Exception {
        Request request = new Request(Operations.OBRISI_CLANA, clan);
        Response response = Communication.getInstance().obrisiClana(request);
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }

    public void kreirajKnjigu(Knjiga knjiga) throws Exception {
        Request request = new Request(Operations.KREIRAJ_KNJIGU, knjiga);
        Response response = Communication.getInstance().kreirajKnjigu(request);
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }

    public void obrisiKnjigu(Knjiga knjiga) throws Exception {
        Request request = new Request(Operations.OBRISI_KNJIGU, knjiga);
        Response response = Communication.getInstance().obrisiKnjigu(request);
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }
    
    public void azurirajKnjigu(Knjiga knjiga) throws Exception {
        Request request = new Request(Operations.AZURIRAJ_KNJIGU, knjiga);
        Response response = Communication.getInstance().azurirajClana(request);
        if(response.getResponseType().equals(ResponseType.ERROR)){
            throw response.getException();
        }
    }
}
