package Resultados;

import java.io.Serializable;

public class Documentacion extends ResultadoTarea implements Serializable, Resultado {
    private String formato;
    private int numPaginas;
    private double espacioEnDisco;

    public int getNumHoras(){
        return super.getNumeroEsperadoHoras();
    }
    public String getTipoConsumo(){
        return super.getResultadoInternoExterno();
    }

    public Documentacion(String id, int numhoras, String tipoResultado){
        super(id,numhoras,tipoResultado);
    }
    public Documentacion(String form, int num, double espacio){
        formato=form;
        numPaginas=num;
        espacioEnDisco=espacio;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setEspacioEnDisco(double espacioEnDisco) {
        this.espacioEnDisco = espacioEnDisco;
    }

    public Documentacion(String identificador, int numHoras, String tipoResultado,
                         String formato, int numPaginas, double espacioEnDisco){
        super(identificador,numHoras,tipoResultado);
        this.formato=formato;
        this.numPaginas=numPaginas;
        this.espacioEnDisco=espacioEnDisco;
    }


    @Override
    public String mostrarResultadoEspecifico(){
        return  "\n\tFormato:           " + formato
                + "\n\tNúmero de Páginas: " + numPaginas
                + "\n\tEspacio en disco:  " + espacioEnDisco;
    }
}
