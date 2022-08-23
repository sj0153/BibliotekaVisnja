/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.potvrda;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Potvrda;
import domain.StavkaPotvrde;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Stefan
 */
public class VratiSvePotvrdeSO extends AbstractSO {

    private List<Potvrda> potvrde;

    @Override
    protected void validation(AbstractDomainObject ado) throws Exception {
        if (ado == null || !(ado instanceof Potvrda)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Potvrda!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        List<AbstractDomainObject> ados = DBBroker.getInstance().getAll(ado);
        potvrde = (ArrayList<Potvrda>) (ArrayList<?>) ados;
        for (Potvrda potvrda : potvrde) {
            StavkaPotvrde stavka = new StavkaPotvrde();
            stavka.setPotvrda(potvrda);
            List<AbstractDomainObject> adoss = DBBroker.getInstance().getAll(stavka);
            potvrda.setStavke((ArrayList<StavkaPotvrde>) (ArrayList<?>) adoss);
        }
    }

    public List<Potvrda> getList() {
        return potvrde;
    }

}
