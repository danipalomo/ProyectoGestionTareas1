package Clases;

import Listas.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona implements tieneLista, tieneClave, Serializable {
    private String nombre;
    private String correo;
    private ArrayList<Tarea> listaTareas;
    private String dni;

    public Persona(){ super();}
    public Persona(String dni, String nombre, String correo){
        this.nombre=nombre;
        this.correo=correo;
        this.dni=dni;
        listaTareas=new ArrayList<Tarea>();
    }
    //Añadir tareas
    public void añadirTareaAPersona(Tarea tarea){
        if(!tieneTarea(tarea)) {
            listaTareas.add(tarea);
        }
    }

    public void eliminarTareaDePersona(Tarea tarea){
        if(tieneTarea(tarea))listaTareas.remove(tarea);
    }
    public boolean tieneTarea(Tarea tarea){
        return (listaTareas.contains(tarea));
    }
    public String getNombre() {
        return nombre;
    }
    public String toString(){
        return nombre+" - "+dni+" - "+correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }
    public void anyadirTareasAsignadas(Tarea tarea){
        listaTareas.add(tarea);
    }
    public void eliminarTareaAsignada(int index){
        listaTareas.remove(index);
    }

    @Override
    public List getLista() {
        return listaTareas;
    }

    @Override

    public String getClave() { return dni; }
}
