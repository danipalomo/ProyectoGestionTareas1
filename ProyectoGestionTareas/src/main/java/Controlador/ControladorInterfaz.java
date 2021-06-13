package Controlador;

import Clases.Persona;

import java.io.IOException;
import java.util.ArrayList;

public interface ControladorInterfaz {
    public void cargarProyecto() throws IOException, ClassNotFoundException;
    public void guardarProyecto() throws IOException;
    public void cerrarVerTarea();
    public void mostrarDatosTarea();
    public void verTarea();
    public void cerrarEditarPersona();
    public void borrarPersona();
    public void quitarTarea();
    public void anyadirTareaAPersona();
    public void editarPersona();
    public void setTareaFinalizada();
    public void cerrarEditarTarea();
    public void quitarPersona();
    public void anyadirPersonaATarea();
    public void editarTarea();
    public void crearPersona();
    public void terminarPaginaWeb();
    public void terminarPrograma();
    public void terminarDocumentacion();
    public void terminarBiblioteca();
    public void limpiarAltaTarea();
    public void crearTarea(ArrayList<String> etiquetas);
    public void crearProyecto();
}
