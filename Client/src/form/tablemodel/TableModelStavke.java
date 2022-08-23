/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.tablemodel;

import domain.Knjiga;
import domain.StavkaPotvrde;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class TableModelStavke extends AbstractTableModel{
    
    private String columnNames [] = new String[]{"RB","Knjiga","Napomena"};
    private Class columnClass [] = new Class[]{Integer.class,Knjiga.class,String.class};
    private List<StavkaPotvrde> stavke;

    public TableModelStavke(List<StavkaPotvrde> stavke) {
        this.stavke = stavke;
    }
    
    @Override
    public int getRowCount() {
        if(stavke == null){
            return 0;
        }else{
            return stavke.size();
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
        return columnIndex != 0;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPotvrde stavka = stavke.get(rowIndex);
        switch(columnIndex){
            case 0: return rowIndex + 1;
            case 1: return stavka.getKnjiga();
            case 2: return stavka.getNapomena();
            default : return "n/a";
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        StavkaPotvrde stavka = stavke.get(rowIndex);
        switch(columnIndex){
            case 0: 
                stavka.setRBStavke(rowIndex);
                break;
            case 1:
                stavka.setKnjiga((Knjiga) value);
                break;
            case 2:
                stavka.setNapomena(String.valueOf(value));
                break;
        }
    }
    
    public void addStavka(StavkaPotvrde stavka){
        stavke.add(stavka);
        fireTableDataChanged();
    }
    
    public void removeStavka(int rowIndex){
        stavke.remove(rowIndex);
        fireTableDataChanged();
    }
    
    public List<StavkaPotvrde> getAllStavke(){
        return stavke;
    }
    
}
