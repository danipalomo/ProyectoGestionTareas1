/*import Clases.Tarea;
import Facturacion.consumoInterno;
import Facturacion.descuentoParaClientes;
import Facturacion.sobrecosteTareaUrgente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TareaTest {
    Tarea tarea1=new Tarea("Estudiar", "Sentarse y no moverse en 2 horas", "20959534W", 3);
    Tarea tarea2=new Tarea("Comer", "Comer comida comestible", "15673422Z", 1);

    @Test
    void isEsFinalizada() {
        assertFalse(tarea1.isEsFinalizada());
    }

    @Test
    void getResponsable() {
        assertTrue(tarea1.getResponsable().compareTo("20959534W")==0);
    }

    @Test
    void finalizarTarea() {
        tarea2.finalizarTarea();
        assertTrue(tarea2.isEsFinalizada());
    }
    @Test
    void añadirEtiqueta(){
        tarea1.añadirEtiqueta("Ordenador");
        assertTrue(tarea1.getEtiquetas().contains("Ordenador"));
    }
    @Test
    void comprobarFacturacion(){
        tarea1.setFacturacion(new consumoInterno(30));
        assertEquals(tarea1.getFacturacion().calcular(),30);
        tarea1.setFacturacion(new descuentoParaClientes(10, 100 ));
        assertEquals(tarea1.getFacturacion().calcular(),90);
        tarea1.setFacturacion(new sobrecosteTareaUrgente(10, 100 ));
        assertEquals(tarea1.getFacturacion().calcular(),110);
    }
}*/