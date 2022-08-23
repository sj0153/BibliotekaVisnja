/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.clan;

import controller.ClientController;
import domain.Clan;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class FormAzuriranjeBrisanjeClana extends javax.swing.JDialog {

    /**
     * Creates new form FrmAzuriranjeClana
     */
    
    private final Clan clan;
    
    public FormAzuriranjeBrisanjeClana(JDialog parent, boolean modal, Clan clan) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.clan = clan;
        pripremiFormu();
    }
    
    private void pripremiFormu(){
        txtIDC.setText(clan.getIDC());
        txtIme.setText(clan.getIme());
        txtPrezime.setText(clan.getPrezime());
        txtJMBG.setText(clan.getJMBG());
        txtBrojLicneKarte.setText(clan.getBrojLicneKarte());
        txtImejl.setText(clan.getImejl());
        txtKontaktTelefon.setText(clan.getKontaktTelefon());
        txtAdresa.setText(clan.getAdresa());
        txtPrivremenaAdresa.setText(clan.getPrivremenaAdresa());
        txtZanimanje.setText(clan.getZanimanje());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtBrojLicneKarte = new javax.swing.JTextField();
        txtZanimanje = new javax.swing.JTextField();
        lblKontaktTelefon = new javax.swing.JLabel();
        txtKontaktTelefon = new javax.swing.JTextField();
        lblImejl = new javax.swing.JLabel();
        btnPonisti = new javax.swing.JButton();
        lblIme = new javax.swing.JLabel();
        txtImejl = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        lblAdresa = new javax.swing.JLabel();
        btnAzuriraj = new javax.swing.JButton();
        lblPrezime = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        lblPrivremenaAdresa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblBrojLicneKarte = new javax.swing.JLabel();
        txtPrivremenaAdresa = new javax.swing.JTextField();
        txtJMBG = new javax.swing.JTextField();
        lblIDC = new javax.swing.JLabel();
        btnObrisi = new javax.swing.JButton();
        txtIDC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ažuriranje/Brisanje člana");
        setIconImages(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Zanimanje:");

        lblKontaktTelefon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKontaktTelefon.setText("Kontakt telefon: *");

        lblImejl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImejl.setText("Imejl:");

        btnPonisti.setText("PONIŠTI");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        lblIme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIme.setText("Ime: *");

        lblAdresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdresa.setText("Adresa: *");

        btnAzuriraj.setText("AŽURIRAJ");
        btnAzuriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajActionPerformed(evt);
            }
        });

        lblPrezime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrezime.setText("Prezime: *");

        lblPrivremenaAdresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrivremenaAdresa.setText("Privremena adresa:");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("JMBG: *");

        lblBrojLicneKarte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBrojLicneKarte.setText("Broj lične karte: *");

        lblIDC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIDC.setText("IDC:");

        btnObrisi.setText("OBRIŠI");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        txtIDC.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrivremenaAdresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAdresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblImejl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKontaktTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBrojLicneKarte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJMBG)
                            .addComponent(txtBrojLicneKarte)
                            .addComponent(txtKontaktTelefon)
                            .addComponent(txtImejl)
                            .addComponent(txtAdresa)
                            .addComponent(txtPrivremenaAdresa)
                            .addComponent(txtZanimanje, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIme, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIDC)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPonisti, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAzuriraj, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIDC)
                    .addComponent(txtIDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIme)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrezime)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrojLicneKarte)
                    .addComponent(txtBrojLicneKarte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontaktTelefon)
                    .addComponent(txtKontaktTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImejl)
                    .addComponent(txtImejl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresa)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrivremenaAdresa)
                    .addComponent(txtPrivremenaAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtZanimanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPonisti)
                    .addComponent(btnAzuriraj)
                    .addComponent(btnObrisi))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiActionPerformed
        txtIme.setText("");
        txtPrezime.setText("");
        txtJMBG.setText("");
        txtBrojLicneKarte.setText("");
        txtImejl.setText("");
        txtKontaktTelefon.setText("");
        txtAdresa.setText("");
        txtPrivremenaAdresa.setText("");
        txtZanimanje.setText("");
    }//GEN-LAST:event_btnPonistiActionPerformed

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        try {
            validacijaForme();
            clan.setIme(txtIme.getText().trim());
            clan.setPrezime(txtPrezime.getText().trim());
            clan.setJMBG(txtJMBG.getText().trim());
            clan.setBrojLicneKarte(txtBrojLicneKarte.getText().trim());
            clan.setKontaktTelefon(txtKontaktTelefon.getText().trim());
            clan.setImejl(txtImejl.getText().trim());
            clan.setAdresa(txtAdresa.getText().trim());
            clan.setPrivremenaAdresa(txtPrivremenaAdresa.getText().trim());
            clan.setZanimanje(txtZanimanje.getText().trim());
            ClientController.getInstance().azurirajClana(clan);
            JOptionPane.showMessageDialog(this, "Sistem je ažurirao člana.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,"Sistem ne može da ažurira člana.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAzurirajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete ovog člana?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.NO_OPTION) {
            return;
        }
        if (result == JOptionPane.YES_OPTION) {
            try {
                ClientController.getInstance().obrisiClana(clan);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao člana.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Sistem ne može da obriše člana.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnObrisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzuriraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPonisti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAdresa;
    private javax.swing.JLabel lblBrojLicneKarte;
    private javax.swing.JLabel lblIDC;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblImejl;
    private javax.swing.JLabel lblKontaktTelefon;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblPrivremenaAdresa;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtBrojLicneKarte;
    private javax.swing.JTextField txtIDC;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtImejl;
    private javax.swing.JTextField txtJMBG;
    private javax.swing.JTextField txtKontaktTelefon;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtPrivremenaAdresa;
    private javax.swing.JTextField txtZanimanje;
    // End of variables declaration//GEN-END:variables

    private void validacijaForme() throws Exception {
        String poruka = "";
        if (txtIme.getText().trim().equals("")) {
            poruka += "Polje 'Ime' ne moze da bude prazno.\n";
        }
        if (txtIme.getText().trim().length() > 30) {
            poruka += "Ime moze da sadrzi najvise trideset znakova.\n";
        }
        if (txtPrezime.getText().trim().equals("")) {
            poruka += "Polje 'Prezime' ne moze da bude prazno.\n";
        }
        if (txtPrezime.getText().trim().length() > 30) {
            poruka += "Prezime moze da sadrzi najvise trideset znakova.\n";
        }
        if (txtJMBG.getText().trim().equals("")) {
            poruka += "Polje 'JMBG' ne moze da bude prazno.\n";
        }
        if (txtJMBG.getText().trim().length() != 13) {
            poruka += "JMBG mora da sadrzi trinaest cifara.\n";
        }
        if (txtBrojLicneKarte.getText().trim().equals("")) {
            poruka += "Polje 'Broj licne karte' ne moze da bude prazno.\n";
        }
        if (txtBrojLicneKarte.getText().trim().length() != 9) {
            poruka += "Broj licne karte mora da sadrzi devet cifara.\n";
        }
        if (txtKontaktTelefon.getText().trim().equals("")) {
            poruka += "Polje 'Kontakt telefon' ne moze da bude prazno.\n";
        }
        if (txtKontaktTelefon.getText().trim().length() > 13) {
            poruka += "Kontakt telefon moze da sadrzi najvise trinaest znakova.\n";
        }
        if (txtImejl.getText().trim().length() > 30) {
            poruka += "Imejl moze da sadrzi najvise trideset znakova.\n";
        }
        if (txtAdresa.getText().trim().equals("")) {
            poruka += "Polje 'Adresa' ne moze da bude prazno.\n";
        }
        if (txtAdresa.getText().trim().length() > 50) {
            poruka += "Adresa moze da sadrzi najvise pedeset znakova.\n";
        }
        if (txtPrivremenaAdresa.getText().trim().length() > 50) {
            poruka += "Privremena adresa moze da sadrzi najvise pedeset znakova.\n";
        }
        if (txtZanimanje.getText().trim().length() > 50) {
            poruka += "Zanimanje moze da sadrzi najvise pedeset znakova.\n";
        }

        if (!poruka.equals("")) {
            throw new Exception(poruka);
        }
    }
}
