package Resultados;

import java.io.Serializable;

public abstract class ResultadoTarea implements Serializable {
    private  String identificador;
    private  int numeroEsperadoHoras;
    private  String resultadoInternoExterno;
    public ResultadoTarea(){
    }
    public ResultadoTarea(String identificador, int numeroEsperadoHoras, String resultadoInternoExterno){
        this.identificador=identificador;
        this.numeroEsperadoHoras=numeroEsperadoHoras;
        this.resultadoInternoExterno=resultadoInternoExterno;
    }
    public void setLenguajeEmpleado(){

    }
    public String getIdentificador() {
        return identificador;
    }

    public int getNumeroEsperadoHoras() {
        return numeroEsperadoHoras;
    }

    public String getResultadoInternoExterno() {
        return resultadoInternoExterno;
    }

    public String mostrarResultado(){
        return "Resultado: ID=\"" + getIdentificador() + "\" de duración " +
                getNumeroEsperadoHoras() + " horas, (" + getResultadoInternoExterno() + ")"
                + mostrarResultadoEspecifico();
    }

    public abstract String mostrarResultadoEspecifico();
}
