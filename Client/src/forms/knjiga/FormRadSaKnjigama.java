/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.knjiga;

import domain.Knjiga;
import form.tablemodel.TableModelKnjige;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author Stefan
 */
public class FormRadSaKnjigama extends javax.swing.JDialog {

    /**
     * Creates new form FrmPretraziKnjige
     */
    private List<Knjiga> knjige;
    
    public FormRadSaKnjigama(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        pripremiTabelu();
    }
    
    private void pripremiTabelu() {
        TableModelKnjige tm = new TableModelKnjige();
        tblKnjige.setModel(tm);
        TableColumn tc = tblKnjige.getColumnModel().getColumn(0);
        tc.setMaxWidth(80);
        tc.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblKriterijum = new javax.swing.JLabel();
        txtKriterijumPretrage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKnjige = new javax.swing.JTable();
        btnPrikaziKnjigu = new javax.swing.JButton();
        btnPretrazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma za rad sa knjigama");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Knjige biblioteke", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        lblKriterijum.setText("Kriterijum pretrage:");

        txtKriterijumPretrage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKriterijumPretrageKeyReleased(evt);
            }
        });

        tblKnjige.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblKnjige);

        btnPrikaziKnjigu.setText("PRIKAŽI KNJIGU");
        btnPrikaziKnjigu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziKnjiguActionPerformed(evt);
            }
        });

        btnPretrazi.setText("PRETRAŽI");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblKriterijum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKriterijumPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPretrazi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrikaziKnjigu)
                .addGap(243, 243, 243))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKriterijum)
                    .addComponent(txtKriterijumPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrikaziKnjigu)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKriterijumPretrageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKriterijumPretrageKeyReleased
        String param = txtKriterijumPretrage.getText().trim();
        ((TableModelKnjige) tblKnjige.getModel()).setParametar(param);
    }//GEN-LAST:event_txtKriterijumPretrageKeyReleased

    private void btnPrikaziKnjiguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziKnjiguActionPerformed
        int selectedRow = tblKnjige.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Niste selektovali knjigu!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                JOptionPane.showMessageDialog(this, "Sistem je našao podatke o izabranoj knjizi.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                Knjiga knjiga = ((TableModelKnjige) tblKnjige.getModel()).getSelectedKnjiga(selectedRow);
                new FormAzuriranjeBrisanjeKnjige(this, rootPaneCheckingEnabled, knjiga).setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da nađe podatke o izabranoj knjizi!", "ERROR", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnPrikaziKnjiguActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        String param = txtKriterijumPretrage.getText().trim();
        ((TableModelKnjige) tblKnjige.getModel()).setParametar(param);
        List<Knjiga> pretraga = ((TableModelKnjige) tblKnjige.getModel()).getAllKnjige();
        if(pretraga.isEmpty()){
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe knjige po zadatoj vrednosti.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Sistem je našao knjige po zadatoj vrednosti.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPrikaziKnjigu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKriterijum;
    private javax.swing.JTable tblKnjige;
    private javax.swing.JTextField txtKriterijumPretrage;
    // End of variables declaration//GEN-END:variables

    
}
