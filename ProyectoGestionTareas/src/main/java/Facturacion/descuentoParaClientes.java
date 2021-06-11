package Facturacion;

public class descuentoParaClientes implements Facturacion {
    double descuento;
    double coste;
    public descuentoParaClientes(double descuento, double coste){
        this.descuento=descuento;
        this.coste=coste;

    }

    @Override
    public double calcular() {
        return coste-coste*(descuento/100);
    }
}
