package Listas;
import Excepciones.ListaVaciaException;

import java.io.Serializable;
import java.util.ArrayList;

public class UtilidadesParaListas<E> implements Serializable {
    public static <E extends tieneLista> ArrayList<E> elementosConListaVacia(ArrayList<E> lista){
        ArrayList<E> listaElementosVacios=new ArrayList<>();
        for(E elemento:lista){
            if(elemento.getLista().isEmpty()){
                listaElementosVacios.add(elemento);
            }
        }
        return listaElementosVacios;
    }
    public static <E extends tieneClave> boolean sePuedeInsertarEnListaAsociada(E objeto, ArrayList<E> lista) throws ListaVaciaException {
        //// lanzar excepcion lista inicial vacia

        for (E e : lista) {
            if (e.getClave() == objeto) {
                return false;
            }
        }
        return true;
        //falta añadir un test para esto
    }
}
