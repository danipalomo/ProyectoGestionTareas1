package Excepciones;

public class ListaVaciaException extends Exception{
    public ListaVaciaException(){
        System.out.println("Error, la lista está vacía");
    }
    public ListaVaciaException(String mensaje){
        System.out.println(mensaje);
    }
}
