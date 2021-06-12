package Excepciones;

public class ErrorDniObligatorioException extends Exception{
    public ErrorDniObligatorioException(){
        System.out.println("Error: El campo \"DNI\" es obligatorio");
    }
}
