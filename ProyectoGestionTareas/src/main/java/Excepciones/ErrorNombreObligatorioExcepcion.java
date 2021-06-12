package Excepciones;

public class ErrorNombreObligatorioExcepcion extends Exception {
    public ErrorNombreObligatorioExcepcion(){
        System.out.println("Error: El campo \"Nombre\" es obligatorio");
    }
}
