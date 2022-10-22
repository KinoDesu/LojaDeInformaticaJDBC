/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.lojadeinformatica;

import LojaDeInformatica.dao.ComputadorDAO;
import LojaDeInformatica.model.Computador;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Fujimura
 */
public class TelaCadastro extends javax.swing.JInternalFrame {
    
    Computador objComputador = new Computador();

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
        initComponents();
    }

    public TelaCadastro(Computador obj) {
        this.objComputador = obj;
        initComponents();

        this.lblID.setText(String.valueOf(objComputador.getId()));
        this.txtHD.setText(String.valueOf(objComputador.getHd()));
        this.txtProcessador.setText(String.valueOf(objComputador.getProcessador()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldoID = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblHD = new javax.swing.JLabel();
        lblProcessador = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txtHD = new javax.swing.JTextField();
        txtProcessador = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Tela de Cadastro");

        lbldoID.setText("ID:");

        lblID.setText("0");

        lblHD.setText("HD:");

        lblProcessador.setText("Processador:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbldoID)
                            .addComponent(lblHD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID))))
                .addGap(32, 32, 32)
                .addComponent(lblProcessador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProcessador)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldoID)
                    .addComponent(lblID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHD)
                    .addComponent(lblProcessador)
                    .addComponent(txtHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProcessador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHDActionPerformed

    }//GEN-LAST:event_txtHDActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        int id = Integer.parseInt(lblID.getText());

        if (id==0) {

            if (txtHD.getText().length() > 0 && txtProcessador.getText().length() > 0) {
                String hd = txtHD.getText();
                String processador = txtProcessador.getText();

                Computador objComputador = new Computador(id, hd, processador);
                boolean retorno = ComputadorDAO.salvar(objComputador);

                if (retorno) {
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!!\n HD: " + hd + "\nProcessador: " + processador);
                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao gravar nota!");
                }

            } else if (txtHD.getText().length() == 0 || txtProcessador.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            }

        } else {

            //Chamar a alteracao da DAO
                String hd = txtHD.getText();
                String processador = txtProcessador.getText();

                Computador objComputador = new Computador(id, hd, processador);
                boolean retorno = ComputadorDAO.alterar(objComputador);

                if (retorno) {
                    JOptionPane.showMessageDialog(this, "Alterado com sucesso!!\n HD: " + hd + "\nProcessador: " + processador);
                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao gravar nota!");
                }
            }
        
        this.setVisible(false);
        
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblHD;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblProcessador;
    private javax.swing.JLabel lbldoID;
    private javax.swing.JTextField txtHD;
    private javax.swing.JTextField txtProcessador;
    // End of variables declaration//GEN-END:variables
}