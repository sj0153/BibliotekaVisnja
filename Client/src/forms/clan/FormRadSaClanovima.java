/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.clan;

import domain.Clan;
import form.tablemodel.TableModelClanovi;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author Stefan
 */
public class FormRadSaClanovima extends javax.swing.JDialog {

    /**
     * Creates new form FormPrikaziClanove
     *
     * @param parent
     * @param modal
     */
    public FormRadSaClanovima(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        pripremiTabelu();
    }

    private void pripremiTabelu() {
        TableModelClanovi tm = new TableModelClanovi();
        tblClanovi.setModel(tm);
        TableColumn tc = tblClanovi.getColumnModel().getColumn(0);
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
        tblClanovi = new javax.swing.JTable();
        btnPrikaziClana = new javax.swing.JButton();
        btnPretrazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma za rad sa članovima biblioteke");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Članovi biblioteke", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        lblKriterijum.setText("Kriterijum pretrage:");

        txtKriterijumPretrage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKriterijumPretrageKeyReleased(evt);
            }
        });

        tblClanovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClanovi);
        if (tblClanovi.getColumnModel().getColumnCount() > 0) {
            tblClanovi.getColumnModel().getColumn(0).setResizable(false);
        }

        btnPrikaziClana.setText("PRIKAŽI ČLANA");
        btnPrikaziClana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziClanaActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblKriterijum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKriterijumPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPretrazi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrikaziClana)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrikaziClana)
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

    private void btnPrikaziClanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziClanaActionPerformed
        int selectedRow = tblClanovi.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Niste selektovali člana!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                JOptionPane.showMessageDialog(this, "Sistem je našao podatke o izabranom članu.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                Clan clan = ((TableModelClanovi) tblClanovi.getModel()).getSelectedClan(selectedRow);
                new FormAzuriranjeBrisanjeClana(this, rootPaneCheckingEnabled, clan).setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da nađe podatke o izabranom članu!", "ERROR", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnPrikaziClanaActionPerformed

    private void txtKriterijumPretrageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKriterijumPretrageKeyReleased
        String param = txtKriterijumPretrage.getText().trim();
        ((TableModelClanovi) tblClanovi.getModel()).setParametar(param);
    }//GEN-LAST:event_txtKriterijumPretrageKeyReleased

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        String param = txtKriterijumPretrage.getText().trim();
        ((TableModelClanovi) tblClanovi.getModel()).setParametar(param);
        List<Clan> pretraga = ((TableModelClanovi) tblClanovi.getModel()).getAllClanovi();
        if (pretraga.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe članove po zadatoj vrednosti.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem je našao članove po zadatoj vrednosti.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPrikaziClana;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKriterijum;
    private javax.swing.JTable tblClanovi;
    private javax.swing.JTextField txtKriterijumPretrage;
    // End of variables declaration//GEN-END:variables
}
