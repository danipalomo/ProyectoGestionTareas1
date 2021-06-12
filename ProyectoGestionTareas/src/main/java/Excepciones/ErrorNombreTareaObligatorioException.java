package Excepciones;

public class ErrorNombreTareaObligatorioException extends Exception{
    public ErrorNombreTareaObligatorioException(){
        System.out.println("Error: El nombre de la tarea es obligatorio.");
    }
}
