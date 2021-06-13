package Controlador;

import Clases.Persona;
import Clases.Proyecto;
import Clases.Tarea;
import Excepciones.ListaVaciaException;
import Excepciones.PersonaRepetidaException;
import Excepciones.TareaRepetidaException;
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
import java.util.ArrayList;
import java.util.HashMap;

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
    private MostrarDatosTarea mostrarDatosTarea;

    public ArrayList<Proyecto> getListaProyectosGuardados() {
        return listaProyectosGuardados;
    }

    private ArrayList<Proyecto> listaProyectosGuardados=new ArrayList<>();

    private int punteroListaPersonas; //puntero de la persona seleccionada en el menu gestor
    private int punteroListaTareas; //puntero de la tarea seleccionada en el menu gestor
    private int punteroListaPersonasEditarTarea;
    private int punteroListaPersonasDeUnaTarea;

    private int punteroListaTareasEditarPersona;
    private int punteroListaTareasDeUnaPersona;




    public Controlador(DarAltaTarea altaTarea, CargarProyecto cargarProyecto, DarAltaPersona darAltaPersona, TareaPaginaWeb tareaPaginaWeb, TareaBiblioteca tareaBiblioteca, TareaPrograma tareaPrograma, MenuGestor menuGestor, TareaDocumentacion tareaDocumentacion, VentanaInicio ventanaInicio, Modelo modelo, EditarPersona editarPersona, EditarTarea editarTarea, MostrarDatosTarea mostrarDatosTarea) {
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
        this.mostrarDatosTarea=mostrarDatosTarea;

    }
    public boolean dniEncontradoEnListaDePersonas(ArrayList<Persona> listaPersonas, String dni){
        for(Persona p:listaPersonas){
            if(p.getDni().equals(dni)) return true;
        }
        return false;
    }

    public void crearProyecto(){
        menuGestor.setVisible(true);
        this.modelo = new Modelo(ventanaInicio.getEntradaNombreProyecto().getText());
        ventanaInicio.setVisible(false);
    } //bien

    public void abrirProyecto(){
        cargarProyecto.setVisible(true);
        ventanaInicio.setVisible(false);
    }
    public void crearTarea()  {
        double costAltaTarea = Double.parseDouble(altaTarea.getEntradaCoste().getText());
        int prioridad = (Integer) altaTarea.getSpinnerPrioridad().getValue();
        double var = Double.parseDouble(altaTarea.getEntradaCoste().getText());
        int numhoras = (Integer) altaTarea.getSpinnerPrioridad().getValue();
        if (altaTarea.getEntradaCoste().getText() != null && altaTarea.getEntradaIdTarea().getText() != null) {
            try {
                modelo.darDeAltaTarea(altaTarea.getEntradaTitulo(), altaTarea.getEntradaDescripcion().getText(), altaTarea.getEntradaResponsable().getText(), prioridad, costAltaTarea, altaTarea.getDesplegableTipoFacturacion().getSelectedIndex(), var, altaTarea.getDesplegableInternoExterno().getSelectedIndex(), altaTarea.getEntradaIdTarea().getText(), numhoras, altaTarea.getDesplegableTipoTarea().getSelectedIndex());
            }
            catch (TareaRepetidaException tareaRepetidaException){
                tareaRepetidaException.printStackTrace();
            }
        }
        menuGestor.actualizarTareas(modelo.getListTareas());
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
    } //bien
    public void abrirProyecto(Proyecto p){
        modelo.setProyecto(p);

    }
    public void guardarProyectoEnListaProyectos(Proyecto p){
        listaProyectosGuardados.add(p);
    }
    public void terminarBiblioteca(){
        ;//devuelve la ultima tarea creada que se encuentra en la posicion size-1 y ademas es la ultima creada en la ventana anterior :)
        int lineas = (Integer) tareaBiblioteca.getSpinnerNumLineas().getValue();
        int modulos = (Integer) tareaBiblioteca.getSpinnerNumModulos().getValue();
        if (!tareaBiblioteca.getEntradaLenguaje().equals("")) {
            Biblioteca biblio = new Biblioteca(tareaBiblioteca.getEntradaLenguaje().getText(), lineas, modulos);
            modelo.setResultado(biblio, modelo.getUltimaTarea());
            tareaBiblioteca.setVisible(false);
            menuGestor.setVisible(true);

        } else {
            System.out.println("Error, no has introducido ningún lenguaje");
        }
    } //bien

    public void terminarDocumentacion(){
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
            modelo.setResultado(doc, modelo.getUltimaTarea());
            menuGestor.setVisible(true);
            tareaDocumentacion.setVisible(false);

        }
    }

    public void terminarPrograma(){
        int lineas = (Integer) tareaPrograma.getSpinnerNumLineas().getValue();
        int modulos = (Integer) tareaPrograma.getSpinnerNumModulos().getValue();
        if (!tareaPrograma.getEntradaLenguaje().getText().equals("")) {
            Programa prog = new Programa(tareaPrograma.getEntradaLenguaje().getText(), lineas, modulos);
            modelo.setResultado(prog, modelo.getUltimaTarea());
            tareaPrograma.setVisible(false);
            menuGestor.setVisible(true);

        } else {
            System.out.println("Error, no has introducido ningún lenguaje");
        }
    }

    public void terminarPaginaWeb(){
        int tipo = tareaPaginaWeb.getDesplegableEstaticaDinamica().getSelectedIndex();
        String estaticaDinamica = "Dinámica";
        if (tipo == 0) {
            estaticaDinamica = "Estática";
        }
        String lenguaje = tareaPaginaWeb.getEntradaLenguaje().getText();
        String backend = tareaPaginaWeb.getEntradaBackend().getText();
        PaginaWeb paginaWeb = new PaginaWeb(estaticaDinamica, lenguaje, backend);
        modelo.setResultado(paginaWeb, modelo.getUltimaTarea());
        tareaPaginaWeb.setVisible(false);
        menuGestor.setVisible(true);

    } //bien hasta aqui

    public void crearPersona(){
        String dni = darAltaPersona.getEntradaDni().getText();
        String nombre = darAltaPersona.getEntradaNombre().getText();
        String correo = darAltaPersona.getEntradaCorreo().getText();
        if(correo.equals("")) correo="(FALTA CORREO)";

        try {
            modelo.darDeAltaPersona(dni, nombre, correo);
        } catch (ListaVaciaException | PersonaRepetidaException e) {
            e.printStackTrace();
        }
        darAltaPersona.setVisible(false);
        menuGestor.setVisible(true);
        menuGestor.actualizarPersonas(modelo.getListaPersonas());
    }

    public void editarTarea(){
        if(!menuGestor.getListaTareas().isSelectionEmpty()) {
            punteroListaTareas=menuGestor.getListaTareas().getSelectedIndex();
            menuGestor.setVisible(false);
            editarTarea.setVisible(true);
            editarTarea.actualizarPersonas(modelo.getListaPersonas());
            editarTarea.actualizarPersonasEspecificas(modelo.getListTareas().get(punteroListaTareas).getPersonasAsignadas());
        }
        else{
            //Implementar una excepcion de seleccion vacia
        }
    }
    public void anyadirPersonaATarea(){
        Tarea t=modelo.getTarea(punteroListaTareas); //extraigo la tarea seleccionada a partir del punteroListaTareas del menuGestor
        if(!editarTarea.getListaPersonas().isSelectionEmpty()) {
            punteroListaPersonasEditarTarea=editarTarea.getListaPersonas().getSelectedIndex(); //extraigo la persona selccionada de la lista de personas de editarTarea a partir del puntero suyo
            Persona p=modelo.getPersona(punteroListaPersonasEditarTarea);
            modelo.anyadirPersonaATarea(t,p);
            editarTarea.actualizarPersonasEspecificas(modelo.getPersonasDeUnaTarea(t));
        }
        else{
            //implementar excepcion de error por no haber seleccionado ninguna persona a añadir
        }
    }

    public void quitarPersona(){
        Tarea t=modelo.getTarea(punteroListaTareas); //extraigo la tarea seleccionada a partir del punteroListaTareas del menuGestor
        if(!editarTarea.getListaPersonasAsignadas().isSelectionEmpty()) {
            punteroListaPersonasDeUnaTarea=editarTarea.getListaPersonasAsignadas().getSelectedIndex(); //extraigo la persona selccionada de la lista de personas de editarTarea a partir del puntero suyo
            Persona p=modelo.getPersona(punteroListaPersonasDeUnaTarea);
            modelo.eliminarPersonaDeTarea(t,punteroListaPersonasDeUnaTarea);
            editarTarea.actualizarPersonasEspecificas(modelo.getPersonasDeUnaTarea(t));

            System.out.println(punteroListaPersonasDeUnaTarea);
            System.out.println(t.getPersonasAsignadas().toString());
        }
        else{
            //excepcion no haber selccionado ninguna persona a añadir
        }

    }
    public void cerrarEditarTarea(){
        editarTarea.setVisible(false);
        menuGestor.setVisible(true);
    }

    public void setTareaFinalizada(){
        modelo.setTareaFinalizada(punteroListaTareas);
        editarTarea.setVisible(false);
        menuGestor.setVisible(true);
    }


    public void editarPersona(){
        if(!menuGestor.getListaPersonas().isSelectionEmpty()) {
            punteroListaPersonas=menuGestor.getListaPersonas().getSelectedIndex();
            menuGestor.setVisible(false);
            editarPersona.setVisible(true);
            editarPersona.actualizarTareas(modelo.getListTareas());
            editarPersona.actualizarTareasEspecificas(modelo.getTareasDeUnaPersona(punteroListaPersonas));
        }
        else{
            //Implementar una excepcion de seleccion vacia
        }
    }

    public void anyadirTareaAPersona(){
        Persona p=modelo.getPersona(punteroListaPersonas); //extraigo la persona seleccionada a partir del punteroListaPersonas del menuGestor
        if(!editarPersona.getListaTareas().isSelectionEmpty()) {
            punteroListaTareasEditarPersona=editarPersona.getListaTareas().getSelectedIndex(); //extraigo la tarea selccionada de la lista de tareas de editarPersona a partir del puntero suyo
            Tarea t=modelo.getTarea(punteroListaTareasEditarPersona);
            modelo.anyadirTareaAPersona(p,t);
            editarPersona.actualizarTareasEspecificas(modelo.getTareasDeUnaPersona(p));
        }
        else{
            //implementar excepcion de error por no haber seleccionado ninguna persona a añadir
        }
    }

    public void quitarTarea(){
        Persona p=modelo.getPersona(punteroListaPersonas); //extraigo la persona seleccionada a partir del punteroListaPersonas del menuGestor
        if(!editarPersona.getListaTareasAsignadas().isSelectionEmpty()) {
            punteroListaTareasDeUnaPersona=editarPersona.getListaTareasAsignadas().getSelectedIndex(); //extraigo la persona selccionada de la lista de personas de editarTarea a partir del puntero suyo
            Tarea t=modelo.getTarea(punteroListaTareasDeUnaPersona);
            modelo.eliminarTareaDePersona(p,punteroListaTareasDeUnaPersona);
            editarPersona.actualizarTareasEspecificas(modelo.getTareasDeUnaPersona(p));

        }
        else{
            //excepcion no haber selccionado ninguna persona a añadir
        }
    }

    public void borrarPersona(){
        modelo.borrarPersona(punteroListaPersonas);
        editarPersona.setVisible(false);
        menuGestor.setVisible(true);
        System.out.println(punteroListaPersonas);
        menuGestor.actualizarPersonas(modelo.getListaPersonas());
    }

    public void cerrarEditarPersona(){
        editarPersona.setVisible(false);
        menuGestor.setVisible(true);
    }

    public void verTarea(){
        if(!menuGestor.getListaTareas().isSelectionEmpty()) {
            punteroListaTareas=menuGestor.getListaTareas().getSelectedIndex(); //cojo la referencia a la tarea seleccionada en el menu en forma de puntero
            menuGestor.setVisible(false);
            mostrarDatosTarea.setVisible(true);
            mostrarDatosTarea();
        }
        else{
            //excepcion, no se ha seleccionado nada
        }
    }

    public void mostrarDatosTarea(){
        Tarea t=modelo.getTarea(punteroListaTareas);
        mostrarDatosTarea.getLabelDescripcion().setText(t.getDescripcion());
        mostrarDatosTarea.getLabelCoste().setText(String.valueOf(t.getCoste())+"€");
        mostrarDatosTarea.getLabelNumHoras().setText(Integer.toString(t.getResultado().getNumHoras()));
        mostrarDatosTarea.getLabelResponsable().setText(t.getResponsable());
        mostrarDatosTarea.getLabelPrioridad().setText(String.valueOf(t.getPrioridad()));
        mostrarDatosTarea.getLabelTitulo().setText(t.getTitulo());
        mostrarDatosTarea.getLabelTipoConsumo().setText(t.getResultado().getTipoConsumo());
        mostrarDatosTarea.getLabelResultado().setText(t.getResultadoToString());
    }

    public void cerrarVerTarea(){
        mostrarDatosTarea.setVisible(false);
        mostrarDatosTarea.getLabelDescripcion().setText("");
        mostrarDatosTarea.getLabelCoste().setText("");
        mostrarDatosTarea.getLabelNumHoras().setText("");
        mostrarDatosTarea.getLabelResponsable().setText("");
        mostrarDatosTarea.getLabelPrioridad().setText("");
        mostrarDatosTarea.getLabelTitulo().setText("");
        mostrarDatosTarea.getLabelTipoConsumo().setText("");
        mostrarDatosTarea.getLabelResultado().setText("");
        menuGestor.setVisible(true);
    }





    @Override
    public void actionPerformed(ActionEvent evt) {
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
            System.exit(0); //error no guarda el proyecto de mierda joder voy al tanatorio a desahogarme jeje hola  ?
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

    }}
