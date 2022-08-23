/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.knjiga;

import controller.ClientController;
import domain.Knjiga;
import domain.util.RandomID;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class FormKreirajKnjigu extends javax.swing.JDialog {

    /**
     * Creates new form FrmKreirajKnjigu
     */
    public FormKreirajKnjigu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            setLocationRelativeTo(null);
            JOptionPane.showMessageDialog(this, "Sistem je kreirao novu knjigu.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da kreira novu knjigu.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIDK = new javax.swing.JButton();
        txtIDK = new javax.swing.JTextField();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblKategorija = new javax.swing.JLabel();
        txtKategorija = new javax.swing.JTextField();
        btnPonisti = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma za kreiranje knjige");
        setResizable(false);

        btnIDK.setText("IDK *");
        btnIDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDKActionPerformed(evt);
            }
        });

        lblNaziv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNaziv.setText("Naziv: *");

        lblAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAutor.setText("Autor: *");

        lblKategorija.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKategorija.setText("Kategorija: *");

        btnPonisti.setText("PONIŠTI");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        btnOtkazi.setText("OTKAŽI");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("SAČUVAJ");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNaziv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIDK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblKategorija, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKategorija, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIDK)
                    .addComponent(txtAutor))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(btnOtkazi)
                .addGap(18, 18, 18)
                .addComponent(btnPonisti)
                .addGap(18, 18, 18)
                .addComponent(btnSacuvaj)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIDK))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutor)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKategorija)
                    .addComponent(txtKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPonisti)
                    .addComponent(btnOtkazi)
                    .addComponent(btnSacuvaj))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDKActionPerformed
        txtIDK.setText(RandomID.generisiID());
    }//GEN-LAST:event_btnIDKActionPerformed

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiActionPerformed
        txtIDK.setText("");
        txtNaziv.setText("");
        txtAutor.setText("");
        txtKategorija.setText("");
    }//GEN-LAST:event_btnPonistiActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            validacijaForme();
            Knjiga knjiga = new Knjiga();
            knjiga.setIDK(txtIDK.getText().trim());
            knjiga.setNaziv(txtNaziv.getText().trim());
            knjiga.setAutor(txtAutor.getText().trim());
            knjiga.setKategorija(txtKategorija.getText().trim());
            ClientController.getInstance().kreirajKnjigu(knjiga);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtion novu knjigu i uneo je u biblioteku.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti novu knjigu.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIDK;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnPonisti;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblKategorija;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtIDK;
    private javax.swing.JTextField txtKategorija;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void validacijaForme() throws Exception {
        String poruka = "";
        if (txtIDK.getText().trim().equals("")) {
            poruka += "Polje 'IDK' ne moze da bude prazno.\n";
        }
        if (txtIDK.getText().trim().length() != 10) {
            poruka += "IDK mora da sadrzi deset znakova.\n";
        }
        if (txtNaziv.getText().trim().equals("")) {
            poruka += "Polje 'Naziv' ne moze da bude prazno.\n";
        }
        if (txtNaziv.getText().trim().length() > 50) {
            poruka += "Ime moze da sadrzi najvise pedeset znakova.\n";
        }
        if (txtAutor.getText().trim().equals("")) {
            poruka += "Polje 'Autor' ne moze da bude prazno.\n";
        }
        if (txtAutor.getText().trim().length() > 50) {
            poruka += "Autor moze da sadrzi najvise pedeset znakova.\n";
        }
        if (txtKategorija.getText().trim().equals("")) {
            poruka += "Polje 'Kategorija' ne moze da bude prazno.\n";
        }
        if (txtKategorija.getText().trim().length() > 50) {
            poruka += "Kategorija moze da sadrzi najvise pedeset cifara.\n";
        }
        if (!poruka.equals("")) {
            throw new Exception(poruka);
        }
    }
}