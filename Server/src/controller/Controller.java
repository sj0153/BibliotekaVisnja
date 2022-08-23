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
import java.sql.SQLException;
import java.util.List;
import repository.db.DbRepository;
import repository.impl.*;

/**
 *
 * @author Stefan
 */
public class Controller {

    private static Controller instance;
    private final DbRepository zaposleniRep;
    private final DbRepository clanoviRep;
    private final DbRepository knjigeRep;
    private final DbRepository potvrdeRep;
    private final DbRepository stavkeRep;
    private Zaposleni trenutniKorisnik;

    private Controller() throws SQLException {
        this.zaposleniRep = new RepositoryZaposleni();
        this.clanoviRep = new RepositoryClan();
        this.knjigeRep = new RepositoryKnjiga();
        this.potvrdeRep = new RepositoryPotvrda();
        this.stavkeRep = new RepositoryStavkaPotvrde();
    }

    public static Controller getInstance() throws SQLException {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Zaposleni login(Zaposleni za) throws Exception {
        List<Zaposleni> korisnici = zaposleniRep.vratiSve();
        for (Zaposleni z : korisnici) {
            if (z.getUsername().equals(za.getUsername()) && z.getPassword().equals(za.getPassword())) {
                return z;
            }
        }
        throw new Exception("Nepoznati korisnik!");
    }

    public List<Clan> vratiSveClanove() throws Exception {
        clanoviRep.connect();
        try {
            List<Clan> c = clanoviRep.vratiSve();
            clanoviRep.commit();
            return c;
        } catch (SQLException ex) {
            clanoviRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            clanoviRep.disconnect();
        }
    }

    public Clan vratiClana(String IDC) throws Exception {
        clanoviRep.connect();
        try {
            Clan c = new Clan();
            c.setIDC(IDC);
            Clan clan = (Clan) clanoviRep.vrati(c);
            clanoviRep.commit();
            return clan;
        } catch (SQLException ex) {
            clanoviRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            clanoviRep.disconnect();
        }
    }

    public void kreirajClana(Clan clan) throws Exception {
        clanoviRep.connect();
        try {
            clanoviRep.kreiraj(clan);
            clanoviRep.commit();
        } catch (SQLException ex) {
            clanoviRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            clanoviRep.disconnect();
        }
    }

    public void kreirajClanove(List<Clan> clanovi) throws Exception {
        clanoviRep.connect();
        try {
            for (Clan clan : clanovi) {
                clanoviRep.kreiraj(clan);
            }
            clanoviRep.commit();
        } catch (SQLException ex) {
            clanoviRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            clanoviRep.disconnect();
        }
    }

    public void obrisiClana(Clan clan) throws Exception {
        clanoviRep.connect();
        try {
            clanoviRep.obrisi(clan);
            clanoviRep.commit();
        } catch (SQLException ex) {
            clanoviRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            clanoviRep.disconnect();
        }
    }

    public void azurirajClana(Clan clan) throws Exception {
        clanoviRep.connect();
        try {
            clanoviRep.azuriraj(clan);
            clanoviRep.commit();
        } catch (SQLException ex) {
            clanoviRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            clanoviRep.disconnect();
        }
    }

    public List<Knjiga> vratiSveKnjige() throws Exception {
        knjigeRep.connect();
        try {
            List<Knjiga> knjige = knjigeRep.vratiSve();
            knjigeRep.commit();
            return knjige;
        } catch (SQLException ex) {
            knjigeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            knjigeRep.disconnect();
        }
    }

    public List<Knjiga> vratiDostupneKnjige() throws Exception {
        knjigeRep.connect();
        try {
            List<Knjiga> knjige = ((RepositoryKnjiga) knjigeRep).vratiDostupne();
            knjigeRep.commit();
            return knjige;
        } catch (SQLException ex) {
            knjigeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            knjigeRep.disconnect();
        }
    }

    public void kreirajKnjigu(Knjiga knjiga) throws Exception {
        knjigeRep.connect();
        try {
            knjigeRep.kreiraj(knjiga);
            knjigeRep.commit();
        } catch (SQLException ex) {
            knjigeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            knjigeRep.disconnect();
        };
    }

    public void obrisiKnjigu(Knjiga knjiga) throws Exception {
        knjigeRep.connect();
        try {
            knjigeRep.obrisi(knjiga);
            knjigeRep.commit();
        } catch (SQLException ex) {
            knjigeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            knjigeRep.disconnect();
        };
    }

    public void azurirajKnjigu(Knjiga knjiga) throws Exception {
        knjigeRep.connect();
        try {
            knjigeRep.azuriraj(knjiga);
            knjigeRep.commit();
        } catch (SQLException ex) {
            knjigeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            knjigeRep.disconnect();
        };
    }

    public Knjiga vratiKnjigu(String IDK) throws Exception {
        knjigeRep.connect();
        try {
            Knjiga k = new Knjiga();
            k.setIDK(IDK);
            Knjiga knjiga = (Knjiga) knjigeRep.vrati(k);
            knjigeRep.commit();
            return knjiga;
        } catch (SQLException ex) {
            knjigeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            knjigeRep.disconnect();
        }
    }

    public List<Potvrda> vratiSvePotvrde() throws Exception {
        potvrdeRep.connect();
        try {
            List<Potvrda> potvrde = potvrdeRep.vratiSve();
            potvrdeRep.commit();
            for (Potvrda potvrda : potvrde) {
                potvrda.setStavke(((RepositoryStavkaPotvrde) stavkeRep).vratiStavkePotvrde(potvrda));
            }
            return potvrde;
        } catch (SQLException ex) {
            potvrdeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            potvrdeRep.disconnect();
        }
    }

    public void kreirajPotvrdu(Potvrda potvrda) throws Exception {
        potvrdeRep.connect();
        try {
            potvrdeRep.kreiraj(potvrda);
            potvrdeRep.commit();
            List<StavkaPotvrde> stavke = potvrda.getStavke();
            for (StavkaPotvrde stavkaPotvrde : stavke) {
                kreirajStavkuPotvrde(stavkaPotvrde);
            }
        } catch (SQLException ex) {
            potvrdeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            potvrdeRep.disconnect();
        }
    }

    public void obrisiPotvrdu(Potvrda potvrda) throws Exception {
        potvrdeRep.connect();
        try {
            List<StavkaPotvrde> stavke = potvrda.getStavke();
            for (StavkaPotvrde stavkaPotvrde : stavke) {
                obrisiStavkuPotvrde(stavkaPotvrde);
            }
            potvrdeRep.obrisi(potvrda);
            potvrdeRep.commit();
        } catch (SQLException ex) {
            potvrdeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            potvrdeRep.disconnect();
        }
    }

    public void azurirajPotvrdu(Potvrda potvrda) throws Exception {
        potvrdeRep.connect();
        try {
            potvrdeRep.azuriraj(potvrda);
            potvrdeRep.commit();
            List<StavkaPotvrde> stavke = potvrda.getStavke();
            for (StavkaPotvrde stavkaPotvrde : stavke) {
                azurirajStavkuPotvrde(stavkaPotvrde);
            }
        } catch (SQLException ex) {
            potvrdeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            potvrdeRep.disconnect();
        }
    }

    public Potvrda vratiPotvrdu(String IDP) throws Exception {
        potvrdeRep.connect();
        try {
            Potvrda p = new Potvrda();
            p.setIDP(IDP);
            Potvrda potvrda = (Potvrda) potvrdeRep.vrati(p);
            potvrdeRep.commit();
            potvrda.setStavke(((RepositoryStavkaPotvrde) stavkeRep).vratiStavkePotvrde(p));
            return potvrda;
        } catch (SQLException ex) {
            potvrdeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            potvrdeRep.disconnect();
        }
    }

    public List<StavkaPotvrde> vratiSveStavke() throws Exception {
        stavkeRep.connect();
        try {
            List<StavkaPotvrde> stavke = stavkeRep.vratiSve();
            stavkeRep.commit();
            return stavke;
        } catch (SQLException ex) {
            stavkeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            stavkeRep.disconnect();
        }
    }

    public List<StavkaPotvrde> vratiStavkePotvrde(String IDP) throws Exception {
        stavkeRep.connect();
        try {
            Potvrda p = new Potvrda();
            p.setIDP(IDP);
            List<StavkaPotvrde> stavke = ((RepositoryStavkaPotvrde) stavkeRep).vratiStavkePotvrde(p);
            stavkeRep.commit();
            return stavke;
        } catch (SQLException ex) {
            stavkeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            stavkeRep.disconnect();
        }
    }

    public StavkaPotvrde vratiStavku(int RBStavke, String IDP) throws Exception {
        stavkeRep.connect();
        try {
            StavkaPotvrde s = new StavkaPotvrde();
            s.setRBStavke(RBStavke);
            Potvrda p = new Potvrda();
            p.setIDP(IDP);
            s.setPotvrda(p);
            StavkaPotvrde stavka = (StavkaPotvrde) stavkeRep.vrati(s);
            stavkeRep.commit();
            return stavka;
        } catch (SQLException ex) {
            stavkeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            stavkeRep.disconnect();
        }
    }

    public void kreirajStavkuPotvrde(StavkaPotvrde stavka) throws Exception {
        stavkeRep.connect();
        try {
            stavkeRep.kreiraj(stavka);
            stavkeRep.commit();
        } catch (SQLException ex) {
            stavkeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            stavkeRep.disconnect();
        }
    }

    public void obrisiStavkuPotvrde(StavkaPotvrde stavka) throws Exception {
        stavkeRep.connect();
        try {
            stavkeRep.obrisi(stavka);
            stavkeRep.commit();
        } catch (SQLException ex) {
            stavkeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            stavkeRep.disconnect();
        }
    }

    public void azurirajStavkuPotvrde(StavkaPotvrde stavka) throws Exception {
        stavkeRep.connect();
        try {
            stavkeRep.azuriraj(stavka);
            stavkeRep.commit();
        } catch (SQLException ex) {
            stavkeRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            stavkeRep.disconnect();
        }
    }

    public List<Zaposleni> vratiSveZaposlene() throws Exception {
        zaposleniRep.connect();
        try {
            List<Zaposleni> zaposleni = zaposleniRep.vratiSve();
            zaposleniRep.commit();
            return zaposleni;
        } catch (SQLException ex) {
            zaposleniRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            zaposleniRep.disconnect();
        }
    }

    public Zaposleni vratiZaposlenog(String IDZ) throws Exception {
        zaposleniRep.connect();
        try {
            Zaposleni z = new Zaposleni();
            z.setIDZ(IDZ);
            Zaposleni zaposleni = (Zaposleni) zaposleniRep.vrati(z);
            zaposleniRep.commit();
            return zaposleni;
        } catch (SQLException ex) {
            zaposleniRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            zaposleniRep.disconnect();
        }
    }

    public void kreirajZaposlenog(Zaposleni z) throws Exception {
        zaposleniRep.connect();
        try {
            zaposleniRep.kreiraj(z);
            zaposleniRep.commit();
        } catch (SQLException ex) {
            zaposleniRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            zaposleniRep.disconnect();
        }
    }

    public void obrisiZaposlenog(Zaposleni z) throws Exception {
        zaposleniRep.connect();
        try {
            zaposleniRep.obrisi(z.getIDZ());
            zaposleniRep.commit();
        } catch (SQLException ex) {
            zaposleniRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            zaposleniRep.disconnect();
        }
    }

    public void azurirajZaposlenog(Zaposleni zaposleni) throws Exception {
        zaposleniRep.connect();
        try {
            zaposleniRep.azuriraj(zaposleni);
            zaposleniRep.commit();
        } catch (SQLException ex) {
            zaposleniRep.rollback();
            ex.printStackTrace();
            throw ex;
        } finally {
            zaposleniRep.disconnect();
        }
    }

    public Zaposleni getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Zaposleni trenutniKorisnik) {
        this.trenutniKorisnik = trenutniKorisnik;
    }

}
