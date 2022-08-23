/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.IOException;
import threads.ServerThread;

/**
 *
 * @author Stefan
 */
public class FormServer extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    private ServerThread serverThread;

    public FormServer() {
        initComponents();
        btnStopServer.setEnabled(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStartServer = new javax.swing.JButton();
        btnStopServer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuBarServer = new javax.swing.JMenuBar();
        menuConfiguration = new javax.swing.JMenu();
        jmiDatabaseConfiguration = new javax.swing.JMenuItem();
        jmiServerConfiguration = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnStartServer.setText("START");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        btnStopServer.setText("STOP ");
        btnStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopServerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SERVER");

        menuConfiguration.setText("Configuration");

        jmiDatabaseConfiguration.setText("Database configuration");
        jmiDatabaseConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDatabaseConfigurationActionPerformed(evt);
            }
        });
        menuConfiguration.add(jmiDatabaseConfiguration);

        jmiServerConfiguration.setText("Server configuration");
        jmiServerConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiServerConfigurationActionPerformed(evt);
            }
        });
        menuConfiguration.add(jmiServerConfiguration);

        menuBarServer.add(menuConfiguration);

        setJMenuBar(menuBarServer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
        if (serverThread == null || !serverThread.isAlive()) {
            try {
                serverThread = new ServerThread();
                serverThread.start();
                btnStartServer.setEnabled(false);
                btnStopServer.setEnabled(true);
                jmiDatabaseConfiguration.setEnabled(false);
                jmiServerConfiguration.setEnabled(false);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnStartServerActionPerformed

    private void btnStopServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopServerActionPerformed
        if (serverThread != null && serverThread.getServerSocket().isBound()) {
            try {
                serverThread.getServerSocket().close();
                btnStartServer.setEnabled(true);
                btnStopServer.setEnabled(false);
                jmiDatabaseConfiguration.setEnabled(true);
                jmiServerConfiguration.setEnabled(true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnStopServerActionPerformed

    private void jmiDatabaseConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDatabaseConfigurationActionPerformed
        if(btnStartServer.isEnabled()){
            DBConfiguration dbc = new DBConfiguration(this, true);
            dbc.setLocationRelativeTo(this);
            dbc.setVisible(true);
        }else{
            jmiDatabaseConfiguration.setEnabled(false);
        }
    }//GEN-LAST:event_jmiDatabaseConfigurationActionPerformed

    private void jmiServerConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiServerConfigurationActionPerformed
        if(btnStartServer.isEnabled()){
            ServerConfiguration sc = new ServerConfiguration(this, true);
            sc.setLocationRelativeTo(this);
            sc.setVisible(true);
        }else{
            jmiServerConfiguration.setEnabled(false);
        }
    }//GEN-LAST:event_jmiServerConfigurationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartServer;
    private javax.swing.JButton btnStopServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jmiDatabaseConfiguration;
    private javax.swing.JMenuItem jmiServerConfiguration;
    private javax.swing.JMenuBar menuBarServer;
    private javax.swing.JMenu menuConfiguration;
    // End of variables declaration//GEN-END:variables
}