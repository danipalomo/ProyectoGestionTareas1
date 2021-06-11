import Controlador.Controlador;
import Modelo.Modelo;
import Vista.*;

import java.io.Serializable;


public class MainGrafico implements Serializable {
    public static void main(String[] args) {
        VentanaInicio ventanaInicio=new VentanaInicio();
        Modelo m=new Modelo();
        MenuGestor menu=new MenuGestor();
        CargarProyecto cargarProyecto=new CargarProyecto();
        DarAltaTarea darAltaTarea=new DarAltaTarea();
        DarAltaPersona darAltaPersona=new DarAltaPersona();
        TareaDocumentacion tareaDocumentacion=new TareaDocumentacion();
        TareaBiblioteca tareaBiblioteca=new TareaBiblioteca();
        TareaPrograma tareaPrograma=new TareaPrograma();
        TareaPaginaWeb tareaPaginaWeb=new TareaPaginaWeb();
        EditarPersona editarPersona=new EditarPersona();
        EditarTarea editarTarea=new EditarTarea();
        Controlador c=new Controlador(darAltaTarea, cargarProyecto, darAltaPersona, tareaPaginaWeb, tareaBiblioteca, tareaPrograma, menu, tareaDocumentacion,ventanaInicio, m, editarPersona, editarTarea);
        ventanaInicio.setControlador(c);
        menu.setControlador(c);
        darAltaTarea.setControlador(c);
     //  cargarProyecto.setControlador(c);
        darAltaTarea.setControlador(c);
        darAltaPersona.setControlador(c);
        tareaDocumentacion.setControlador(c);
        tareaBiblioteca.setControlador(c);
        tareaPrograma.setControlador(c);
        tareaPaginaWeb.setControlador(c);
        editarPersona.setControlador(c);
        editarTarea.setControlador(c);

    }
}
