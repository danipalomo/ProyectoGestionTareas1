package Modelo;

import Clases.*;
import Excepciones.*;
import Facturacion.*;
import Resultados.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Modelo implements Serializable{
    private  String nombreProyecto;
    private  Proyecto proyecto;
    static Scanner sc =new Scanner(System.in);
    public boolean cerrarPrograma=false;

    public Modelo(){

    }
    public Modelo(String nombre){
        proyecto=new Proyecto(nombre);
        this.nombreProyecto=nombre;
    }
        /*switch (opcion){
            case 0: cargarProyecto(); break;
            case 1: darDeAltaPersona(); break;
            case 2: darDeAltaTarea(); break;
            case 3: finalizarTarea(); break;
            case 4: introducirEliminarPersonaDeTarea(); break;
            case 5: listarPersonas(); break;
            case 6: listarTareas(); break;
            case 7: guardarProyecto(); break;
        }
        promptEnterKey();
    }*/
    //
    public void darDeAltaPersona(String dni, String nombre, String correo) throws ListaVaciaException {
        Persona nuevaPersona= new Persona(dni, nombre, correo);
        proyecto.anyadirPersona(nuevaPersona);
    }
    public String nombreTarea(int index){
        return proyecto.getListaTareas().get(index).toString();
    }
    public void borrarPersona(int index){
        proyecto.getListaPersonas().remove(index);

    }
    public void borrarTarea(int index){
        proyecto.getListaTareas().remove(index);

    }
    public Persona getUltimaPersona(){
        if(proyecto.getListaPersonas()!=null) {
            return proyecto.getListaPersonas().get(proyecto.getListaPersonas().size() - 1);
        }
        return null;
    }
    public void darDeAltaTarea(String titulo, String descripcion, String responsable, int prioridad, double coste, int facturacion,double var, int resultado, String id, int horas, int tipo  ){

        Tarea tarea=new Tarea(titulo,descripcion,responsable,prioridad, coste, facturacion, var, resultado, id, horas, tipo);

        try {
            proyecto.anyadirTarea(tarea);
        } catch (ListaVaciaException listaVaciaException) {
            listaVaciaException.printStackTrace();
        }
    }
    public Tarea buscarTarea(String titulo){
        for(Tarea t:proyecto.getListaTareas()){
            if(t.getClave().equals(titulo)){
                return t;
            }
        }
        return null;
    }
    public void setProyecto(Proyecto proyecto){
        this.proyecto=proyecto;
    }

    public void guardarProyecto() throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/java/agenda.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
        cerrarPrograma=true;
    }


  /*  public Persona encontrarPersona(String dni) throws ListaVaciaException {
        Persona persona=proyecto.buscarPersona(dni);
        if(persona==null) {
            System.out.println("Esta persona no existe. Se va a crear:");
            darDeAltaPersona(persona);
        }
        return persona;

    }*/
    public void promptEnterKey(){
        System.out.println("Pulsa \"ENTER\" para continuar...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public boolean isCerrarPrograma() {
        return cerrarPrograma;
    }

    public String mostrarPersonasAsignadas(Tarea tarea){
        String personas = "";
        ArrayList<Persona> listaPersonas=tarea.getPersonasAsignadas();
        if(listaPersonas.size()>0) {
            for (Persona persona : listaPersonas) {
                personas += "\n" + persona.getNombre();
            }
        } else personas="No hay personas asignadas";
        return personas;
    }
    public String mostrarTarea(Tarea tarea){
        return "Título de la tarea: " + tarea.getTitulo()
                + "\nResponsable: " + tarea.getResponsable()
                + "\nPersonas asignadas: \n" + mostrarPersonasAsignadas(tarea)
                + "\n" + (tarea.isEsFinalizada()?"Clases.Tarea finalizada.":"Clases.Tarea sin finalizar")
                + "\n" + tarea.getResultado().mostrarResultadoEspecifico() +"\n";
    }
    public void finalizarTarea(Tarea tarea){
        tarea.finalizarTarea();
    }
    public void introducirEliminarPersonaDeTarea(){
        System.out.println("Indicame el DNI de la persona que quieres modificar: ");
        String dni=leerString();
        Persona persona=proyecto.buscarPersona(dni);
        System.out.println("1 - Introducir persona en tarea.\n2- Eliminar persona de tarea.");
        int opcion=leerInt();
        System.out.println("Escribe con precisión el titulo de la tarea.");
        String titulo=leerString();
        Tarea tarea= proyecto.buscarTarea(titulo);
        if(opcion==1){
            tarea.anyadirPersonasAsignadas(persona);
            persona.añadirTareaAPersona(tarea);
        } else {
            tarea.eliminarPersonasAsignadas(persona);
            persona.eliminarTareaDePersona(tarea);
        }
    }

    public void listarPersonas(){
        for(Persona persona:proyecto.getListaPersonas()){
            System.out.println(persona.getNombre() + " " + persona.getCorreo());
        }
    }

    public void listarTareas(){
        for(Tarea tarea:proyecto.getListaTareas()){
            System.out.println(mostrarTarea(tarea));
        }
    }


    public  String leerString(){
        return sc.next();
    }

    public  int leerInt(){
        return sc.nextInt();
    }

    public Double leerDouble(){
        return sc.nextDouble();
    }


    public  Proyecto cargarProyecto() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/main/java/agenda.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        proyecto = (Proyecto) ois.readObject();
        ois.close();
        return proyecto;
    }

    public void pedirNombreTarea(){
        System.out.println("Introduce el nombre de la Tarea: ");

    }
    public void nombresTareas(){
        for(Tarea t : proyecto.getListaTareas() ) {
            System.out.println(t.toString());
        }
    }
    public void setTareaFinalizada(int index){
        proyecto.getListaTareas().get(index).setEsFinalizada(true);
    }
    public Tarea getUltimaTarea(){
        if(proyecto.getListaTareas()!=null) {
            return proyecto.getListaTareas().get(proyecto.getListaTareas().size() - 1);
        }
        return null;
    }
    public void pedirNombrePersona(){
        System.out.println("Introduce el nombre del responsable: ");
    }
    public String[] getNombreTareas(){
        String[] nombreTareas=new String[100];
        for(int i=0; i<proyecto.getListaTareas().size()-1;i++){
            nombreTareas[i]=proyecto.getListaTareas().get(i).toString()+"\n";
        }

        return nombreTareas;
    }
}
