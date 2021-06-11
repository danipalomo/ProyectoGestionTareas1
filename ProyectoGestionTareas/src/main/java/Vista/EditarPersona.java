/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Tarea;
import Controlador.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alemo
 */
public class EditarPersona extends javax.swing.JFrame implements Serializable {

    /**
     * Creates new form EditarPersona
     */

    public void actualizarTareas(ArrayList<Tarea> listatareas){
        DefaultListModel tareas=new DefaultListModel();
        tareas.addAll(listatareas);
        this.getListaTareas().setModel(tareas);
    }

    public void actualizarTareasEspecificas(ArrayList<Tarea> listEspec){
        DefaultListModel tareas=new DefaultListModel();
        tareas.addAll(listEspec);
        this.listaTareasAsignadas.setModel(tareas);
    }

    public EditarPersona() {
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

        botonAnyadirTarea = new javax.swing.JButton();
        botonQuitarTarea = new javax.swing.JButton();
        botonBorrarPersona = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTareas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        botonCerrar = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTareasAsignadas = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAnyadirTarea.setText("AÑADIR TAREA");

        botonQuitarTarea.setText("QUITAR TAREA");

        botonBorrarPersona.setText("BORRAR PERSONA");


        jScrollPane1.setViewportView(listaTareas);

        jLabel1.setText("TAREAS");

        botonCerrar.setText("CERRAR");

        ActionListener anyadirPersonaListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.anyadirTareaAPersona();
            }
        };
        botonAnyadirTarea.addActionListener(anyadirPersonaListener);


        ActionListener cerrarListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.cerrarEditarPersona();
            }
        };
        botonCerrar.addActionListener(cerrarListener);

        ActionListener quitarListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.quitarTarea();
            }
        };
        botonQuitarTarea.addActionListener(quitarListener);

        ActionListener borrarPersonaListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.borrarPersona();
            }
        };
        botonBorrarPersona.addActionListener(borrarPersonaListener);

        listaTareasAsignadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jScrollPane2.setViewportView(listaTareasAsignadas);

        jLabel2.setText("TAREAS ASIGNADAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(67, 67, 67))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(botonQuitarTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(botonAnyadirTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(botonBorrarPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(labelError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(92, 92, 92))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(botonCerrar)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(botonAnyadirTarea)
                                .addGap(30, 30, 30)
                                .addComponent(botonQuitarTarea)
                                .addGap(35, 35, 35)
                                .addComponent(botonBorrarPersona)
                                .addGap(18, 18, 18)
                                .addComponent(labelError)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel2)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addContainerGap())))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(botonCerrar)
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    public JButton getBotonAnyadirTarea() {
        return botonAnyadirTarea;
    }

    public void setBotonAnyadirTarea(JButton botonAnyadirTarea) {
        this.botonAnyadirTarea = botonAnyadirTarea;
    }

    public JButton getBotonBorrarPersona() {
        return botonBorrarPersona;
    }

    public void setBotonBorrarPersona(JButton botonBorrarPersona) {
        this.botonBorrarPersona = botonBorrarPersona;
    }

    public JButton getBotonCerrar() {
        return botonCerrar;
    }

    public void setBotonCerrar(JButton botonCerrar) {
        this.botonCerrar = botonCerrar;
    }

    public JButton getBotonQuitarTarea() {
        return botonQuitarTarea;
    }

    public void setBotonQuitarTarea(JButton botonQuitarTarea) {
        this.botonQuitarTarea = botonQuitarTarea;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JList<String> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(JList<String> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }


    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JLabel getLabelError() {
        return labelError;
    }

    public JList<String> getListaTareasAsignadas() {
        return listaTareasAsignadas;
    }

    /*public void setControlador(Controlador c){
            botonAnyadirTarea

        }*/
    public void setControlador(Controlador c){
        controlador=c;
    }


    // Variables declaration - do not modify
    private javax.swing.JButton botonAnyadirTarea;
    private javax.swing.JButton botonBorrarPersona;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonQuitarTarea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> listaTareas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelError;
    private javax.swing.JList<String> listaTareasAsignadas;
    private Controlador controlador;
    // End of variables declaration
}
