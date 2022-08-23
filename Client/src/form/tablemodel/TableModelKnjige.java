/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.tablemodel;

import controller.ClientController;
import domain.Knjiga;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class TableModelKnjige extends AbstractTableModel implements Runnable {

    private String columnNames[] = new String[]{"IDK", "Naziv", "Autor", "Kategorija"};
    private Class columnClass[] = new Class[]{String.class, String.class, String.class, String.class};
    private List<Knjiga> knjige;
    private String parametar = "";

    public TableModelKnjige() {
        try {
            knjige = ClientController.getInstance().vratiSveKnjige();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        if (knjige == null) {
            return 0;
        } else {
            return knjige.size();
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
        Knjiga knjiga = knjige.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return knjiga.getIDK();
            case 1:
                return knjiga.getNaziv();
            case 2:
                return knjiga.getAutor();
            case 3:
                return knjiga.getKategorija();
            default:
                return "n/a";
        }
    }

    public List<Knjiga> getAllKnjige() {
        return knjige;
    }

    public Knjiga getSelectedKnjiga(int selectedRow) {
        return knjige.get(selectedRow);
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
            knjige = ClientController.getInstance().vratiSveKnjige();
            if (!parametar.equals("")) {
                List<Knjiga> novaLista = new ArrayList<>();
                for (Knjiga k : knjige) {
                    if (k.getNaziv().toLowerCase().contains(parametar.toLowerCase()) || k.getAutor().toLowerCase().contains(parametar.toLowerCase()) || k.getKategorija().toLowerCase().contains(parametar.toLowerCase()) || k.getIDK().contains(parametar)) {
                        novaLista.add(k);
                    }
                }
                knjige = novaLista;
            }
            fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
