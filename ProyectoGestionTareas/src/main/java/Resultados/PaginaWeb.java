package Resultados;

import java.io.Serializable;

public class PaginaWeb extends ResultadoTarea implements Serializable, Resultado {
    private String estaticaDinamica;
    private String lenguaje;
    private String backend;

    public int getNumHoras(){
        return super.getNumeroEsperadoHoras();
    }
    public String getTipoConsumo(){
        return super.getResultadoInternoExterno();
    }

    public PaginaWeb(String id, int numhoras, String tipoResultado){
        super(id,numhoras,tipoResultado);
    }
    public PaginaWeb(String sD, String leng, String back){
        estaticaDinamica=sD;
        lenguaje=leng;
        backend=back;
    }

    public void setEstaticaDinamica(String estaticaDinamica) {
        this.estaticaDinamica = estaticaDinamica;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public PaginaWeb(String identificador, int numHoras, String tipoResultado,
                     String estaticaDinamica, String lenguaje, String backend) {
        super(identificador,numHoras,tipoResultado);
        this.estaticaDinamica=estaticaDinamica;
        this.lenguaje=lenguaje;
        this.backend=backend;
    }


    @Override
    public String mostrarResultadoEspecifico(){
        return "\n\tTipo:     " + estaticaDinamica
                + "\n\tLenguaje: " + lenguaje
                + "\n\tBack end: " + backend;
    }

}
