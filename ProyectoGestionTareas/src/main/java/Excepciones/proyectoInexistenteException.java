package Excepciones;

public class proyectoInexistenteException extends Exception{
    public proyectoInexistenteException(){
        System.out.println( "No se encuentra un proyecto guardado.");
    }
}
