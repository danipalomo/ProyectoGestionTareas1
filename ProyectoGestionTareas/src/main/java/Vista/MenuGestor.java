/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Persona;
import Clases.Proyecto;
import Clases.Tarea;
import Controlador.Controlador;
import Modelo.Modelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import Controlador.*;
/**
 *
 * @author alemo
 */
public class MenuGestor extends javax.swing.JFrame implements Serializable {

    /**
     * Creates new form MenuGestor
     */
    private ControladorInterfaz controlador;
    private DarAltaTarea darAltaTarea=new DarAltaTarea();
    private DarAltaPersona darAltaPersona=new DarAltaPersona();

    private EditarTarea editarTarea=new EditarTarea();


    public void setDarAltaTarea(DarAltaTarea aT){
        darAltaTarea=aT;
    }

    public void setControlador(ControladorInterfaz c){
        this.controlador=c;
    }

    public void setEditarTarea(EditarTarea eT){
        editarTarea=eT;
    }

    public void setDarAltaPersona(DarAltaPersona aP){
        darAltaPersona=aP;
    }



    public MenuGestor(boolean c) {
        if(c){initComponents();}
    }

    public JButton getBotonAnyadirPersona() {
        return botonAnyadirPersona;
    }

    public JButton getBotonVerTarea(){ return botonVerTarea; }

    public JList<String> getListaPersonas() {
        return listaPersonas;
    }

    public JButton getBotonCrearTarea() {
        return botonCrearTarea;
    }

    public JButton getBotonEditarPersona() {
        return botonEditarPersona;
    }

    public JButton getBotonEditarTarea() {
        return botonEditarTarea;
    }

    public JButton getBotonGuardarYSalir() {
        return botonGuardarYSalir;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JList<String> getListaTareas() {
        return listaTareas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        botonCrearTarea = new javax.swing.JButton();
        botonAnyadirPersona = new javax.swing.JButton();
        botonGuardarYSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTareas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPersonas = new javax.swing.JList<>();
        botonEditarTarea = new javax.swing.JButton();
        botonEditarPersona = new javax.swing.JButton();
        botonVerTarea = new javax.swing.JButton();
        mensajeError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENÚ PRINCIPAL");

        botonCrearTarea.setText("DAR DE ALTA TAREA");
        botonCrearTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearTareaActionPerformed(evt);
            }
        });

        botonAnyadirPersona.setText("DAR DE ALTA PERSONA");
        botonAnyadirPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnyadirPersonaActionPerformed(evt);
            }
        });



        botonGuardarYSalir.setText("GUARDAR Y SALIR");
        botonGuardarYSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                botonGuardarYSalirActionPerformed(evt);
            }
        });



        jScrollPane1.setViewportView(listaTareas);

        jScrollPane2.setViewportView(listaPersonas);

        botonEditarTarea.setText("EDITAR TAREA");


        botonEditarPersona.setText("EDITAR PERSONA");
        botonEditarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPersonaActionPerformed(evt);
            }
        });



        ActionListener editarTareaListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getListaTareas().isSelectionEmpty()){
                    setMensajeError("*Debes seleccionar una tarea");
                } else {
                    setMensajeError("");
                    controlador.editarTarea();
                }

            }
        };
        botonEditarTarea.addActionListener(editarTareaListener);

        ActionListener guardarListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controlador.guardarProyecto();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        };
        botonGuardarYSalir.addActionListener(guardarListener);

        ActionListener verTareaListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getListaTareas().isSelectionEmpty()){
                    setMensajeError("*Debes seleccionar una tarea");
                } else {
                    setMensajeError("");
                    controlador.verTarea();
                }
            }
        };
        botonVerTarea.addActionListener(verTareaListener);

        ActionListener editarPersonaListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getListaPersonas().isSelectionEmpty()){
                    setMensajeError("*Debes seleccionar una persona");
                } else {
                    setMensajeError("");
                    controlador.editarPersona();
                }

            }
        };
        botonEditarPersona.addActionListener(editarPersonaListener);

        botonVerTarea.setText("VER TAREA");

        mensajeError.setForeground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(mensajeError)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botonGuardarYSalir)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(botonVerTarea)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(botonEditarTarea))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(botonCrearTarea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(74, 74, 74)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                                        .addComponent(botonAnyadirPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(54, 54, 54))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(116, 116, 116)
                                                                .addComponent(botonEditarPersona)
                                                                .addGap(87, 87, 87))))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botonAnyadirPersona, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(botonCrearTarea))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jScrollPane2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(botonEditarTarea)
                                                .addComponent(botonVerTarea))
                                        .addComponent(botonEditarPersona))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(botonGuardarYSalir))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(mensajeError)))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void botonCrearTareaActionPerformed(java.awt.event.ActionEvent evt) {
        darAltaTarea.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }
    public void setMensajeError(String mensajeError){
        this.mensajeError.setText(mensajeError);
    }
    private void botonAnyadirPersonaActionPerformed(java.awt.event.ActionEvent evt) {
        darAltaPersona.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }



    private void botonEliminarPersonaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void botonGuardarYSalirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    /**
     */




    public void actualizarTareas(ArrayList<Tarea> listatareas){
        DefaultListModel tareas=new DefaultListModel();
        tareas.addAll(listatareas);
        listaTareas.setModel(tareas);
    }

    public void actualizarPersonas(ArrayList<Persona> listapersonas){
        DefaultListModel personas=new DefaultListModel();
        personas.addAll(listapersonas);
        listaPersonas.setModel(personas);
    }


    // Variables declaration - do not modify
    private javax.swing.JButton botonAnyadirPersona;
    private javax.swing.JButton botonCrearTarea;
    private javax.swing.JButton botonEditarPersona;
    private javax.swing.JButton botonEditarTarea;
    private javax.swing.JButton botonGuardarYSalir;
    private javax.swing.JButton botonVerTarea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaPersonas;
    private javax.swing.JList<String> listaTareas;
    private javax.swing.JLabel mensajeError;
    // End of variables declaration
}
