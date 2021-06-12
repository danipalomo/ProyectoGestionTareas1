package Excepciones;

public class ErrorPrecioNoAsignadoException extends Exception{
    public ErrorPrecioNoAsignadoException(){
        System.out.println("Error: El campo \"Precio\" es obligatorio");
    }
}
