/*import Clases.Persona;
import Clases.Proyecto;
import Clases.Tarea;
import Excepciones.ListaVaciaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {
    private Proyecto proyecto=new Proyecto();

    Tarea tarea1=new Tarea("Estudiar", "Sentarse y no moverse en 2 horas", "20959534W", 3);
    Tarea tarea2=new Tarea("Comer", "Comer comida comestible", "15673422Z", 1);
    Tarea tarea3=new Tarea("Dormir", "Tumbarse en el suelo y cerrar los ojos", "20959534W", 4);
    Persona persona1=new Persona();
    Persona persona2=new Persona("Carlos", "carlos@gmail.com", "15673422Z");
    @Test
    void anyadirTarea() {
        try {
            proyecto.anyadirTarea(tarea1);
        } catch (ListaVaciaException listaVaciaException) {
            listaVaciaException.printStackTrace();
        }
        assertTrue(proyecto.getListaTareas().contains(tarea1));
    }

    @Test
    void anyadirPersona() {
        persona1.setNombre("Carlos");
        persona1.setCorreo("carlos@gmail.com");
        persona1.setDni("15673422Z");
        assertEquals("Carlos",persona1.getNombre());
        assertEquals("carlos@gmail.com",persona1.getCorreo());
        assertEquals("15673422Z",persona1.getDni());

    }

    @Test
    void getNombreProyecto() {
        proyecto.setNombreProyecto("Clases.Proyecto");
        assertEquals("Clases.Proyecto",proyecto.getNombreProyecto());
    }




}*/