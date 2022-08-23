/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.tablemodel;

import domain.Clan;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import controller.ClientController;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class TableModelClanovi extends AbstractTableModel implements Runnable{
    
    private String columnNames [] = new String[]{"IDC","Ime","Prezime"};
    private Class columnClass [] = new Class[]{String.class,String.class,String.class};
    private List<Clan> clanovi;
    private String parametar = "";

    public TableModelClanovi() {
        try{
            clanovi = ClientController.getInstance().vratiSveClanove();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Override
    public int getRowCount() {
        if(clanovi == null){
            return 0;
        }else{
            return clanovi.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if(columnIndex>columnNames.length){
            return "n/a";
        }else{
            return columnNames[columnIndex];
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex>columnClass.length){
            return Object.class;
        }else{
            return columnClass[columnIndex];
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan clan = clanovi.get(rowIndex);
        switch(columnIndex){
            case 0: return clan.getIDC();
            case 1: return clan.getIme();
            case 2: return clan.getPrezime();
            default : return "n/a";
        }
    }
    
    public List<Clan> getAllClanovi(){
        return clanovi;
    }
    
    public Clan getSelectedClan(int selectedRow){
        return clanovi.get(selectedRow);
    }
    
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            clanovi = ClientController.getInstance().vratiSveClanove();
            if (!parametar.equals("")) {
                List<Clan> novaLista = new ArrayList<>();
                for (Clan c : clanovi) {
                    if (c.getIme().toLowerCase().contains(parametar.toLowerCase()) || c.getPrezime().toLowerCase().contains(parametar.toLowerCase()) || c.getIDC().contains(parametar)) {
                        novaLista.add(c);
                    }
                }
                clanovi = novaLista;
            }
            fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
