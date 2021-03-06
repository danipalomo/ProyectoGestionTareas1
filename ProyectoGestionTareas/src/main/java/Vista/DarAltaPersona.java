/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import Controlador.*;
/**
 *
 * @author alemo
 */
public class DarAltaPersona extends javax.swing.JFrame implements Serializable, Vista {

    /**
     * Creates new form DarAltaPersona
     */
    public DarAltaPersona() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        entradaDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        entradaNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        entradaCorreo = new javax.swing.JTextField();
        botonAnyadir = new javax.swing.JButton();
        mensajeError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DAR DE ALTA PERSONA");

        jLabel1.setText("DNI:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Correo:");

        botonAnyadir.setText("CREAR PERSONA");

        mensajeError.setForeground(new java.awt.Color(204, 0, 51));


        ActionListener personaListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getEntradaDni().getText().equals("")){
                    setMensajeError("*Campo DNI obligatorio");
                } else if(getEntradaNombre().getText().equals("")){
                    setMensajeError("*Campo de Nombre obligatorio");
                } else {
                    controlador.crearPersona();
                }

            }
        };
        botonAnyadir.addActionListener(personaListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(253, Short.MAX_VALUE)
                                .addComponent(botonAnyadir)
                                .addGap(32, 32, 32))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mensajeError)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(entradaDni, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(entradaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(entradaCorreo)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(entradaDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(entradaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(entradaCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(mensajeError)
                                .addGap(46, 46, 46)
                                .addComponent(botonAnyadir)
                                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    /***/

    public void setControlador(ControladorInterfaz c){
        controlador=c;
    }
    // Variables declaration - do not modify
    private javax.swing.JButton botonAnyadir;
    private javax.swing.JTextField entradaCorreo;
    private javax.swing.JTextField entradaDni;
    private javax.swing.JTextField entradaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel mensajeError;

    public ControladorInterfaz controlador;

    public void setMensajeError(String mensajeError){
        this.mensajeError.setText(mensajeError);
    }
    public JButton getBotonAnyadir() {
        return botonAnyadir;
    }

    public JTextField getEntradaNombre() {
        return entradaNombre;
    }

    public JTextField getEntradaCorreo() {
        return entradaCorreo;
    }

    public JTextField getEntradaDni() {
        return entradaDni;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }


    // End of variables declaration
}
