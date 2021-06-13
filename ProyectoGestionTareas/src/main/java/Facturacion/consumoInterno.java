package Facturacion;

import java.io.Serializable;

public class consumoInterno implements Facturacion, Serializable {
    private double coste;
    public consumoInterno(double coste){
        this.coste=coste;
    }
    @Override
    public double calcular() {
        return coste;
    }

}
