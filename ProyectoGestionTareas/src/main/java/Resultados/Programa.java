package Resultados;

import java.io.Serializable;

public class Programa extends ResultadoTarea implements Serializable, Resultado {
    private String lenguajeEmpleado;
    private int numLineas;
    private int numModulos;



    public Programa(String id, int numhoras, String tipoResultado){
        super(id,numhoras,tipoResultado);
    }
    public Programa(String lenguajeEmpleado, int numLineas, int numModulos) {
        this.lenguajeEmpleado=lenguajeEmpleado;
        this.numLineas=numLineas;
        this.numModulos=numModulos;
    }

    public int getNumHoras(){
        return super.getNumeroEsperadoHoras();
    }
    public String getTipoConsumo(){
        return super.getResultadoInternoExterno();
    }

    public void setLenguajeEmpleado(String lenguajeEmpleado) {
        this.lenguajeEmpleado = lenguajeEmpleado;
    }

    public void setNumLineas(int numLineas) {
        this.numLineas = numLineas;
    }

    public void setNumModulos(int numModulos) {
        this.numModulos = numModulos;
    }

    @Override
    public String mostrarResultadoEspecifico(){
        return "\n\tLenguaje:          " + lenguajeEmpleado
                + "\n\tNumero de Lineas:  " + numLineas
                + "\n\tNumero de Módulos: " + numModulos;
    }

}
