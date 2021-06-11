package Clases;

import Facturacion.Facturacion;
import Listas.tieneClave;
import Listas.tieneLista;
import Resultados.*;
import Facturacion.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tarea implements tieneLista, tieneClave, Facturacion, Serializable {
    private String titulo;
    private String descripcion;
    private ArrayList<Persona> personasAsignadas;
    private String responsable;
    private int prioridad;
    private Date fechaCreacion;
    private Date fechaFinalizacion;
    private boolean esFinalizada;
    private Resultado resultado;
    private Etiquetas etiquetas;
    private double coste;
    private Facturacion facturacion;


    //####CONSTRUCTOR####

    public Tarea(String titulo, String descripcion, String responsable, int prioridad, double coste, int facturacion,double var, int resultado, String id, int horas, int tipo ){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.responsable=responsable;
        this.prioridad=prioridad;
        this.fechaCreacion= new Date();
        this.esFinalizada=false;
        this.coste=coste;

        String internoExterno="Interno";
        if(resultado==1){
            internoExterno="Externo";
        }

        switch (facturacion){
            case 0: this.setFacturacion(new consumoInterno(coste));
            case 1: this.setFacturacion(new descuentoParaClientes(var, coste));
            case 2: this.setFacturacion(new sobrecosteTareaUrgente(var, coste));
        }
        switch (tipo){
            case 0: this.setResultado(new Biblioteca(id, horas, internoExterno));
            case 1: this.setResultado(new Documentacion(id, horas, internoExterno));
            case 2: this.setResultado(new PaginaWeb(id, horas, internoExterno));
            case 3: this.setResultado(new Programa(id, horas, internoExterno));
        }


        this.personasAsignadas=new ArrayList<Persona>();
        this.etiquetas=new Etiquetas();
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPersonasAsignadas(ArrayList<Persona> personasAsignadas) {
        this.personasAsignadas = personasAsignadas;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public void setEsFinalizada(boolean esFinalizada) {
        this.esFinalizada = esFinalizada;
    }

    public void setEtiquetas(Etiquetas etiquetas) {
        this.etiquetas = etiquetas;
    }



    public String toString(){
        return this.titulo;
    }
    //#####GETTERS#####
    public boolean isEsFinalizada() {
        return esFinalizada;
    }
    public Resultado getResultado() {
        return resultado;
    }
    public String getResponsable() {
        return responsable;
    }
    public ArrayList<Persona> getPersonasAsignadas(){
        return personasAsignadas;
    }
    public String getTitulo(){
        return titulo;
    }
    public double getCoste(){
        return coste;
    }
    public Facturacion getFacturacion() {
        return facturacion;
    }
    @Override
    public List getLista() {
        return personasAsignadas;
    }
    @Override
    public Object getClave() {
        return titulo;
    }

    public ArrayList<String> getEtiquetas(){
        return etiquetas.getEtiquetas();
    }

    @Override
    public double calcular(){
        return facturacion.calcular();
    }

    public void anyadirPersonasAsignadas(Persona persona){
        this.personasAsignadas.add(persona);
    }

    public void eliminarPersonasAsignadas(int index){
        this.personasAsignadas.remove(index);
    }

    public void eliminarPersonaAsignada(int index){
       personasAsignadas.remove(index);
    }


    public void añadirEtiqueta(String etiqueta){
        etiquetas.añadirEtiqueta(etiqueta);
    }

    //SETTERS//
    public void setResultado(Resultado resultado){
        this.resultado=resultado;
    }

    public void setFacturacion(Facturacion facturacion){
        this.facturacion=facturacion;
    }

    public void setCoste(double coste){
        this.coste=coste;
    }

    public void finalizarTarea(){
        esFinalizada=true;
        fechaFinalizacion=new Date();
    }





}
