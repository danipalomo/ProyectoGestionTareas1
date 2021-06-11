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

    private int punteroListaPersonas; //puntero de la persona seleccionada en el menu gestor
    private int punteroListaTareas; //puntero de la tarea seleccionada en el menu gestor
    private int punteroListaPersonasEditarTarea;
    private int punteroListaPersonasDeUnaTarea;

    private int punteroListaTareasEditarPersona;
    private int punteroListaTareasDeUnaPersona;




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
    public void crearProyecto(){
        if(!(ventanaInicio.getEntradaNombreProyecto().getText().equals(""))) {
            menuGestor.setVisible(true);
            this.modelo = new Modelo(ventanaInicio.getEntradaNombreProyecto().getText());
            ventanaInicio.setVisible(false);
        }
        else{
            //excepcion nombre vacio implementar
        }
    }

    public void crearTarea(){
        double costAltaTarea = Double.parseDouble(altaTarea.getEntradaCoste().getText());
        int prioridad = (Integer) altaTarea.getSpinnerPrioridad().getValue();
        double var = Double.parseDouble(altaTarea.getEntradaCoste().getText());
        int numhoras = (Integer) altaTarea.getSpinnerPrioridad().getValue();
        if (altaTarea.getEntradaCoste().getText() != null && altaTarea.getEntradaIdTarea().getText() != null) {
            modelo.darDeAltaTarea(altaTarea.getEntradaTitulo(), altaTarea.getEntradaDescripcion().getText(), altaTarea.getEntradaResponsable().getText(), prioridad, costAltaTarea, altaTarea.getDesplegableTipoFacturacion().getSelectedIndex(), var, altaTarea.getDesplegableInternoExterno().getSelectedIndex(), altaTarea.getEntradaIdTarea().getText(), numhoras, altaTarea.getDesplegableTipoTarea().getSelectedIndex());
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

            menuGestor.setVisible(true);
            tareaDocumentacion.setVisible(false);

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
            menuGestor.actualizarPersonas(modelo.getListaPersonas());
        }
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
        Tarea t=modelo.getListTareas().get(punteroListaTareas); //extraigo la tarea seleccionada a partir del punteroListaTareas del menuGestor
        if(!editarTarea.getListaPersonas().isSelectionEmpty()) {
            punteroListaPersonasEditarTarea=editarTarea.getListaPersonas().getSelectedIndex(); //extraigo la persona selccionada de la lista de personas de editarTarea a partir del puntero suyo
            Persona p=modelo.getListaPersonas().get(punteroListaPersonasEditarTarea);
            modelo.anyadirPersonaATarea(t,p);
            editarTarea.actualizarPersonasEspecificas(modelo.getPersonasDeUnaTarea(t));
        }
        else{
            //implementar excepcion de error por no haber seleccionado ninguna persona a añadir
        }
    }

    public void quitarPersona(){
        Tarea t=modelo.getListTareas().get(punteroListaTareas); //extraigo la tarea seleccionada a partir del punteroListaTareas del menuGestor
        if(!editarTarea.getListaPersonasAsignadas().isSelectionEmpty()) {
            punteroListaPersonasDeUnaTarea=editarTarea.getListaPersonasAsignadas().getSelectedIndex(); //extraigo la persona selccionada de la lista de personas de editarTarea a partir del puntero suyo
            Persona p=modelo.getListaPersonas().get(punteroListaPersonasDeUnaTarea);
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
            editarPersona.actualizarTareasEspecificas(modelo.getListaPersonas().get(punteroListaPersonas).getListaTareas());
        }
        else{
            //Implementar una excepcion de seleccion vacia
        }
    }

    public void anyadirTareaAPersona(){
        Persona p=modelo.getListaPersonas().get(punteroListaPersonas); //extraigo la persona seleccionada a partir del punteroListaPersonas del menuGestor
        if(!editarPersona.getListaTareas().isSelectionEmpty()) {
            punteroListaTareasEditarPersona=editarPersona.getListaTareas().getSelectedIndex(); //extraigo la tarea selccionada de la lista de tareas de editarPersona a partir del puntero suyo
            Tarea t=modelo.getListTareas().get(punteroListaTareasEditarPersona);
            modelo.anyadirTareaAPersona(p,t);
            editarPersona.actualizarTareasEspecificas(modelo.getTareasDeUnaPersona(p));
            System.out.println(punteroListaTareasEditarPersona);
            System.out.println(punteroListaPersonas);
        }
        else{
            //implementar excepcion de error por no haber seleccionado ninguna persona a añadir
        }
    }

    public void quitarTarea(){
        Persona p=modelo.getListaPersonas().get(punteroListaPersonas); //extraigo la persona seleccionada a partir del punteroListaPersonas del menuGestor
        if(!editarPersona.getListaTareasAsignadas().isSelectionEmpty()) {
            punteroListaTareasDeUnaPersona=editarPersona.getListaTareasAsignadas().getSelectedIndex(); //extraigo la persona selccionada de la lista de personas de editarTarea a partir del puntero suyo
            Tarea t=modelo.getListTareas().get(punteroListaTareasDeUnaPersona);
            modelo.eliminarTareaDePersona(p,punteroListaTareasDeUnaPersona);
            editarPersona.actualizarTareasEspecificas(modelo.getTareasDeUnaPersona(p));

            System.out.println(punteroListaTareasDeUnaPersona);
            System.out.println(p.getListaTareas().toString());
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
            System.exit(0); //errpr no guarda el puto proyecto
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
