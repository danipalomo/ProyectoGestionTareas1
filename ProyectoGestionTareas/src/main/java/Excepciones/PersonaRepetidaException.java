package Excepciones;

public class PersonaRepetidaException extends Exception{
    public PersonaRepetidaException(String mensaje){
        System.out.println(mensaje);
    }

}
