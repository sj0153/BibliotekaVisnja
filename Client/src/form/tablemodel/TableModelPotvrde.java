/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.tablemodel;

import domain.Potvrda;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import controller.ClientController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class TableModelPotvrde extends AbstractTableModel implements Runnable {

    private String columnNames[] = new String[]{"IDP", "Član", "Datum izdavanja"};
    private Class columnClass[] = new Class[]{String.class, String.class, String.class};
    private List<Potvrda> potvrde;
    private String parametar = "";
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public TableModelPotvrde() {
        try {
            potvrde = ClientController.getInstance().vratiSvePotvrde();
            for(int i = 0 ; i < potvrde.size(); i++){
                if(potvrde.get(i).getDatumVracanja()!= null){
                    potvrde.remove(i);
                    i--;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        if (potvrde == null) {
            return 0;
        } else {
            return potvrde.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex > columnNames.length) {
            return "n/a";
        } else {
            return columnNames[columnIndex];
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex > columnClass.length) {
            return Object.class;
        } else {
            return columnClass[columnIndex];
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Potvrda potvrda = potvrde.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return potvrda.getIDP();
            case 1:
                return potvrda.getClan().getIme() + " " + potvrda.getClan().getPrezime();
            case 2:
                return format.format(potvrda.getDatumIzdavanja());
            default:
                return "n/a";
        }
    }

    public List<Potvrda> getAllPotvrde() {
        return potvrde;
    }

    public Potvrda getSelectedPotvrda(int selectedRow) {
        return potvrde.get(selectedRow);
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
            potvrde = ClientController.getInstance().vratiSvePotvrde();
            for(int i = 0 ; i < potvrde.size(); i++){
                if(potvrde.get(i).getDatumVracanja()!= null){
                    potvrde.remove(i);
                    i--;
                }
            }
            if (!parametar.equals("")) {
                List<Potvrda> novaLista = new ArrayList<>();
                for (Potvrda p : potvrde) {
                    if (p.getIDP().toLowerCase().contains(parametar.toLowerCase()) || (p.getClan().getIme() + " " + p.getClan().getPrezime()).toLowerCase().contains(parametar.toLowerCase()) || format.format(p.getDatumIzdavanja()).contains(parametar.toLowerCase())) {
                        novaLista.add(p);
                    }
                }
                potvrde = novaLista;
            }
            fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
