package Facturacion;

public class consumoInterno implements Facturacion {
    private double coste;
    public consumoInterno(double coste){
        this.coste=coste;
    }
    @Override
    public double calcular() {
        return coste;
    }

}
