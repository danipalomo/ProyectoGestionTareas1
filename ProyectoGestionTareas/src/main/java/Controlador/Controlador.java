package Controlador;

import Clases.Persona;
import Clases.Tarea;
import Excepciones.ListaVaciaException;
import Modelo.Modelo;
import Resultados.Biblioteca;
import Resultados.Documentacion;
import Resultados.PaginaWeb;
import Resultados.Programa;
import Vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controlador implements ActionListener {
    private DarAltaTarea altaTarea;
    private CargarProyecto cargarProyecto;
    private DarAltaPersona darAltaPersona;
    private TareaPaginaWeb tareaPaginaWeb;
    private TareaBiblioteca tareaBiblioteca;
    private TareaPrograma tareaPrograma;
    private MenuGestor menuGestor;
    private TareaDocumentacion tareaDocumentacion;
    private VentanaInicio ventanaInicio;
    private Modelo modelo;
    private EditarPersona editarPersona;
    private EditarTarea editarTarea;
    private DefaultListModel listModelTareas = new DefaultListModel();
    private DefaultListModel listModelPersonas = new DefaultListModel();
    private DefaultListModel listModelTareasDeUnaPersonaEspecifica = new DefaultListModel();
    private DefaultListModel listModelPersonasDeUnaTareaEspecifica = new DefaultListModel();
    private int punteroListaPersonas;
    private int punteroListaTareas;
    private int punteroListaPersonasEditarTarea;
    private int punteroListaPersonasDeUnaTarea;
    private int puntero1; //punteroListaTareas
    private int puntero2; //punteroListaPersonasEditarTarea

    public void borrarListaTareaAsignadasAUnaPersona(Persona p){
        listModelTareasDeUnaPersonaEspecifica.removeAllElements();
        if(puntero1==0){
            listModelTareasDeUnaPersonaEspecifica.removeAllElements();
        }
        for(int i=0; i<p.getListaTareas().size();i++){
            listModelTareasDeUnaPersonaEspecifica.addElement(p.getListaTareas().get(i));
        }
    }

    public void borrarListaPersonasAsignadasAUnaTarea(Tarea t){
        listModelPersonasDeUnaTareaEspecifica.removeAllElements();
        if(punteroListaPersonasDeUnaTarea==0){
            listModelPersonasDeUnaTareaEspecifica.removeAllElements();
        }
        for(int i=0; i<t.getPersonasAsignadas().size();i++){
            listModelPersonasDeUnaTareaEspecifica.addElement(t.getPersonasAsignadas().get(i));
        }
    }
    public void anyadirListaPersonasAsignadasAUnaTarea(){
        listModelPersonasDeUnaTareaEspecifica.addAll(modelo.getProyecto().getListaTareas().get(punteroListaTareas).getPersonasAsignadas());
    }
    public void actualizarListaTareasDeUnaPersonaEspecifica(){
        listModelTareasDeUnaPersonaEspecifica.addAll(modelo.getProyecto().getListaPersonas().get(punteroListaPersonas).getLista());
    }
    public Controlador(DarAltaTarea altaTarea, CargarProyecto cargarProyecto, DarAltaPersona darAltaPersona, TareaPaginaWeb tareaPaginaWeb, TareaBiblioteca tareaBiblioteca, TareaPrograma tareaPrograma, MenuGestor menuGestor, TareaDocumentacion tareaDocumentacion, VentanaInicio ventanaInicio, Modelo modelo, EditarPersona editarPersona, EditarTarea editarTarea) {
        this.altaTarea = altaTarea;
        this.cargarProyecto = cargarProyecto;
        this.darAltaPersona = darAltaPersona;
        this.tareaPaginaWeb = tareaPaginaWeb;
        this.tareaBiblioteca = tareaBiblioteca;
        this.tareaPrograma = tareaPrograma;
        this.menuGestor = menuGestor;
        this.tareaDocumentacion = tareaDocumentacion;
        this.ventanaInicio = ventanaInicio;
        this.modelo = modelo;
        this.editarPersona=editarPersona;
        this.editarTarea=editarTarea;

    }

    public void crearTarea(){
        double costAltaTarea = Double.parseDouble(altaTarea.getEntradaCoste().getText());
        int prioridad = (Integer) altaTarea.getSpinnerPrioridad().getValue();
        double var = Double.parseDouble(altaTarea.getEntradaCoste().getText());
        int numhoras = (Integer) altaTarea.getSpinnerPrioridad().getValue();
        if (altaTarea.getEntradaCoste().getText() != null && altaTarea.getEntradaIdTarea().getText() != null) {
            modelo.darDeAltaTarea(altaTarea.getEntradaTitulo(), altaTarea.getEntradaDescripcion().getText(), altaTarea.getEntradaResponsable().getText(), prioridad, costAltaTarea, altaTarea.getDesplegableTipoFacturacion().getSelectedIndex(), var, altaTarea.getDesplegableInternoExterno().getSelectedIndex(), altaTarea.getEntradaIdTarea().getText(), numhoras, altaTarea.getDesplegableTipoTarea().getSelectedIndex());
        }
        int num = altaTarea.getDesplegableTipoTarea().getSelectedIndex();
        if (num == 0) {
            tareaBiblioteca.setVisible(true);
            altaTarea.setVisible(false);
        } else if (num == 1) {
            tareaDocumentacion.setVisible(true);
            altaTarea.setVisible(false);
        } else if (num == 2) {
            tareaPaginaWeb.setVisible(true);
            altaTarea.setVisible(false);
        } else {
            tareaPrograma.setVisible(true);
            altaTarea.setVisible(false);
        }
    }

    public void terminarBiblioteca(){
        Tarea t = modelo.getUltimaTarea();
        ;//devuelve la ultima tarea creada que se encuentra en la posicion size-1 y ademas es la ultima creada en la ventana anterior :)
        int lineas = (Integer) tareaBiblioteca.getSpinnerNumLineas().getValue();
        int modulos = (Integer) tareaBiblioteca.getSpinnerNumModulos().getValue();
        if (!tareaBiblioteca.getEntradaLenguaje().equals("")) {
            Biblioteca biblio = new Biblioteca(tareaBiblioteca.getEntradaLenguaje().getText(), lineas, modulos);
            t.setResultado(biblio);
            tareaBiblioteca.setVisible(false);
            menuGestor.setVisible(true);
            anyadirTareasGestor();
            actualizarTareasGestor();
        } else {
            System.out.println("Error, no has introducido ningún lenguaje");
        }
    }

    public void terminarDocumentacion(){
        Tarea t = modelo.getUltimaTarea();
        String formato = tareaDocumentacion.getEntradaFormato().getText();
        Double espacio = Double.parseDouble(tareaDocumentacion.getEntradaEspacio().getText());
        int paginas = (Integer) tareaDocumentacion.getSpinnerNumPaginas().getValue();
        if (formato.equals("") || tareaDocumentacion.getEntradaEspacio() == null) {
            System.out.println("No puedes dejar vacíos el tipo de formato ni el espacio en disco");
            if (paginas == 0) {
                System.out.println("La documentacion no puede tener 0 páginas");
            }
        } else {
            Documentacion doc = new Documentacion(formato, paginas, espacio);
            t.setResultado(doc);
            actualizarTareasGestor();
            menuGestor.setVisible(true);
            tareaDocumentacion.setVisible(false);
            anyadirTareasGestor();
            actualizarTareasGestor();
        }
    }

    public void terminarPrograma(){
        Tarea t = modelo.getUltimaTarea();//devuelve la ultima tarea creada que se encuentra en la posicion size-1 y ademas es la ultima creada en la ventana anterior :)
        int lineas = (Integer) tareaPrograma.getSpinnerNumLineas().getValue();
        int modulos = (Integer) tareaPrograma.getSpinnerNumModulos().getValue();
        if (!tareaPrograma.getEntradaLenguaje().getText().equals("")) {
            Programa prog = new Programa(tareaPrograma.getEntradaLenguaje().getText(), lineas, modulos);
            t.setResultado(prog);
            tareaPrograma.setVisible(false);
            menuGestor.setVisible(true);
            anyadirTareasGestor();
            actualizarTareasGestor();
        } else {
            System.out.println("Error, no has introducido ningún lenguaje");
        }
    }

    public void terminarPaginaWeb(){
        Tarea t = modelo.getUltimaTarea();
        int tipo = tareaPaginaWeb.getDesplegableEstaticaDinamica().getSelectedIndex();
        String estaticaDinamica = "Dinámica";
        if (tipo == 0) {
            estaticaDinamica = "Estática";
        }
        String lenguaje = tareaPaginaWeb.getEntradaLenguaje().getText();
        String backend = tareaPaginaWeb.getEntradaBackend().getText();
        PaginaWeb paginaWeb = new PaginaWeb(estaticaDinamica, lenguaje, backend);
        t.setResultado(paginaWeb);
        tareaPaginaWeb.setVisible(false);
        menuGestor.setVisible(true);
        anyadirTareasGestor();
        actualizarTareasGestor();
    }

    public void crearPersona(){
        String dni = darAltaPersona.getEntradaDni().getText();
        String nombre = darAltaPersona.getEntradaNombre().getText();
        String correo = darAltaPersona.getEntradaCorreo().getText();
        if (dni.equals("") || nombre.equals("")) {
            System.out.println("Error, no puedes dejar los campos DNI y Nombre vacíos");
        } else {
            try {
                modelo.darDeAltaPersona(dni, nombre, correo);
            } catch (ListaVaciaException e) {
                e.printStackTrace();
            }
            darAltaPersona.setVisible(false);
            menuGestor.setVisible(true);
            anyadirPersonasGestor();
            actualizarPersonasGestor();
        }
    }




    void actualizarEditarPersona(){
        editarPersona.getjList1().setModel(listModelTareas);
    }
    public void limpiarTareasEditarPersona(){
        editarPersona.getjList1().removeAll();
    }

    /** Editar Tarea Actualizar Listas*/
    public void anyadirEditarTarea( Tarea t){
        listModelPersonasDeUnaTareaEspecifica.removeAllElements();
        if(punteroListaPersonasEditarTarea==0){
            listModelPersonasDeUnaTareaEspecifica.removeAllElements();
        }
        for(int i=0; i<t.getPersonasAsignadas().size();i++){
            listModelPersonasDeUnaTareaEspecifica.addElement(t.getPersonasAsignadas().get(i));
        }
    }

    public void anyadirEditarPersona( Persona p){
        listModelTareasDeUnaPersonaEspecifica.removeAllElements();
        if(puntero2==0){
            listModelTareasDeUnaPersonaEspecifica.removeAllElements();
        }
        for(int i=0; i<p.getListaTareas().size();i++){
            listModelTareasDeUnaPersonaEspecifica.addElement(p.getListaTareas().get(i));
        }
    }
    public void limpiarPersonasEditarTarea(){
        editarTarea.getListaPersonas().removeAll();
    }

    public void borrarPersonaLista(int index){
        this.listModelPersonas.remove(index);
    }
    public void borrarTareaLista(int index){
        this.listModelPersonas.remove(index);
    }

    public void actualizarPersonasEditarTarea(){
        editarTarea.getListaPersonas().setModel(listModelPersonas);
    }

    public void limpiarPersonasEspecificasdeUnaTarea(){
        editarTarea.getListaPersonasAsignadas().removeAll();
    }
    public void actualizarPersonasEspecificasEditarTarea(){
        editarTarea.getListaPersonasAsignadas().setModel(listModelPersonasDeUnaTareaEspecifica);
    }

    /**GEstor Actualizar Listas*/

    public void actualizarPersonasGestor(){
        menuGestor.getListaPersonas().setModel(listModelPersonas);
    }
    public void anyadirPersonasGestor(){
        listModelPersonas.addElement(modelo.getUltimaPersona().toString());
    }
    public void limpiarTareasGestor(){
        menuGestor.getListaTareas().removeAll();
    }

    public void actualizarTareasGestor(){
        menuGestor.getListaTareas().setModel(listModelTareas);
    }
    public void anyadirTareasGestor(){
        listModelTareas.addElement(modelo.getUltimaTarea());
    }
    public void limpiarPersonasGestor(){
        menuGestor.getListaPersonas().removeAll();
    }


    @Override
    public void actionPerformed(ActionEvent evt) {
        if (ventanaInicio.getBotonCrearProyecto() == evt.getSource()) {
            menuGestor.setVisible(true);
            this.modelo = new Modelo(ventanaInicio.getEntradaNombreProyecto().getText());
            ventanaInicio.setVisible(false);
        }
        if (ventanaInicio.getBotonAbrirProyecto() == evt.getSource()) {
            if (modelo.getProyecto() != null) {
                try {
                    modelo.cargarProyecto();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error, no has creado ningún proyecto todavía");
            }
        }
        if (menuGestor.getBotonGuardarYSalir() == evt.getSource()) {
            try {
                modelo.guardarProyecto();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0); //errpr no guarda el puto proyecto
        }
        if (menuGestor.getBotonCrearTarea() == evt.getSource()) {
            altaTarea.setVisible(true);
            limpiarTareasGestor();
            menuGestor.setVisible(false);
        }
        if (altaTarea.getBotonCrear() == evt.getSource()) {
            crearTarea();
        }
        if (tareaBiblioteca.getBotonTerminar() == evt.getSource()) {
            terminarBiblioteca();
        }
        if (tareaPrograma.getBotonCrear() == evt.getSource()) {
            terminarPrograma();
        }
        if (tareaDocumentacion.getBotonCrear() == evt.getSource()) {
            terminarDocumentacion();
        }
        if (tareaPaginaWeb.getBotonCrear() == evt.getSource()) {
            terminarPaginaWeb();
        }

        if (darAltaPersona.getBotonAnyadir() == evt.getSource()) {
            crearPersona();
        }


        /**   ////////////////////////////////////////EDITAR PERSONA CODIGO ////////////////////////////////////////////////////// */


        if (menuGestor.getBotonEditarPersona() == evt.getSource() && !menuGestor.getListaPersonas().isSelectionEmpty()) {
            //posible fallo por eliminar persona
            punteroListaPersonas = menuGestor.getListaPersonas().getSelectedIndex();
            limpiarPersonasGestor();
            menuGestor.setVisible(false);
            editarPersona.setVisible(true);
            actualizarEditarPersona();
        }
        if (editarPersona.getBotonBorrarPersona() == evt.getSource()) {
            editarPersona.setVisible(false);
            limpiarTareasEditarPersona();
            borrarPersonaLista(punteroListaPersonas);
            actualizarPersonasGestor();
            menuGestor.setVisible(true);
        }
        if (editarPersona.getBotonCerrar() == evt.getSource()) {
            menuGestor.setVisible(true);
            editarPersona.setVisible(false);
            actualizarTareasGestor();
            limpiarTareasEditarPersona();
        }

        /**   ////////////////////////////////////////EDITAR TAREA CODIGO ////////////////////////////////////////////////////// */

        if (menuGestor.getBotonEditarTarea() == evt.getSource() && !menuGestor.getListaTareas().isSelectionEmpty()) {
            punteroListaTareas = menuGestor.getListaTareas().getSelectedIndex();
            limpiarTareasGestor();
            limpiarPersonasGestor();
            menuGestor.setVisible(false);
            editarTarea.setVisible(true);
            actualizarPersonasEspecificasEditarTarea();
            actualizarPersonasEditarTarea();
            listModelPersonasDeUnaTareaEspecifica.removeAllElements();
            listModelPersonasDeUnaTareaEspecifica.addAll(modelo.getProyecto().getListaTareas().get(punteroListaTareas).getPersonasAsignadas());
        }
        if (editarTarea.getBotonDarBajaTarea() == evt.getSource()) {
            editarTarea.setVisible(false);
            modelo.setTareaFinalizada(punteroListaTareas);
            actualizarTareasGestor();
            actualizarPersonasGestor();
            limpiarPersonasEditarTarea();
            limpiarPersonasEspecificasdeUnaTarea();
            menuGestor.setVisible(true);
        }
        if (editarTarea.getBotonCerrar() == evt.getSource()) {
            menuGestor.setVisible(true);
            editarTarea.setVisible(false);
            actualizarTareasGestor();
            actualizarPersonasGestor();
            limpiarPersonasEditarTarea();
            limpiarPersonasEspecificasdeUnaTarea();
        }





        /**   ////////////////////////////////////////EDITAR TAREA BASE DE DATOS CODIGO ////////////////////////////////////////////////////// */


        //Añadir persona a tarea
        if(editarTarea.getBotonAnyadirPersona()==evt.getSource()){
            if(!editarTarea.getListaPersonas().isSelectionEmpty()) {
                punteroListaPersonasEditarTarea = editarTarea.getListaPersonas().getSelectedIndex();
                Tarea tarea = modelo.getProyecto().getListaTareas().get(punteroListaTareas);
                tarea.anyadirPersonasAsignadas(modelo.getProyecto().getListaPersonas().get(punteroListaPersonasEditarTarea));
                anyadirEditarTarea(tarea);
                System.out.println(punteroListaPersonasEditarTarea);
            }
        }
        //Borrar persona de tarea
        if(editarTarea.getBotonQuitarPersona()==evt.getSource()){
            if(!editarTarea.getListaPersonasAsignadas().isSelectionEmpty()) {
                punteroListaPersonasDeUnaTarea = editarTarea.getListaPersonasAsignadas().getSelectedIndex(); //puntero tiene la persona seleccionada
                Tarea tarea = modelo.getProyecto().getListaTareas().get(punteroListaTareas);
                tarea.eliminarPersonaAsignada(punteroListaPersonasDeUnaTarea); //eliminar persona que se encuentra seleccionada
                borrarListaPersonasAsignadasAUnaTarea(tarea);
                System.out.println(punteroListaPersonasDeUnaTarea);

            }
        }
//punteroListaPersonasEditarTarea = puntero2
        //punteroListaPersonasDeUnaTarea = puntero2

        if(editarPersona.getBotonAnyadirTarea()==evt.getSource()){
            if(!editarPersona.getjList1().isSelectionEmpty()) {
                puntero2= editarPersona.getjList1().getSelectedIndex();
                Persona persona = modelo.getProyecto().getListaPersonas().get(punteroListaPersonas);
                persona.anyadirTareasAsignadas(modelo.getProyecto().getListaTareas().get(puntero2));
                anyadirEditarPersona(persona);
                System.out.println(punteroListaPersonasEditarTarea);
            }
        }
//Borrar persona de tarea
        if(editarPersona.getBotonQuitarTarea()==evt.getSource()){
            if(!editarPersona.getListaTareasAsignadas().isSelectionEmpty()) {
                puntero1 = editarPersona.getListaTareasAsignadas().getSelectedIndex(); //puntero tiene la persona seleccionada
                Persona persona = modelo.getProyecto().getListaPersonas().get(punteroListaPersonas);
                persona.eliminarTareaAsignada(puntero1); //eliminar persona que se encuentra seleccionada
                borrarListaTareaAsignadasAUnaPersona(persona);
                System.out.println(puntero1);

            }
        }




/*
        //Añadir tarea a persona
        if (editarPersona.getBotonAnyadirTarea()==evt.getSource()){
            Persona persona= modelo.getProyecto().getListaPersonas().get(menuGestor.getListaPersonas().getSelectedIndex());
            persona.añadirTareaAPersona(modelo.getProyecto().getListaTareas().get(editarPersona.getjList1().getSelectedIndex()));

        }
        //Eliminar tarea de persona
        if(editarPersona.getBotonBorrarPersona()==evt.getSource()){
            Persona persona= modelo.getProyecto().getListaPersonas().get(menuGestor.getListaPersonas().getSelectedIndex());
            persona.eliminarTareaDePersona(modelo.getProyecto().getListaTareas().get(editarPersona.getjList1().getSelectedIndex()));
        }

 */
    }}
