package Modelo;

import Clases.*;
import Excepciones.*;
import Facturacion.*;
import Resultados.*;
import Vista.MenuGestor;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Modelo implements Serializable{
    private  String nombreProyecto;
    private  Proyecto proyecto;
    static Scanner sc =new Scanner(System.in);
    public boolean cerrarPrograma=false;

    public Modelo(){
        proyecto=new Proyecto();
    }
    public Modelo(String nombre){
        proyecto=new Proyecto(nombre);
        this.nombreProyecto=nombre;
    }


    public ArrayList<Tarea> getListTareas(){
        return proyecto.getListaTareas();
    }
    public ArrayList<Persona> getListaPersonas(){
        return proyecto.getListaPersonas();
    }

    public void darDeAltaPersona(String dni, String nombre, String correo) throws ListaVaciaException, PersonaRepetidaException {
        Persona nuevaPersona= new Persona(dni, nombre, correo);
        if(sePuedeAnyadir(nuevaPersona)) {
            try {
                proyecto.anyadirPersona(nuevaPersona);
            } catch (ListaVaciaException listaVaciaException) {
                listaVaciaException.printStackTrace();
            }
        }
    }
    public String nombreTarea(int index){
        return proyecto.getListaTareas().get(index).toString();
    }

    public void borrarPersona(int index) {
        proyecto.getListaPersonas().remove(index);
    }

    public Persona getUltimaPersona(){
        if(proyecto.getListaPersonas()!=null) {
            return proyecto.getListaPersonas().get(proyecto.getListaPersonas().size() - 1);
        }
        return null;
    }
    public void darDeAltaTarea(String titulo, String descripcion, String responsable, int prioridad, double coste, int facturacion,double var, int resultado, String id, int horas, int tipo  ) throws TareaRepetidaException{

        Tarea tarea=new Tarea(titulo,descripcion,responsable,prioridad, coste, facturacion, var, resultado, id, horas, tipo);
        sePuedeAnyadir(tarea);
        if(sePuedeAnyadir(tarea)) {
            try {
                proyecto.anyadirTarea(tarea);
            } catch (ListaVaciaException listaVaciaException) {
                listaVaciaException.printStackTrace();
            }
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



    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public boolean isCerrarPrograma() {
        return cerrarPrograma;
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


    public  Modelo cargarProyecto() throws IOException, ClassNotFoundException {
        Modelo m=this;
        try {
            FileInputStream fis = new FileInputStream("agenda.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            m = (Modelo) ois.readObject();
            ois.close();
        }catch(ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return m;
    }

    public void guardarProyecto() throws IOException {
        FileOutputStream fos = new FileOutputStream("agenda.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();

    }

    public void pedirNombreTarea(){
        System.out.println("Introduce el nombre de la Tarea: ");

    }
    public void nombresTareas(){
        for(Tarea t : proyecto.getListaTareas() ) {
            System.out.println(t.toString());
        }
    }

    public void anyadirPersonaATarea(Tarea t, Persona p) {
        t.anyadirPersonasAsignadas(p);
    }
    public void anyadirTareaAPersona(Persona p, Tarea t) {
        p.anyadirTareasAsignadas(t);
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

    public boolean sePuedeAnyadir(Persona p){
        String dni=p.getDni();
        String correo=p.getCorreo();
        for(Persona personas:proyecto.getListaPersonas()){
            if((personas.getCorreo().equals(correo) && !personas.getCorreo().equals("(FALTA CORREO)")) || personas.getDni().equals(dni)){
                return false;
            }
        }
        return true;
    }

    public boolean sePuedeAnyadir(Tarea t){
        String titulo=t.getTitulo();
        for(Tarea tareas:proyecto.getListaTareas()){
            if(tareas.getTitulo().equals(titulo)){
                return false;
            }
        }
        return true;
    }
    private ArrayList<String> resultados=new ArrayList<>();

    public void eliminarPersonaDeTarea(Tarea t, int index){
        t.eliminarPersonasAsignadas(index);
    }

    public String getResultado(int index){
        return resultados.get(index);
    }

    public void addResultados(String s){
        resultados.add(s);
    }

    public void quitarResultado(int index){
        resultados.remove(index);
    }

    public ArrayList<Persona> getPersonasDeUnaTarea(Tarea t){
        return t.getPersonasAsignadas();
    }

    public ArrayList<Tarea> getTareasDeUnaPersona(Persona p){
        return p.getListaTareas();
    }

    public ArrayList<Persona> getPersonasDeUnaTarea(int index){
        return proyecto.getListaTareas().get(index).getPersonasAsignadas();
    }

    public ArrayList<Tarea> getTareasDeUnaPersona(int index){
        return proyecto.getListaPersonas().get(index).getListaTareas();
    }
    public void eliminarTareaDePersona(Persona p, int index){
        p.eliminarTareaAsignada(index);
    }
    public void setResultado(Resultado r, Tarea t){
       t.setResultado(r);
    }
    public Tarea getTarea(int index){
        return proyecto.getListaTareas().get(index);
    }
    public Persona getPersona(int index){
        return proyecto.getListaPersonas().get(index);
    }
    public String getID(int index){
        return proyecto.getListaTareas().get(index).getId();
    }
    public String getTipoTarea(int index){
        return proyecto.getListaTareas().get(index).getInternoExterno();
    }
    public String getDescripcion(int index){
        return proyecto.getListaTareas().get(index).getDescripcion();
    }
    public Date getFechaCreacion(int index){
        return proyecto.getListaTareas().get(index).getFechaCreacion();
    }
    public String getResponsable(int index){
        return proyecto.getListaTareas().get(index).getResponsable();
    }
    public void addEtiqueta(String s, Tarea t){
        t.anyadirEtiqueta(s);
    }
    public String getEtiquetas(int index){
        String etiquetas="";
        for(int i=0; i<proyecto.getListaTareas().get(index).getEtiquetas().size();i++){
            etiquetas+="#"+(proyecto.getListaTareas().get(index).getEtiquetas().get(i)+" ");
        }
        return etiquetas;
    }

}
