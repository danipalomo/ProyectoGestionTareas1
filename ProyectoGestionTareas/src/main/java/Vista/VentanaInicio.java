package Vista;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

public class VentanaInicio extends JFrame implements Serializable {
    /**
     * Creates new form VentanaGestorTareas
     */
    public VentanaInicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    public void initComponents() {

        jLabel2 = new JLabel();
        filler1 = new Box.Filler(new Dimension(276, 0), new Dimension(276, 0), new Dimension(276, 32767));
        entradaNombreProyecto = new JTextField();
        botonCrearProyecto = new JButton();
        jLabel1 = new JLabel();
        botonAbrirProyecto = new JButton();
        mensajeError = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("CREAR NUEVO PROYECTO");

        botonCrearProyecto.setText("CREAR");

        botonAbrirProyecto.setText("ABRIR PROYECTO");

        ActionListener crearProyectoListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getEntradaNombreProyecto().getText().equals("")){
                    setMensajeError("*Nombre de proyecto obligatorio");
                } else {
                    controlador.crearProyecto();
                }
            }
        };
        botonCrearProyecto.addActionListener(crearProyectoListener);

        ActionListener abrirProyectoListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    controlador.cargarProyecto();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        };
        botonAbrirProyecto.addActionListener(abrirProyectoListener);


        mensajeError.setForeground(new Color(255, 0, 51));


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(filler1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(mensajeError)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(botonAbrirProyecto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(entradaNombreProyecto))
                                                .addGap(18, 18, 18)
                                                .addComponent(botonCrearProyecto)))
                                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(entradaNombreProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonCrearProyecto))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonAbrirProyecto)
                                .addGap(9, 9, 9)
                                .addComponent(mensajeError)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }// </editor-fold>

    public Box.Filler getFiller1() {
        return filler1;
    }

    public JButton getBotonCrearProyecto() {
        return botonCrearProyecto;
    }

    public JButton getBotonAbrirProyecto() {
        return botonAbrirProyecto;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JTextField getEntradaNombreProyecto() {
        return entradaNombreProyecto;
    }

    public void setControlador(Controlador c){
        controlador=c;
    }

    public void setMensajeError(String mensajeError){
        this.mensajeError.setText(mensajeError);
    }

    // Variables declaration - do not modify
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton botonCrearProyecto;
    private javax.swing.JButton botonAbrirProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField entradaNombreProyecto;
    private Controlador controlador;
    private javax.swing.JLabel mensajeError;
    // End of variables declaration
}
