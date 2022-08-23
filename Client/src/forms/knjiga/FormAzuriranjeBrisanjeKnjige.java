/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.knjiga;

import controller.ClientController;
import domain.Knjiga;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class FormAzuriranjeBrisanjeKnjige extends javax.swing.JDialog {

    /**
     * Creates new form FrmObrisiKnjigu
     */
    private final Knjiga knjiga;

    public FormAzuriranjeBrisanjeKnjige(JDialog parent, boolean modal, Knjiga knjiga) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.knjiga = knjiga;
        pripremiFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblKategorija = new javax.swing.JLabel();
        txtKategorija = new javax.swing.JTextField();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        btnObrisiKnjigu = new javax.swing.JButton();
        btnAzuriraj = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIDK = new javax.swing.JTextField();
        btnPonisti3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ažuriranje/Brisanje knjige");

        lblAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAutor.setText("Autor:");

        lblKategorija.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKategorija.setText("Kategorija:");

        lblNaziv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNaziv.setText("Naziv:");

        btnObrisiKnjigu.setText("OBRIŠI");
        btnObrisiKnjigu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiKnjiguActionPerformed(evt);
            }
        });

        btnAzuriraj.setText("AŽURIRAJ");
        btnAzuriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IDK:");

        txtIDK.setEditable(false);

        btnPonisti3.setText("PONIŠTI");
        btnPonisti3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonisti3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNaziv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKategorija, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKategorija, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAutor)
                            .addComponent(txtIDK)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPonisti3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnAzuriraj, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisiKnjigu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAzuriraj)
                    .addComponent(btnObrisiKnjigu)
                    .addComponent(btnPonisti3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiKnjiguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiKnjiguActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete ovog člana?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.NO_OPTION) {
            return;
        }
        if (result == JOptionPane.YES_OPTION) {
            try {
                ClientController.getInstance().obrisiKnjigu(knjiga);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao knjigu.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Sistem ne može da obriše knjigu.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnObrisiKnjiguActionPerformed

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        try {
            validacijaForme();
            knjiga.setNaziv(txtNaziv.getText().trim());
            knjiga.setAutor(txtAutor.getText().trim());
            knjiga.setKategorija(txtKategorija.getText().trim());
            ClientController.getInstance().azurirajKnjigu(knjiga);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio podatke o knjizi.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,"Sistem ne može da zapamti podatke o knjizi.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAzurirajActionPerformed

    private void btnPonisti3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonisti3ActionPerformed
        txtNaziv.setText("");
        txtAutor.setText("");
        txtKategorija.setText("");
    }//GEN-LAST:event_btnPonisti3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzuriraj;
    private javax.swing.JButton btnObrisiKnjigu;
    private javax.swing.JButton btnPonisti;
    private javax.swing.JButton btnPonisti1;
    private javax.swing.JButton btnPonisti2;
    private javax.swing.JButton btnPonisti3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblKategorija;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtIDK;
    private javax.swing.JTextField txtKategorija;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu() {
        txtIDK.setText(knjiga.getIDK());
        txtNaziv.setText(knjiga.getNaziv());
        txtAutor.setText(knjiga.getAutor());
        txtKategorija.setText(knjiga.getKategorija());
    }
    
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
