package Modelo;

import Clases.Persona;
import Clases.Proyecto;
import Clases.Tarea;
import Excepciones.ListaVaciaException;
import Excepciones.PersonaRepetidaException;
import Excepciones.TareaRepetidaException;
import Resultados.Resultado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public interface ModeloInterfaz {
    public ArrayList<Tarea> getListTareas();
    public ArrayList<Persona> getListaPersonas();
    public void darDeAltaPersona(String dni, String nombre, String correo) throws ListaVaciaException, PersonaRepetidaException;
    public void borrarPersona(int index);
    public void darDeAltaTarea(String titulo, String descripcion, String responsable, int prioridad, double coste, int facturacion,double var, int resultado, String id, int horas, int tipo  ) throws TareaRepetidaException;

    public void setProyecto(Proyecto proyecto);
    public String getNombreProyecto();
    public Proyecto getProyecto();
    public  Proyecto cargarProyecto() throws IOException, ClassNotFoundException;
    public void guardarProyecto() throws IOException;
    public void anyadirPersonaATarea(Tarea t, Persona p);
    public void anyadirTareaAPersona(Persona p, Tarea t);
    public void setTareaFinalizada(int index);
    public Tarea getUltimaTarea();
    public boolean sePuedeAnyadir(Persona p);
    public boolean sePuedeAnyadir(Tarea t);
    public void eliminarPersonaDeTarea(Tarea t, int index);
    public String getResultado(int index);
    public void addResultados(String s);
    public void quitarResultado(int index);
    public ArrayList<Persona> getPersonasDeUnaTarea(Tarea t);
    public ArrayList<Tarea> getTareasDeUnaPersona(Persona p);
    public ArrayList<Persona> getPersonasDeUnaTarea(int index);
    public ArrayList<Tarea> getTareasDeUnaPersona(int index);
    public void eliminarTareaDePersona(Persona p, int index);
    public void setResultado(Resultado r, Tarea t);
    public Tarea getTarea(int index);
    public Persona getPersona(int index);
    public String getID(int index);
    public String getTipoTarea(int index);
    public String getDescripcion(int index);
    public Date getFechaCreacion(int index);
    public String getResponsable(int index);
    public void addEtiqueta(String s, Tarea t);
    public String getEtiquetas(int index);
}
