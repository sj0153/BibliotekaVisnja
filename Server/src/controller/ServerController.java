/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Clan;
import domain.Knjiga;
import domain.Potvrda;
import domain.StavkaPotvrde;
import domain.Zaposleni;
import java.util.List;
import so.clan.AzurirajClanaSO;
import so.clan.KreirajClanaSO;
import so.clan.ObrisiClanaSO;
import so.clan.VratiSveClanoveSO;
import so.knjiga.AzurirajKnjiguSO;
import so.knjiga.KreirajKnjiguSO;
import so.knjiga.ObrisiKnjiguSO;
import so.knjiga.VratiSveKnjigeSO;
import so.potvrda.AzurirajPotvrduSO;
import so.potvrda.KreirajPotvrduSO;
import so.potvrda.ObrisiPotvrduSO;
import so.potvrda.VratiSvePotvrdeSO;
import so.stavka.KreirajStavkuSO;
import so.stavka.ObrisiStavkuSO;
import so.stavka.VratiStavkePotvrdeSO;
import so.zaposleni.VratiSveZaposleneSO;

/**
 *
 * @author Stefan
 */
public class ServerController {

    private static ServerController instance;
    private Zaposleni trenutniKorisnik;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Zaposleni login(Zaposleni za) throws Exception {
        VratiSveZaposleneSO so = new VratiSveZaposleneSO();
        so.execute(new Zaposleni());
        List<Zaposleni> korisnici = so.getList();
        for (Zaposleni z : korisnici) {
            if (z.getUsername().equals(za.getUsername()) && z.getPassword().equals(za.getPassword())) {
                return z;
            }
        }
        throw new Exception("Nepoznati korisnik!");
    }

    public List<Clan> vratiSveClanove() throws Exception {
        VratiSveClanoveSO so = new VratiSveClanoveSO();
        so.execute(new Clan());
        return so.getList();
    }

    public void kreirajClana(Clan clan) throws Exception {
        KreirajClanaSO so = new KreirajClanaSO();
        so.execute(clan);
    }

    public void obrisiClana(Clan clan) throws Exception {
        ObrisiClanaSO so = new ObrisiClanaSO();
        so.execute(clan);
    }

    public void azurirajClana(Clan clan) throws Exception {
        AzurirajClanaSO so = new AzurirajClanaSO();
        so.execute(clan);
    }

    public List<Knjiga> vratiSveKnjige() throws Exception {
        VratiSveKnjigeSO so = new VratiSveKnjigeSO();
        so.execute(new Knjiga());
        return so.getList();
    }

    public List<Knjiga> vratiDostupneKnjige() throws Exception {
        VratiSveKnjigeSO so1 = new VratiSveKnjigeSO();
        so1.execute(new Knjiga());
        List<Knjiga> knjige = so1.getList();
        VratiSvePotvrdeSO so2 = new VratiSvePotvrdeSO();
        so2.execute(new Potvrda());
        List<Potvrda> potvrde = so2.getList();
        for (Potvrda potvrda : potvrde) {
            if(potvrda.getDatumVracanja() == null){
                for (StavkaPotvrde stavkaPotvrde : potvrda.getStavke()) {
                    knjige.remove(stavkaPotvrde.getKnjiga());
                }
            }
        }
        return knjige;
    }

    public void kreirajKnjigu(Knjiga knjiga) throws Exception {
        KreirajKnjiguSO so = new KreirajKnjiguSO();
        so.execute(knjiga);
    }

    public void obrisiKnjigu(Knjiga knjiga) throws Exception {
        ObrisiKnjiguSO so = new ObrisiKnjiguSO();
        so.execute(knjiga);
    }

    public void azurirajKnjigu(Knjiga knjiga) throws Exception {
        AzurirajKnjiguSO so = new AzurirajKnjiguSO();
        so.execute(knjiga);
    }

    public List<Potvrda> vratiSvePotvrde() throws Exception {
        VratiSvePotvrdeSO so = new VratiSvePotvrdeSO();
        so.execute(new Potvrda());
        return so.getList();
    }

    public void kreirajPotvrdu(Potvrda potvrda) throws Exception {
        KreirajPotvrduSO so = new KreirajPotvrduSO();
        so.execute(potvrda);
    }

    public void obrisiPotvrdu(Potvrda potvrda) throws Exception {
        ObrisiPotvrduSO so = new ObrisiPotvrduSO();
        so.execute(potvrda);
    }

    public void azurirajPotvrdu(Potvrda potvrda) throws Exception {
        AzurirajPotvrduSO so = new AzurirajPotvrduSO();
        so.execute(potvrda);
    }

    public List<StavkaPotvrde> vratiStavkePotvrde(Potvrda potvrda) throws Exception {
        VratiStavkePotvrdeSO so = new VratiStavkePotvrdeSO();
        StavkaPotvrde stavka = new StavkaPotvrde();
        stavka.setPotvrda(potvrda);
        so.execute(stavka);
        return so.getList();
    }

    public void kreirajStavkuPotvrde(StavkaPotvrde stavka) throws Exception {
        KreirajStavkuSO so = new KreirajStavkuSO();
        so.execute(stavka);
    }

    public void obrisiStavkuPotvrde(StavkaPotvrde stavka) throws Exception {
        ObrisiStavkuSO so = new ObrisiStavkuSO();
        so.execute(stavka);
    }

    public List<Zaposleni> vratiSveZaposlene() throws Exception {
        VratiSveZaposleneSO so = new VratiSveZaposleneSO();
        so.execute(new Zaposleni());
        return so.getList();
    }

    public Zaposleni getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Zaposleni trenutniKorisnik) {
        this.trenutniKorisnik = trenutniKorisnik;
    }

}
